package com.github.ajeans.wdgft;

import com.github.ajeans.wdgft.model.Combination;
import com.github.ajeans.wdgft.model.Comparison;
import com.github.ajeans.wdgft.model.TokenMatch;

public class MasterMindRunner {

    private static final int GAME_DURATION = 10;

    private static int round = 0;

    private static Combination computer;

    public static void main(String[] args) {
        // TODO computer picks combination randomly
        computer = new Combination("RYBO");
        Comparison comparison = playRound();
        if (comparison.isWinner()) {
            System.out.println("YOU WIN");
            System.exit(0);
        } else if (round == GAME_DURATION) {
            System.out.println("YOU LOSE");
            System.exit(1);
        } else {
            round++;
        }
    }

    private static Comparison playRound() {
        // TODO request input from user
        Combination request = new Combination("RBOV");
        // TODO check request against our combination
        Comparison comparison = new Comparison(computer, request);
        // TODO output result
        displayResult(request, comparison);
        return comparison;
    }

    private static void displayResult(Combination request, Comparison comparison) {
        long countColorAndPosition = comparison.getMatches().stream()
                .mapToLong(match -> (match == TokenMatch.COLOR_AND_POSITION) ? 1 : 0).count();
        long countColorOnly = comparison.getMatches().stream().mapToLong(match -> (match == TokenMatch.COLOR) ? 1 : 0)
                .count();
        String output = "|" + request.toString() + "| " + countColorAndPosition + " | " + countColorOnly + " | " + round
                + "/" + GAME_DURATION + " |";
        System.out.println(output);
    }

}
