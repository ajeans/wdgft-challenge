package com.github.ajeans.wdgft.model;

public enum Token {
    R("RED"), Y("YELLOW"), B("BLUE"), O("ORANGE"), V("GREEN"), N("BLACK");

    private String id;

    Token(String frenchId) {
        this.id = frenchId;
    }

    public String getId() {
        return this.id;
    }

}
