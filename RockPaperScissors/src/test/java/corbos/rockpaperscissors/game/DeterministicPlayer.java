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
public class DeterministicPlayer implements Player {
    
    private String name;
    private int choice;
    
    public DeterministicPlayer(String name, int choice){
        this.name = name;
        this.choice = choice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getChoice() {
        return choice;
    }
    
}
