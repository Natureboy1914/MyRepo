/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superhero.Dao;

import com.sg.superhero.Dto.Organization;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface OrgDao {
    
    Organization addOrg(Organization Org);
    
    List<Organization> allOrg();
    
   void updateOrganization(Organization org);
   
   void removeOrganization(int Organization);
   
   Organization getOrganization(int OrganizationId);
   
   
}
