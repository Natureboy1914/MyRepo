/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.doggenetics;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class DogGenetics {

    String[] dogBreed = {"Lab", "Poodle", "Collie", "German Shepard", "Husky"};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("What is your dogs name?");
        String userInput = sc.nextLine();
        System.out.println(userInput+"'s genetic make up is...");

        DogGenetics genetics = new DogGenetics();
        genetics.generateDogDna();

    }

    public void generateDogDna() {
        int remPercent = 100;
        for (int i = 0; i < dogBreed.length; i++) {
            String breed = dogBreed[i];
            if (remPercent == 0) {
                return;
            }

            int breedPercent;

            if (i == (dogBreed.length - 1)) {
                breedPercent = remPercent;
            } else {
                breedPercent = getRandomIntRange(remPercent);
            }

            System.out.println(breed + ":" + breedPercent + "%");
            remPercent = remPercent - breedPercent;
        }

    }

    public int getRandomIntRange(int max) {
        Random rand = new Random();
        return rand.nextInt(max);
    }
}
