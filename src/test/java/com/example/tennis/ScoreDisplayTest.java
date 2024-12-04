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
    public void convert_to_tennis_Score_shouldWork() {
        ScoreGame game = new ScoreGame(3,2);
        String expected = "Player A: 40 / Player B: 30";
        String result = display.display(game);
        assertEquals(result,expected);
    }


}
