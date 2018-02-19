package com.github.ajeans.wdgft.model;

public enum Token {
    RED('R'), YELLOW('Y'), BLUE('B'), ORANGE('O'), GREEN('V'), BLACK('N');

    private char id;

    Token(char frenchId) {
        this.id = frenchId;
    }

    public char getId() {
        return id;
    }

}
