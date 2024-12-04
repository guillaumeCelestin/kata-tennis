package com.example.tennis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ScoreDisplayTest {

    @Autowired
    private ScoreDisplay display;

    @Test
    public void convert_to_tennis_simple_Score_shouldWork() {
        ScoreGame game = new ScoreGame(3,2);
        String expected = "Player A: 40 / Player B: 30";
        String result = display.displayScore(game);
        assertEquals(result,expected);
    }

    @Test
    public void convert_to_tennis_Score_adA_shouldWork() {
        ScoreGame game = new ScoreGame(3,2);
        game.setAdA(true);
        String expected = "Advantage Player A";
        String result = display.displayScore(game);
        assertEquals(result,expected);
    }

    @Test
    public void convert_to_tennis_Score_winA_shouldWork() {
        ScoreGame game = new ScoreGame(4,2);
        game.setFin(true);
        String expected = "Player A wins the game";
        String result = display.displayScore(game);
        assertEquals(result,expected);
    }

    @Test
    public void convert_to_tennis_Score_deuce_shouldWork() {
        ScoreGame game = new ScoreGame(3,3);
        game.setEgalite(true);
        String expected = "Deuce";
        String result = display.displayScore(game);
        assertEquals(result,expected);
    }


}
