package org.tennis;

import org.tennis.service.ScoreComputeService;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a sequence of points as an argument (e.g., 'ABABAA')");
            return;
        }
        ScoreComputeService.tennisScoreCompute(args[0]);
    }

}
