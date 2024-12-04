package com.example.tennis;

public class ScoreGame {

    private int scoreA;
    private int scoreB;
    private boolean egalite;
    private boolean adA;
    private boolean adB;
    private boolean fin;

    public ScoreGame(int scoreA, int scoreB) {
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    public int getScoreA() {
        return scoreA;
    }

    public void setScoreA(int scoreA) {
        this.scoreA = scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public void setScoreB(int scoreB) {
        this.scoreB = scoreB;
    }

    public boolean isEgalite() {
        return egalite;
    }

    public void setEgalite(boolean egalite) {
        this.egalite = egalite;
    }

    public boolean isAdA() {
        return adA;
    }

    public void setAdA(boolean adA) {
        this.adA = adA;
    }

    public boolean isAdB() {
        return adB;
    }

    public void setAdB(boolean adB) {
        this.adB = adB;
    }

    public boolean isFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "ScoreGame{" +
                "scoreA=" + scoreA +
                ", scoreB=" + scoreB +
                ", egalite=" + egalite +
                ", adA=" + adA +
                ", adB=" + adB +
                ", fin=" + fin +
                '}';
    }
}


