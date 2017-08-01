/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class RockPaperScissors {

    public static void main(String[] args) {

        Boolean tryAgain = true;

        do {
            Scanner sc = new Scanner(System.in);
            Random randomizer = new Random();

            String roundsPlayed;
            int rounds;
            String gameOption;
            int userChoice;
            String playAgain;

            boolean roundRange = true;

            int computerWins = 0;
            int userWins = 0;
            int ties = 0;
do {
            System.out.println("How many rounds would you like to play? Maximum rounds is 10 and minimun is 1");
            roundsPlayed = sc.nextLine();
            rounds = Integer.parseInt(roundsPlayed);

            

                if (rounds > 10 || rounds < 1) {
                    System.out.println("Please pick a number with in the range");
                } else {
                    System.out.println("Lets get the game rolling. Rock equates to 1, Paper equates to 2 & Scissors is 3");
                    roundRange = false;
                }
                
            } while (roundRange);

            for (int i = 1; i < rounds; i++) {
                gameOption = sc.nextLine();
                userChoice = Integer.parseInt(gameOption);

                int num = randomizer.nextInt(3);
                int rock = 1;
                int paper = 2;
                int scissors = 3;

                if (userChoice == num) {
                    System.out.println("Its a tie");
                    ties++;
                } else if (userChoice == rock && num == scissors) {
                    System.out.println("User wins");
                    userWins++;
                } else if (userChoice == scissors && num == paper) {
                    System.out.println("User wins");
                    userWins++;
                } else if (userChoice == paper && num == rock) {
                    System.out.println("User wins");
                    userWins++;
                } else {
                    System.out.println("Computer wins");
                    computerWins++;
                }

                System.out.println("Here are the results after the round: " + " Ties: " + ties + " Computer wins: " + computerWins + " Your wins: " + userWins);

            }
            if (computerWins < userWins) {
                System.out.println("You win");
            } else {
                System.out.println("You lose, would you like to try again?");

                playAgain = sc.nextLine();

                char tAgain = playAgain.charAt(0);

                if (tAgain == 'Y') {
                    tryAgain = true;
                } else {
                    tryAgain = false;
                }

            }

        } while (tryAgain);

    }

}
