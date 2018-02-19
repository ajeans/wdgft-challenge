package com.github.ajeans.wdgft.model;

import java.util.LinkedList;
import java.util.List;

public class Combination {

    private static final int COMBINATION_SIZE = 4;

    private List<Token> tokens;

    public Combination(String combination) {
        assert combination != null;
        assert combination.length() == COMBINATION_SIZE;
        this.tokens = new LinkedList<Token>();
        for (int i = 0 ; i < COMBINATION_SIZE ; i++) {
            char c = combination.charAt(i);
            this.tokens.add(Token.valueOf(String.valueOf(c)));
        }
    }

}
