package com.example.jacocoexample.board.appilcation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jacocoexample.board.domain.Board;
import com.example.jacocoexample.board.domain.BoardType;
import com.example.jacocoexample.board.presentation.dto.BoardCreate;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardCreator boardCreator;

    @Transactional
    public Long saveBoard(BoardCreate boardCreate) {
        Board board = Board.create()
                .title(boardCreate.title())
                .content(boardCreate.content())
                .type(BoardType.of(boardCreate.type()))
                .build();

        return boardCreator.saveBoard(board).getId();
    }

}
