package com.github.ajeans.wdgft.model;

import java.util.LinkedList;
import java.util.List;

public class Comparison {

    private List<TokenMatch> matches;

    public Comparison(Combination expected, Combination proposal) {
        this.matches = new LinkedList<>();
        for (int i = 0; i < Combination.COMBINATION_SIZE; i++) {
            if (proposal.equalsAt(i, expected.getAt(i))) {
                this.matches.add(TokenMatch.COLOR_AND_POSITION);
            } else if (expected.contains(proposal.getAt(i))) {
                this.matches.add(TokenMatch.COLOR);
            } else {
                this.matches.add(TokenMatch.NOTHING);
            }
        }
    }

    public List<TokenMatch> getMatches() {
        return matches;
    }

    public boolean isWinner() {
        return this.matches.stream().allMatch(tokenMatch -> tokenMatch == TokenMatch.COLOR_AND_POSITION);
    }

}
