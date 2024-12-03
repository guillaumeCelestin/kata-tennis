package com.example.kata_tennis;

import com.example.kata_tennis.exeption.WrongInputException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;

@Component
public class TennisGame implements CommandLineRunner {

    private final ScoreComputation score;

    Logger logger = LoggerFactory.getLogger(TennisGame.class);

    public TennisGame(ScoreComputation score) {
        this.score = score;
    }

    @Override
    public void run(String... args) {
        try {
            if (args.length == 0) {
                Scanner sc = new Scanner(System.in);
                String commands = "";
                System.out.println("Veuillez saisir les commandes de jeu :");
                while(sc.hasNextLine()){
                    commands = sc.nextLine();
                }
                runGame(commands);
            } else {
                Arrays.stream(args).findFirst().ifPresent(p  -> {
                    try {
                        runGame(p);
                    } catch (WrongInputException e) {
                        logger.error(e.getMessage());
                    }
                });
            }
        } catch (WrongInputException e) {
            logger.error(e.getMessage());
        }
    }

    private void runGame(String commands) throws WrongInputException {
        for(char ch : commands.toCharArray()) {
            if (ch == 'A') {
                score.playerAScore();
            } else if (ch == 'B') {
                score.playerBScore();
            }
            else throw new WrongInputException("Input Invalide");
        }

    }
}
