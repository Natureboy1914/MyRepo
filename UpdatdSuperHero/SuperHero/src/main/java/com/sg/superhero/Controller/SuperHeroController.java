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
import com.sg.superhero.Dto.Location;
import com.sg.superhero.Dto.Organization;
import com.sg.superhero.Dto.Sighting;
import com.sg.superhero.Dto.SuperHero;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.validation.Valid;
import static org.aspectj.weaver.MemberImpl.method;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    public SuperHeroController(SuperHeroDao dao, OrgDao gdao, LocationDao ldao, SightDao sdao) {
        this.dao = dao;
        this.gdao = gdao;
        this.ldao = ldao;
        this.sdao = sdao;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String SuperHero() {

        return "Home";
    }

    @RequestMapping(value = "/allHeros", method = RequestMethod.GET)
    @ResponseBody
    public List<SuperHero> ListHeros() {
        List<SuperHero> heros = dao.allHeros();
        return heros;
    }

    @RequestMapping(value = "/addHero", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public SuperHero createHero(@RequestBody SuperHero newHero) {
        return dao.addHero(newHero);
    }

    @RequestMapping(value = "/deleteHero/{heroID}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteHero(@PathVariable int heroID) {
        dao.removeHero(heroID);
    }

    @RequestMapping(value = "/editHero/{heroID}", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void editHero(@PathVariable int heroID, @Valid @RequestBody SuperHero newHero) throws UpdateIntegrityException {
        if(heroID != newHero.getSuperHeroID()){
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        dao.updateHero(newHero);
    }

//    Location
    @RequestMapping(value = "/allLocations", method = RequestMethod.GET)
    @ResponseBody
    public List<Location> allLocations() {
        List<Location> loc = ldao.allLocations();
        return loc;
    }

    @RequestMapping(value = "/addLocation", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Location addLocation(@RequestBody Location loc) {

        return ldao.addLocation(loc);
    }

    @RequestMapping(value = "/deleteLocation/{locID}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteLocation(@PathVariable int locID) {
        ldao.removeLocation(locID);
    }

    @RequestMapping(value = "/editLocation", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void editLocation(@PathVariable int locID, @Valid @RequestBody Location loc) throws UpdateIntegrityException {
         if(locID != loc.getLocationID()){
            throw new UpdateIntegrityException("Contact Id on URL must match Contact Id in submitted data.");
        }
        ldao.updateLocation(loc);
    }

//    Sighting
    @RequestMapping(value = "/allSightings", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> allSightings() {
        List<Sighting> sight = sdao.allSightings();
        return sight;
    }

    @RequestMapping(value = "/addSighting", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Sighting addSighting(@RequestBody Map<String, String> JSON) throws ParseException {
        Sighting newSight = new Sighting();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Location loc = ldao.getLocation(Integer.parseInt(JSON.get("location")));
        SuperHero sHero = dao.getHero(Integer.parseInt(JSON.get("name")));
        newSight.setDate(new Date(df.parse(JSON.get("date")).getTime()));

        List<SuperHero> myHeros = dao.allHeros(); 
        myHeros.add(sHero);
        newSight.setLocation(loc);
        newSight.setHeros(myHeros);

        return sdao.addSighting(newSight);

    }

    @RequestMapping(value = "/deleteSighting/{locID}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteSighting(@PathVariable int sightID) {
        sdao.removeSighting(sightID);
    }

    @RequestMapping(value = "/editSighting", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void editSighting(Sighting sight) {
        sdao.updateSighting(sight);
    }
    
    
//    organization
    
     @RequestMapping(value = "/allOrganizations", method = RequestMethod.GET)
     
    @ResponseBody
    public List<Organization> allOrganizations() {
        List<Organization> org = gdao.allOrg();
        return org;
    }

    @RequestMapping(value = "/addOrganization", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Organization addOrganization(@RequestBody Organization org) {
        
        return gdao.addOrg(org);
    }

    @RequestMapping(value = "/deleteOrganization/{orgID}", method = RequestMethod.GET)
    @ResponseBody
    public void deleteOrganization(@PathVariable int orgID) {
       gdao.removeOrganization(orgID);
    }

    @RequestMapping(value = "/editOrganization", method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public void editOrganization(Organization org) {
        gdao.updateOrganization(org);
    }

    
    
//    home
    
 
    
    @RequestMapping(value = "/recentSightings", method = RequestMethod.GET)
    @ResponseBody
    public List<Sighting> recentSightings() {
        
        List<Sighting> sight = sdao.RecentSighting();

        
        return sight;
    }
    

}
