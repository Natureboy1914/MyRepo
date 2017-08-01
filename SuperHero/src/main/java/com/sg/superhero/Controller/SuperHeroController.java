/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Controller;

import com.sg.superhero.Dao.LocationDao;
import com.sg.superhero.Dao.OrgDao;
import com.sg.superhero.Dao.SightDao;
import com.sg.superhero.Dao.SuperHeroDao;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class SuperHeroController {
    
    SuperHeroDao dao;
    OrgDao gdao;
    LocationDao ldao;
    SightDao sdao;
    
    @Inject
    public SuperHeroController(SuperHeroDao dao,OrgDao gdao,LocationDao ldao,SightDao sdao  ){
        this.dao = dao;
        this.gdao = gdao;
        this.ldao = ldao;
        this.sdao = sdao;
        
    }
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String SuperHero(Model model){
        
        return "index";
    }
    
    
    
    public void yg(){
       
    }
    
}
