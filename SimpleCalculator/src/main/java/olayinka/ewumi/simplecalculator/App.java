/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.simplecalculator;

import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class App {
    
    public static void main(String[] args){
        operationsChoice();
    }
    
    public static void operationsChoice(){
        int addition = 1;
        int subtraction = 2;
        int multiplication = 3;
        int division = 4;
        
        String opChoice;
        int userOpChoice;
        
       
        
        
            
        System.out.println("Chose an operation: addition = 1 , subtration = 2, multiplication = 3, Division = 4 ");
        Scanner scanOp = new Scanner(System.in);
        opChoice = scanOp.nextLine();
        userOpChoice = Integer.parseInt(opChoice);
        
        
        
        int firstNum = userInput("Please enter first number");
        int secondNum = userInput("Please enter second number");
        
        
        
        SimpleCalculator newCalc = new SimpleCalculator();
        
        if(userOpChoice == addition){
            newCalc.addition(firstNum,secondNum);
            System.out.println("Here is your answer: " + newCalc.addition(firstNum, secondNum));
        }
        else if (userOpChoice == subtraction){
            newCalc.subtraction(firstNum,secondNum);
            System.out.println("Here is your answer: " + newCalc.addition(firstNum, secondNum));
        }
        else if (userOpChoice == multiplication){
            newCalc.multiplication(firstNum,secondNum);
            System.out.println("Here is your answer: " + newCalc.addition(firstNum, secondNum));
            
        }
        else if (userOpChoice == division){
            newCalc.division(firstNum,secondNum);
            System.out.println("Here is your answer: " + newCalc.addition(firstNum, secondNum));
        }
       
        
        
    }
    
    public static int userInput(String prompt){
        String firstChoice;
        int operant;
   
        System.out.println(prompt);
        Scanner sc1 = new Scanner(System.in);
        firstChoice = sc1.nextLine();
        operant = Integer.parseInt(firstChoice);
   
        return operant;
         
    }
    
}
