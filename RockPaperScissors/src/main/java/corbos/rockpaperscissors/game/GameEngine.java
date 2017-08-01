/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.rockpaperscissors.game;

import corbos.rockpaperscissors.game.GameEngine.PlayerChoice;

/**
 *
 * @author parallels
 */
public class GameEngine {

 

    public final static int TIE = 0;
    public final static int PLAYER_ONE_WIN = 1;
    public final static int PLAYER_TWO_WIN = -1;

    private Player playerOne;
    private Player playerTwo;

    public GameEngine(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
    }
    
     public enum PlayerChoice{
        ROCK, PAPER, SCISSORS
    }
 
   

    public int playRound() throws Exception {

    PlayerChoice p1Choice= getPlayerChoice(playerOne);
    PlayerChoice p2Choice = getPlayerChoice(playerTwo);

        int result = TIE;
        if (p1Choice == PlayerChoice.ROCK) {
            if (p2Choice == PlayerChoice.PAPER) {
                result = PLAYER_TWO_WIN;
            } else if (p2Choice == PlayerChoice.SCISSORS) {
                result = PLAYER_ONE_WIN;
            }
            
        } else if (p1Choice == PlayerChoice.PAPER) {
            if (p2Choice == PlayerChoice.ROCK) {
                result = PLAYER_ONE_WIN;
            } else if (p2Choice == PlayerChoice.SCISSORS) {
                result = PLAYER_TWO_WIN;
            }
        } else if (p1Choice == PlayerChoice.SCISSORS) {
            if (p2Choice == PlayerChoice.ROCK) {
                result = PLAYER_TWO_WIN;
            } else if (p2Choice == PlayerChoice.PAPER) {
                result = PLAYER_ONE_WIN;
            }
        }
        // Careful, choices not exhaustive...

        return result;
    }

    private PlayerChoice getPlayerChoice(Player player) throws Exception {
        PlayerChoice choice = player.getChoice();
        
        return choice;
    }
}
