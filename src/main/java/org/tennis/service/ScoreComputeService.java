package org.tennis.service;

import org.tennis.exception.TennisScoreException;

import java.util.Map;

public class ScoreComputeService {

    /**
     * Table de correspondance entre le nombre de points et le score affiché au tennis.
     * 0 -> 0, 1 -> 15, 2 -> 30, 3 -> 40
     */
    static Map<Integer, Integer> scoreMap = Map.of(
            0, 0,
            1, 15,
            2, 30,
            3, 40
    );

    /**
     * Calcule et affiche le score d'un jeu de tennis à partir d'une séquence de points.
     *
     * @param input Chaîne de caractères composée de 'A' et 'B' représentant les points gagnés par chaque joueur.
     *              'A' pour le joueur A, 'B' pour le joueur B.
     * @throws TennisScoreException si l'entrée est nulle, vide ou contient un caractère invalide.
     */
    public static void tennisScoreCompute(String input) {

        if (input == null || input.isEmpty()) {
            throw new TennisScoreException("Input cannot be null or empty");
        }

        int playerAScore = 0;
        int playerBScore = 0;

        for (var step: input.toUpperCase().toCharArray()) {
            if (step == 'A') {
                playerAScore++;
            } else if (step == 'B') {
                playerBScore++;
            } else {
                throw new TennisScoreException("Invalid character: " + step);
            }

            if (!printScore(playerAScore, playerBScore)) {
                break;
            }
        }
    }

    /**
     * Affiche le score et indique si la partie continue.
     *
     * @param playerAScore Nombre de points du joueur A
     * @param playerBScore Nombre de points du joueur B
     * @return true si la partie continue, false si un joueur a gagné
     */
    private static boolean printScore(int playerAScore, int playerBScore) {
        if (playerAScore < 4 && playerBScore < 4  && (playerAScore + playerBScore < 6)) {
            System.out.printf("Player A: %d / Player B: %d%n", scoreMap.get(playerAScore), scoreMap.get(playerBScore));
            return true;
        } else if (playerAScore == playerBScore) {
            System.out.println("DEUCE");
            return true;
        } else if (playerAScore == playerBScore + 1) {
            System.out.println("Advantage Player A");
            return true;
        } else if (playerBScore == playerAScore + 1) {
            System.out.println("Advantage Player B");
            return true;
        } else if (playerAScore >= playerBScore + 2) {
            System.out.println("Player A wins the game");
            return false;
        } else if (playerBScore >= playerAScore + 2) {
            System.out.println("Player B wins the game");
            return false;
        }
        return true;
    }

}
