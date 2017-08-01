/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.rockpaperscissors.players;

import corbos.rockpaperscissors.game.GameEngine;
import corbos.rockpaperscissors.game.Player;
import java.util.Scanner;

/**
 *
 * @author parallels
 */
public class HumanPlayer implements Player {

    private final String name;
    private final Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getChoice() {
        int choice = Integer.MIN_VALUE;
        boolean valid = false;
        do {

            System.out.printf("%s: Enter Your Choice [1-3]\n", name);
            System.out.println("1. Rock");
            System.out.println("2. Paper");
            System.out.println("3. Scissors");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0 && choice < 4) {
                    valid = true;
                    if (choice == 1) {
                        choice = GameEngine.ROCK;
                    } else if (choice == 2) {
                        choice = GameEngine.PAPER;
                    } else {
                        choice = GameEngine.SCISSORS;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Invalid number!");
            }

        } while (!valid);
        return choice;
    }

}
