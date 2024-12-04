package com.example.tennis;

import org.springframework.stereotype.Component;

@Component
public class ScoreDisplay {

    public final String DEUCE = "Deuce";
    public final String PLAYEURA = "A";
    public final String PLAYEURB = "B";
    public final String ADVANTAGE = "Advantage Player %s";
    public final String VICTORY = "Player %s wins the game";

    public String display(ScoreGame game) {
        if (game.isFin()) {
            return (game.getScoreA() > game.getScoreB()) ? String.format(VICTORY, PLAYEURA) : String.format(VICTORY, PLAYEURB);
        }
        if (game.isEgalite()) {
            return DEUCE;
        }
        if (game.isAdA()) {
            return String.format(ADVANTAGE, PLAYEURA);
        }
        if (game.isAdB()) {
            return String.format(ADVANTAGE, PLAYEURB);
        }
        return "Player A: " + convertToTennisScore(game.getScoreA()) + " / Player B: " + convertToTennisScore(game.getScoreB());

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