/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.SuperHero;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SuperHeroDao {
    
    SuperHero addHero(SuperHero supH);
    
    List<SuperHero> allHeros();
    
   void updateHero(SuperHero supH);
   
   void removeHero(int heroId);
   
   SuperHero getHero(int heroId);
   
           
    
}
