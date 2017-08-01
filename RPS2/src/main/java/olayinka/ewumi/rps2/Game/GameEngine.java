/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olayinka.ewumi.rps2.Game;

/**
 *
 * @author Olayinka
 */
public class GameEngine {
    
    public final static int ROCK = 1;
    public final static int PAPER = 2;
    public final static int SCISSORS = 3;
    
    public final static int TIE = 0;
    public final static int PLAYER_ONE_WIN = 0;
    public final static int PLAYER_TWO_WIN = 0;
    
    
    
    private Player playerOne;
    private Player playerTwo;
    
    public GameEngine(Player one, Player two){
        playerOne = one;
        playerTwo = two;
        
        
    }
    
    public int playRound thows Exception(){
        int p1Choice = playerOne.getChoice();
        int p2Choice = playerTwo.getChoice();
        
        if(p1Choice == ROCK){
            if(p1Choice == PAPER)
                result = PLAYER_TWO_WIN;
        }else if(p2Choice == SCISSORS){
            result PLAYER_ONE_WIN;
           
    }
    }else if(p1Choice == ROCK){
            if(p1Choice == PAPER)
                result = PLAYER_TWO_WIN;
        }else if(p2Choice == SCISSORS){
            result PLAYER_ONE_WIN;
}
}
else if(p1Choice == ROCK){
            if(p1Choice == PAPER)
                result = PLAYER_TWO_WIN;
        }else if(p2Choice == SCISSORS){
            result PLAYER_ONE_WIN;
  private int getPlayerChoice(Player player) thows Exception{
        int choice = player.getChoice();
        if(choice < ROCK || choice > SCISSORS){
            String msg = String.format("%s's choice (%s) is invalid", player.getName(), choice);
            thow new Exception(msg);
        }
        return choice;
  }
  
    }
}
