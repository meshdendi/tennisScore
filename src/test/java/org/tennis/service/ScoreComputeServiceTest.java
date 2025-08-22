package org.tennis.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.tennis.exception.TennisScoreException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreComputeServiceTest {

    @Test
    @DisplayName("Test DEUCE")
    void testDeuce() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("ABABAB");
        String output = out.toString();
        assertTrue(output.contains("DEUCE"));
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test Advantage Player A")
    void testAdvantagePlayerA() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("ABABABA");
        String output = out.toString();
        assertTrue(output.contains("Advantage Player A"));
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test Advantage Player B")
    void testAdvantagePlayerB() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("ABABABB");
        String output = out.toString();
        assertTrue(output.contains("Advantage Player B"));
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test victoire Player A")
    void testPlayerAWins_oneSidedGame() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("AAAA");
        String output = out.toString();
        assertTrue(output.contains("Player A wins the game"));
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test victoire Player B")
    void testPlayerBWins_oneSidedGame() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("BBBB");
        String output = out.toString();
        assertTrue(output.contains("Player B wins the game"));
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test victoire Player B")
    void testPlayerAWins_inputTooLongIgnoreEnd() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        ScoreComputeService.tennisScoreCompute("AAAAAAAAAAAAAA");
        String output = out.toString();
        assertTrue(output.contains("Player A wins the game"));
        System.setOut(System.out);
    }

    @ParameterizedTest
    @ValueSource(strings = {"C", "ABAC", "AB1", "A B"})
    @DisplayName("Invalid player input should throw TennisScoreException")
    void testInvalidPlayerException(String input) {
        assertThrows(TennisScoreException.class, () -> ScoreComputeService.tennisScoreCompute(input));
    }

}
