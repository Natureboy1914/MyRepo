/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.rockpaperscissors;

import corbos.rockpaperscissors.game.GameEngine;
import corbos.rockpaperscissors.game.Player;
import corbos.rockpaperscissors.players.HumanPlayer;
import corbos.rockpaperscissors.players.RandomComputerPlayer;
import java.util.Scanner;

/**
 *
 * @author parallels
 */
public class Controller {

    private final Scanner scanner = new Scanner(System.in);
    private Player one;
    private Player two;
    private int ties;
    private int playerOneWins;
    private int playerTwoWins;
    private int rounds;

    public void run() {

        one = getPlayer("Player #1");
        two = getPlayer("Player #2");

        GameEngine engine = new GameEngine(one, two);

        boolean running = true;

        while (running) {

            try {
                int result = engine.playRound();
                if (result == GameEngine.PLAYER_ONE_WIN) {
                    System.out.printf("%s Wins!\n", one.getName());
                    playerOneWins++;
                } else if (result == GameEngine.PLAYER_TWO_WIN) {
                    System.out.printf("%s Wins!\n", two.getName());
                    playerTwoWins++;
                } else {
                    System.out.println("It's a tie!");
                    ties++;
                }
                rounds++;

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("Play again? (y/n)");
            String input = scanner.nextLine();
            if (!input.equalsIgnoreCase("y")) {
                running = false;
            }
        }

        goodbye();

    }

    private Player getPlayer(String defaultName) {
        System.out.printf("Is %s a human or computer? (valid choices: human, computer):", defaultName);
        Player result = null;
        while (result == null) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("human")) {
                result = getHumanPlayer(defaultName);
            } else if (input.equalsIgnoreCase("computer")) {
                result = new RandomComputerPlayer(defaultName);
            } else {
                System.out.print("Please type: human or computer.");
            }
        }
        return result;
    }

    private Player getHumanPlayer(String defaultName) {
        System.out.printf("What is %s's name?:", defaultName);
        String name = scanner.nextLine();
        return new HumanPlayer(name);
    }

    private void goodbye() {
        System.out.println("Number of rounds: " + rounds);
        System.out.println("Ties: " + ties);
        System.out.printf("%s Wins: %s\n", one.getName(), playerOneWins);
        System.out.printf("%s Wins: %s\n", two.getName(), playerTwoWins);
    }
}
