package com.example.jacocoexample.board.domain;

public enum BoardType {

    NOTICE,
    COMMUNITY,
    QNA;

    public static BoardType of(String type) {
        switch (type) {
            case "notice":  return NOTICE;
            case "community":  return COMMUNITY;
            case "qna":    return QNA;
        }

        throw new IllegalArgumentException("Invalid Board Type: " + type);
    }


}
