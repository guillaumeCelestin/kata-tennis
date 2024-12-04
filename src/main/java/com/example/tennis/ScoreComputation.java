package com.example.tennis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
class ScoreComputation {
    private final ScoreDisplay display;
    private final ScoreGame game;
    Logger logger = LoggerFactory.getLogger(ScoreComputation.class);

    public ScoreComputation(ScoreDisplay display) {
        this.display = display;
        this.game = new ScoreGame(0, 0);
    }


    public void playerAScore() {
        if (game.isFin()) {
            return;
        }

        if (game.isEgalite()) {
            if (!game.isAdA() && !game.isAdB()) {
                game.setAdA(true);
                game.setEgalite(false);
            } else if (game.isAdB()) {
                game.setAdB(false);
            }
        } else {
            if (!game.isAdB()) {
                game.setScoreA(game.getScoreA() + 1);
            }
            if (game.getScoreA() == 3 && game.getScoreB() == 3) {
                game.setEgalite(true);
                game.setAdB(false);
            } else if (game.getScoreA() == 4) {
                game.setFin(true);
            }
        }

        showResult();
    }

    public void playerBScore() {
        if (game.isFin()) {
            return;
        }

        if (game.isEgalite()) {
            if (!game.isAdA() && !game.isAdB()) {
                game.setAdB(true);
                game.setEgalite(false);
            } else if (game.isAdA()) {
                game.setAdA(false);
            }

        } else {
            if (!game.isAdA()) {
                game.setScoreB(game.getScoreB() + 1);
            }
            if (game.getScoreA() == 3 && game.getScoreB() == 3) {
                game.setEgalite(true);
                game.setAdA(false);
            } else if (game.getScoreB() == 4) {
                game.setFin(true);
            }

            showResult();
        }
    }

    private void showResult() {
        logger.debug(game.toString());
        System.out.println(display.display(game));
    }

}
