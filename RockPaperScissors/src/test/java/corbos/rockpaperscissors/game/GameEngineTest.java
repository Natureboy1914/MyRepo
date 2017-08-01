/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.rockpaperscissors.game;

import corbos.rockpaperscissors.players.RandomComputerPlayer;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author parallels
 */
public class GameEngineTest {

    public GameEngineTest() {
    }

    /**
     * Test of playRound method, of class GameEngine.
     */
    @Test
    public void testPlayRound() throws Exception {
        
        Player alwaysRock = new DeterministicPlayer("Always Rock", GameEngine.ROCK);
        Player alwaysPaper = new DeterministicPlayer("Always Paper", GameEngine.PAPER);
        Player alwaysScissors = new DeterministicPlayer("Always Scissors", GameEngine.SCISSORS);

        assertEquals("One: Rock, Two: Rock", GameEngine.TIE, new GameEngine(alwaysRock, alwaysRock).playRound());
        assertEquals("One: Paper, Two: Paper", GameEngine.TIE, new GameEngine(alwaysPaper, alwaysPaper).playRound());
        assertEquals("One: Scissors, Two: Scissors", GameEngine.TIE, new GameEngine(alwaysScissors, alwaysScissors).playRound());
        assertEquals("One: Rock, Two: Scissors", GameEngine.PLAYER_ONE_WIN, new GameEngine(alwaysRock, alwaysScissors).playRound());
        assertEquals("One: Scissors, Two: Paper", GameEngine.PLAYER_ONE_WIN, new GameEngine(alwaysScissors, alwaysPaper).playRound());
        assertEquals("One: Paper, Two: Rock", GameEngine.PLAYER_ONE_WIN, new GameEngine(alwaysPaper, alwaysRock).playRound());
        assertEquals("One: Rock, Two: Paper", GameEngine.PLAYER_TWO_WIN, new GameEngine(alwaysRock, alwaysPaper).playRound());
        assertEquals("One: Paper, Two: Scissors", GameEngine.PLAYER_TWO_WIN, new GameEngine(alwaysPaper, alwaysScissors).playRound());
        assertEquals("One: Scissors, Two: Rock", GameEngine.PLAYER_TWO_WIN, new GameEngine(alwaysScissors, alwaysRock).playRound());
        
    }   
   

}
