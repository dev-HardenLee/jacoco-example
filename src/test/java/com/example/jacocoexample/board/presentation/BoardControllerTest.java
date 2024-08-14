package com.example.jacocoexample.board.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.example.jacocoexample.board.presentation.dto.BoardCreate;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SpringBootTest
class BoardControllerTest {

    @Autowired
    private WebApplicationContext context;

    private ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = webAppContextSetup(context)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .build();
    }

    @Test
    void saveBoard() throws Exception {
        // given
        BoardCreate boardCreate = new BoardCreate("title", "content", "notice");

        String requestBody = objectMapper.writeValueAsString(boardCreate);

        // when
        ResultActions result = mockMvc.perform(
                post("/api/v1/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );

        // then
        result
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void saveBoardException() throws Exception {
        // given
        BoardCreate boardCreate = new BoardCreate("title", "content", "free");

        String requestBody = objectMapper.writeValueAsString(boardCreate);

        // when
        ResultActions result = mockMvc.perform(
                post("/api/v1/board")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
        );

        // then
        result
                .andDo(print())
                .andExpect(status().isBadRequest());
    }


}