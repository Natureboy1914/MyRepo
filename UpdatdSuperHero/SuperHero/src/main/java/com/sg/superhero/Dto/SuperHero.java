/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dto;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class SuperHero {
    private int SuperHeroID; 
    private String name;
    private String description;
    private List<Organization> orgs;
    private String superPower;

    public SuperHero(){
        
    }
    
    
     public SuperHero(String name, String description, String superPower){
        this.name = name;
        this.description = description;
        this.superPower = superPower;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the superPower
     */
    public String getSuperPower() {
        return superPower;
    }

    /**
     * @param superPower the superPower to set
     */
    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    /**
     * @return the HeroID
     */
    public int getSuperHeroID() {
        return SuperHeroID;
    }

    /**
     * @param HeroID the HeroID to set
     */
    public void setSuperHeroID(int HeroID) {
        this.SuperHeroID = HeroID;
    }

    /**
     * @return the orgs
     */
    public List<Organization> getOrgs() {
        return orgs;
    }

    /**
     * @param orgs the orgs to set
     */
    public void setOrgs(List<Organization> orgs) {
        this.orgs = orgs;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.SuperHeroID;
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.orgs);
        hash = 23 * hash + Objects.hashCode(this.superPower);
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
        final SuperHero other = (SuperHero) obj;
        if (this.SuperHeroID != other.SuperHeroID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.superPower, other.superPower)) {
            return false;
        }
       
        return true;
    }
    
    
}
