package com.example.jacocoexample.board.appilcation;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.jacocoexample.board.domain.Board;
import com.example.jacocoexample.board.domain.BoardRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
@Transactional
public class BoardCreator {

    private final BoardRepository boardRepository;

    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

}
