/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Paneldetails;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author darac
 */
@Path("/paneldetailsList")
public class AssistantEndpoint {
   
    @EJB 
    PaneldetailsService paneldetailsService;
    
    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_XML)
    public List<Paneldetails> getPaneldetails(){
        return paneldetailsService.findAll();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Paneldetails getPaneldetails(@PathParam("id") Long id){
        return paneldetailsService.find(id);
    }
    
    
}
