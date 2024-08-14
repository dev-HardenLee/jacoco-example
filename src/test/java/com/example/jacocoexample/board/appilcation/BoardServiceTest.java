package com.example.jacocoexample.board.appilcation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.jacocoexample.board.domain.Board;
import com.example.jacocoexample.board.domain.BoardRepository;
import com.example.jacocoexample.board.domain.BoardType;
import com.example.jacocoexample.board.presentation.dto.BoardCreate;
import org.junit.jupiter.api.Test;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void saveBoard() throws Exception {
        // given
        BoardCreate boardCreate = new BoardCreate("test title", "test content", "notice");

        // when
        Long id = boardService.saveBoard(boardCreate);

        // then
        Board savedBoard = boardRepository.findById(id).orElseThrow();

        assertThat(savedBoard.getId()).isEqualTo(id);
    }

}