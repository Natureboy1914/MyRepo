/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dvd.ui;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.Scanner;

/**
 *
 * @author Olayinka
 */
public class UserIoConsoleImpl implements UserIo {
    
        static Scanner sc = new Scanner(System.in);
             
            public void print(String msg){
                System.out.println(msg);
            }
    
            public double readDouble(String prompt){
                System.out.println(prompt);
                String user;
                user = sc.nextLine();
               double userInput = parseDouble(user);
                return userInput;
            }

	    public double readDouble(String prompt, double min, double max){
                System.out.println(prompt);
                double userInput;
                do{
                   String user;      
                    user = sc.nextLine();
                    userInput = Integer.parseInt(user);
                    return userInput;
                }while(userInput < min || userInput > max);
                
            }

	    public float readFloat(String prompt){
                System.out.println(prompt);
                String user;
                user = sc.nextLine();
               float userInput = parseFloat(user);
                return userInput;
            }

	    public float readFloat(String prompt, float min, float max){
                System.out.println(prompt);
                float userInput;
                do{
                   String user;      
                    user = sc.nextLine();
                    userInput = Integer.parseInt(user);
                    return userInput;
                }while(userInput < min || userInput > max);
            }

	    public int readInt(String prompt){
                System.out.println(prompt);
                 String user;
                user = sc.nextLine();
               int userInput = parseInt(user);
                return userInput;
            }

	    public int readInt(String prompt, int min, int max){
                System.out.println(prompt);
                int userInput;
                do{
                   String user;      
                    user = sc.nextLine();
                    userInput = Integer.parseInt(user);
                    return userInput;
                }while(userInput < min || userInput > max);
            }

	   public long readLong(String prompt){
               System.out.println(prompt);
                 String user;
                user = sc.nextLine();
               long userInput = parseLong(user);
                return userInput;
            }

	    public long readLong(String prompt, long min, long max){
                System.out.println(prompt);
                long userInput;
                do{
                   String user;      
                    user = sc.nextLine();
                    userInput = Integer.parseInt(user);
                    return userInput;
                }while(userInput < min || userInput > max);
            }

	    public String readString(String prompt){
                System.out.println(prompt);
                 String user;
                user = sc.nextLine();
               
                return user;
            }
}
