/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corbos.rockpaperscissors.game;

/**
 *
 * @author parallels
 */
public interface Player {
    
    String getName();
    
    GameEngine.PlayerChoice getChoice();
}
