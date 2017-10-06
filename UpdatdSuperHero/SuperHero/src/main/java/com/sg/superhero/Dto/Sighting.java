/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dto;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Sighting {
    private int SightingID;
    private Date date;
    private Location location;
    private List<SuperHero> heros;

    /**
     * @return the Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(Date Date) {
        this.date = Date;
    }

    /**
     * @return the SightingID
     */
    public int getSightingID() {
        return SightingID;
    }

    /**
     * @param SightingID the SightingID to set
     */
    public void setSightingID(int SightingID) {
        this.SightingID = SightingID;
    }

    /**
     * @return the spot
     */
    public Location getLocation() {
        return location;
    }

    /**
     * @return the heros
     */
    public List<SuperHero> getHeros() {
        return heros;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.SightingID;
        hash = 47 * hash + Objects.hashCode(this.date);
        hash = 47 * hash + Objects.hashCode(this.location);
        hash = 47 * hash + Objects.hashCode(this.heros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sighting other = (Sighting) obj;
        if (this.SightingID != other.SightingID) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.heros, other.heros)) {
            return false;
        }
        return true;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * @param heros the heros to set
     */
    public void setHeros(List<SuperHero> heros) {
        this.heros = heros;
    }
    
    
    
}
