package com.example.tennis;

import com.example.tennis.exeption.WrongInputException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TennisGameTest {

    @Autowired
    TennisGame tennisgame;

    @Test
    public void testWrongParameters_shouldRaiseExcp() {
        Exception exception = assertThrows(WrongInputException.class, () -> {
            tennisgame.runGame("CAB");
        });

        String expectedMessage = "Input Invalide";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    public void testGoodParameters_shouldWork() {
        assertDoesNotThrow(() -> {
            tennisgame.runGame("ABAB");
        });

    }
}
