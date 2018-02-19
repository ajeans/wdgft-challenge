package com.github.ajeans.wdgft;

import com.github.ajeans.wdgft.model.Combination;
import com.github.ajeans.wdgft.model.Comparison;

public class MasterMindRunner {

    private static final int GAME_DURATION = 10;

    private static int round = 0;

    public static void main(String[] args) {
        // TODO computer picks combination randomly
        Combination computer = new Combination("RYBO");
        // TODO request input from user
        Combination request = new Combination("RBOV");
        // TODO check request against our combination
        Comparison comparison = new Comparison(computer, request);
        // TODO output result
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

}
