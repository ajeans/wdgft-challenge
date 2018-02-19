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
        System.out.println("Computer has a secret, please guess it");

        boolean hasWon = false;
        Comparison comparison = null;
        while (!hasWon && round < GAME_DURATION) {
            comparison = playRound();
            round++;
        }
        if (comparison.isWinner()) {
            System.out.println("YOU WIN");
            System.exit(0);
        } else if (round == GAME_DURATION) {
            System.out.println("YOU LOSE");
            System.exit(1);
        }
    }

    private static Comparison playRound() {
        // Request combination
        Combination request = requestCombination();
        // Check request against our combination
        Comparison comparison = new Comparison(computer, request);
        // Output result
        displayResult(request, comparison);
        return comparison;
    }

    private static Combination requestCombination() {
        System.out.println("Please input your combination");
        String inputLine = System.console().readLine();
        return new Combination(inputLine);
    }

    private static void displayResult(Combination request, Comparison comparison) {
        long countColorAndPosition = comparison.getMatches().stream()
                .filter(match -> match == TokenMatch.COLOR_AND_POSITION).count();
        long countColorOnly = comparison.getMatches().stream().filter(match -> match == TokenMatch.COLOR).count();
        String output = "|" + request.toString() + "| " + countColorAndPosition + " | " + countColorOnly + " | " + round
                + "/" + GAME_DURATION + " |";
        System.out.println(output);
    }

}
