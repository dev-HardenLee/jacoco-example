package com.example.jacocoexample.board.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jacocoexample.board.appilcation.BoardService;
import com.example.jacocoexample.board.presentation.dto.BoardCreate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public ResponseEntity<Void> saveBoard(@RequestBody BoardCreate boardCreate) {
        boardService.saveBoard(boardCreate);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
