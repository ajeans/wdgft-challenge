package com.github.ajeans.wdgft.model;

import java.util.LinkedList;
import java.util.List;

public class Combination {

    protected static final int COMBINATION_SIZE = 4;

    private List<Token> tokens;

    /**
     * Randomly get a combination
     */
    public Combination() {
        this.tokens = new LinkedList<Token>();
        for (int i = 0; i < COMBINATION_SIZE; i++) {
            int tokenOrdinal = (int) Math.floor(Math.random() * (COMBINATION_SIZE + 1));
            this.tokens.add(Token.values()[tokenOrdinal]);
        }
    }

    public Combination(String combination) {
        assert combination != null;
        assert combination.length() == COMBINATION_SIZE;
        this.tokens = new LinkedList<Token>();
        for (int i = 0; i < COMBINATION_SIZE; i++) {
            char c = combination.charAt(i);
            this.tokens.add(Token.valueOf(String.valueOf(c)));
        }
    }

    public Token getAt(int position) {
        return this.tokens.get(position);
    }

    public boolean equalsAt(int position, Token token) {
        assert position < COMBINATION_SIZE;
        return this.tokens.get(position) == token;
    }

    public boolean contains(Token token) {
        return this.tokens.stream().anyMatch(it -> it == token);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Token token : tokens) {
            output.append(token.name());
        }
        return output.toString();
    }

}
