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
Playerlpublic class RandomComputer implements Player {
    
    private String name;
    
    public RandomComputerPlayer(String name){
        this.name = name;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
     @Override
    public String getChoice(){
        return name;
    }
    
}

