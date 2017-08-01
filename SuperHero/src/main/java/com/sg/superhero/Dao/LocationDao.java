/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Location;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface LocationDao {
    Location addLocation(Location loc);
    
    List<Location> allLocations();
    
   void updateLocation(Location loc);
   
   void removeLocation(int LocationId);
   
   Location getLocation(int LocationId);
}
