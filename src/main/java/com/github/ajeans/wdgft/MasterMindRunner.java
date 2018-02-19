package com.github.ajeans.wdgft;

import com.github.ajeans.wdgft.model.Combination;
import com.github.ajeans.wdgft.model.Comparison;

public class MasterMindRunner {

    public static void main(String[] args) {
        // TODO computer picks combination randomly
        Combination computer = new Combination("RYBO");
        // TODO request input from user
        Combination request = new Combination("RBOV");
        // TODO check request against our combination
        Comparison comparison = new Comparison(computer, request);
        // TODO output result
    }

}
