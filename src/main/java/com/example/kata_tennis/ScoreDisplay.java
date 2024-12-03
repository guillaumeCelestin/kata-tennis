package com.example.kata_tennis;

import org.springframework.stereotype.Component;

@Component
public class ScoreDisplay {

    public final String DEUCE = "Deuce";
    public final String PLAYEURA = "A";
    public final String PLAYEURB = "B";
    public final String ADVANTAGE = "Advantage Player %s";
    public final String VICTORY = "Player %s wins the game";

    public String display(int scoreA, int scoreB, boolean deuce, boolean advantageA, boolean advantageB, boolean gameOver) {
        if (gameOver) {
            return (scoreA > scoreB) ? String.format(VICTORY, PLAYEURA) : String.format(VICTORY, PLAYEURB);
        }
        if (deuce) {
            return DEUCE;
        }
        if (advantageA) {
            return String.format(ADVANTAGE, PLAYEURA);
        }
        if (advantageB) {
            return String.format(ADVANTAGE, PLAYEURB);
        }
        return "Player A: " + convertToTennisScore(scoreA) + " / Player B: " + convertToTennisScore(scoreB);

    }

    static String convertToTennisScore(int score) {
        String output;
        switch(score) {
            case 0 -> output = "0";
            case 1 -> output = "15";
            case 2 -> output = "30";
            case 3 -> output = "40";
            default -> output = "";
        }
        return output;
    }

}