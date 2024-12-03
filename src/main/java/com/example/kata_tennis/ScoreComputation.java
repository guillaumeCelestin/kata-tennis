package com.example.kata_tennis;

import org.springframework.stereotype.Component;

@Component
class ScoreComputation {
    private int scoreA;
    private int scoreB;
    private boolean deuce;
    private boolean advantageA;
    private boolean advantageB;
    private boolean gameOver;
    private final ScoreDisplay display;


    public ScoreComputation(ScoreDisplay display) {
        this.display = display;
        this.scoreA = 0;
        this.scoreB = 0;
    }

    private void showResult() {
        System.out.println(display.display(scoreA, scoreB, deuce, advantageA, advantageB, gameOver));
    }

    public void playerAScore() {
        if (gameOver) {
            return;
        }

        if (deuce) {
            if (!advantageA && !advantageB) {
                advantageA = true;
                deuce = false;
            } else if (advantageB) {
                advantageB = false;
            }
        } else {
            if (!advantageB) {
                scoreA++;
            }
            if (scoreA == 3 && scoreB == 3) {
                deuce = true;
                advantageB = false;
            } else if (scoreA == 4) {
                gameOver = true;
            }
        }

        showResult();
    }

    public void playerBScore() {
        if (gameOver) {
            return;
        }

        if (deuce) {
            if (!advantageA && !advantageB) {
                advantageB = true;
                deuce = false;
            } else if (advantageA) {
                advantageA = false;
            }

        } else {
            if (!advantageA) {
                scoreB++;
            }
            if (scoreA == 3 && scoreB == 3) {
                deuce = true;
                advantageA = false;
            } else if (scoreB == 4) {
                gameOver = true;
            }
        }

        showResult();
    }
}