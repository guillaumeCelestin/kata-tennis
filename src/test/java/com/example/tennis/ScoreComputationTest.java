package com.example.tennis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ScoreComputationTest {

    @Autowired
    private ScoreComputation computation;

    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void play_one_round_shouldWork() {
        computation.playerAScore();
        String expected = "Player A: 15 / Player B: 0";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }

    @Test
    public void play_four_rounds_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        String expected = "Player A: 40 / Player B: 15";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }

    @Test
    public void play_egalite_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        String expected = "Deuce";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }
    @Test
    public void play_advantageA_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerAScore();
        String expected = "Advantage Player A";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }

    @Test
    public void play_advantageB_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        String expected = "Advantage Player B";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }

    @Test
    public void play_winA_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerAScore();
        computation.playerAScore();
        String expected = "Player A wins the game";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }

    @Test
    public void play_winB_shouldWork() {
        computation.playerAScore();
        computation.playerAScore();
        computation.playerAScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        computation.playerBScore();
        String expected = "Player B wins the game";
        List<String> out = Arrays.asList(outContent.toString().split(System.lineSeparator()));
        String result = out.stream().reduce((first, second) -> second)
                .orElse(null);
        assertEquals(result,expected);
    }



}
