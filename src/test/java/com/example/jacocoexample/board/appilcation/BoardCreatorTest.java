package com.example.jacocoexample.board.appilcation;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

import com.example.jacocoexample.board.domain.Board;
import com.example.jacocoexample.board.domain.BoardRepository;
import com.example.jacocoexample.board.domain.BoardType;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Transactional
public class BoardCreatorTest {

    @Autowired
    private BoardCreator boardCreator;

    @Autowired
    private BoardRepository boardRepository;

    @Test
    void saveBoardNotice() throws Exception {
        // given
        Board board = Board.create()
                .title("test title")
                .content("test content")
                .type(BoardType.of("notice"))
                .build();

        // when
        boardCreator.saveBoard(board);

        // then
        Board savedBoard = boardRepository.findById(board.getId()).orElseThrow();

        assertEquals(savedBoard.getId(), board.getId());
    }

    @Test
    void saveBoardCommunity() throws Exception {
        // given
        Board board = Board.create()
                .title("test title")
                .content("test content")
                .type(BoardType.of("community"))
                .build();

        // when
        boardCreator.saveBoard(board);

        // then
        Board savedBoard = boardRepository.findById(board.getId()).orElseThrow();

        assertEquals(savedBoard.getId(), board.getId());
    }

    @Test
    void saveBoardQna() throws Exception {
        // given
        Board board = Board.create()
                .title("test title")
                .content("test content")
                .type(BoardType.of("qna"))
                .build();

        // when
        boardCreator.saveBoard(board);

        // then
        Board savedBoard = boardRepository.findById(board.getId()).orElseThrow();

        assertEquals(savedBoard.getId(), board.getId());
    }

}