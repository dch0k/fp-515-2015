/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Assistant;
import edu.iit.sat.itmd4515.cdara.fp.domain.Paneldetails;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author darac
 */
@Stateless
public class PaneldetailsService extends AbstractService<Paneldetails> {

    /**
     * Default Constructor
     */
    public PaneldetailsService() {
        super(Paneldetails.class);
    }

    /**
     * Returns the all information
     *
     * @return
     */
    @Override
    public List<Paneldetails> findAll() {
        return em.createNamedQuery("Paneldetails.findAll", Paneldetails.class).getResultList();
    }

    /**
     *
     * @param paneldetails
     * @param assistant
     */
    public void create(Paneldetails paneldetails, Assistant assistant) {
        assistant = em.getReference(Assistant.class, assistant.getId());
        assistant.addPaneldetails(paneldetails);
        em.persist(paneldetails);
    }

    /**
     *
     * @param paneldetails
     * @param assistant
     */
    public void delete(Paneldetails paneldetails, Assistant assistant){
       
        assistant= em.getReference(Assistant.class, assistant.getId());
        paneldetails = em.getReference(Paneldetails.class, paneldetails.getId());
        
        assistant.getPaneldetailsList().remove(paneldetails);
        paneldetails.setAssistant(null);
        
        em.remove(paneldetails);
    }

    /**
     *
     * @param newPaneldetails
     * @param newAssistant
     */
    public void update(Paneldetails newPaneldetails, Assistant newAssistant){
       
        Paneldetails currentPaneldetails = em.getReference(Paneldetails.class, newPaneldetails.getId());
     Assistant  currentAssistant= currentPaneldetails.getAssistant();
     
     
        currentPaneldetails.setFirstName(newPaneldetails.getFirstName());
        currentPaneldetails.setLastName(newPaneldetails.getLastName());
        currentPaneldetails.setDateOfBirth(newPaneldetails.getDateOfBirth());
        currentPaneldetails.setEmail(newPaneldetails.getEmail());
        currentPaneldetails.setGender(newPaneldetails.getGender());
        currentPaneldetails.setPhone(newPaneldetails.getPhone());
        currentPaneldetails.setAnnualIncome(newPaneldetails.getAnnualIncome());
        currentPaneldetails.setAddress(newPaneldetails.getAddress());
        currentPaneldetails.setState(newPaneldetails.getState());
        currentPaneldetails.setZip(newPaneldetails.getZip());
        currentPaneldetails.setAssistant(newAssistant);
        
    }
}