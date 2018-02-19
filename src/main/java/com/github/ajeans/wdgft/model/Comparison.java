package com.github.ajeans.wdgft.model;

import java.util.LinkedList;
import java.util.List;

public class Comparison {

    private List<TokenMatch> matches;

    public Comparison(Combination expected, Combination proposal) {
        // TODO do comparison of combinations here
        this.matches = new LinkedList<>();
        this.matches.add(TokenMatch.COLOR);
        this.matches.add(TokenMatch.NOTHING);
        this.matches.add(TokenMatch.COLOR_AND_POSITION);
        this.matches.add(TokenMatch.NOTHING);
    }

    public boolean isWinner() {
        return this.matches.stream().allMatch(tokenMatch -> tokenMatch == TokenMatch.COLOR_AND_POSITION);
    }

}
