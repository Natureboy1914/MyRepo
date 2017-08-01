/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Sighting;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface SightDao {

    Sighting addSighting(Sighting sight);
    
    List<Sighting> allSightings();
    
   void updateSighting(Sighting sight);
   
   void removeSighting(int sightingId);
   
   Sighting getSighting(int sightingId);
}
