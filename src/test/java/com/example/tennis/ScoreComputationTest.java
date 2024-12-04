package com.example.tennis;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
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


}
