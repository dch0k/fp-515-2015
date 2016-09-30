/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.web;

import edu.iit.sat.itmd4515.cdara.fp.domain.Assistant;
import edu.iit.sat.itmd4515.cdara.fp.domain.Paneldetails;
import edu.iit.sat.itmd4515.cdara.fp.service.AssistantService;
import edu.iit.sat.itmd4515.cdara.fp.service.PaneldetailsService;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author darac
 */
@Named
@RequestScoped
public class AssistantController extends AbstractJSFController {

    private static final Logger LOG = Logger.getLogger(AssistantController.class.getName());

    @EJB
    PaneldetailsService paneldetailsService;
    @EJB
    AssistantService assistantService;

    @Inject
    LoginController loginController;

    private List<Paneldetails> paneldetailsList;
    private Paneldetails paneldetails;
    private Assistant assistant;

    /**
     *
     */
    public AssistantController() {
    }

    @Override
    @PostConstruct
    protected void postConstruct() {
        paneldetails = new Paneldetails();
        assistant = assistantService.findByUsername(loginController.getRemoteUser());
       //paneldetailsList = assistant.getPaneldetailsList();

        paneldetailsList = paneldetailsService.findAll();
    }

    private void refreshPaneldetailsList() {
       
        paneldetailsList = assistantService.findByUsername(loginController.getRemoteUser()).getPaneldetailsList();
    }

    /**
     *
     * @return
     */
    public String doCreatePaneldetails() {
        LOG.info("Preparing to create a new Panel details");
        paneldetails = new Paneldetails();
        return "newPaneldetails";
    }

    /**
     *
     * @return
     */
    public String executeCreatePaneldetails() {
        LOG.info("Preparing to create " + paneldetailsList.toString());
        facesContext.addMessage(null, new FacesMessage("Panel " + paneldetails.getFirstName() + " has been created!"));

        paneldetailsService.create(paneldetails, assistant);

        refreshPaneldetailsList();

        return "welcome";
    }

    /**
     *
     * @param paneldetails
     * @return
     */
    public String doShowPaneldetails(Paneldetails paneldetails) {
        LOG.info("Preparing to display " + paneldetails.toString());
        this.paneldetails = paneldetails;
        return "displayPaneldetails";
    }

    /**
     *
     * @param paneldetails
     * @return
     */
    public String doUpdatePaneldetails(Paneldetails paneldetails) {
        LOG.info("Preparing to update " + paneldetails.toString());
        this.paneldetails = paneldetails;
        return "editPaneldetails";
    }

    /**
     *
     * @return
     */
    public String executeUpdatePaneldetails() {
        LOG.info("Preparing to update " + paneldetails.toString());
        facesContext.addMessage(null, new FacesMessage("Panel details " + paneldetails.getFirstName() + " has been updated!"));

        paneldetailsService.update(paneldetails, assistant);

        
        refreshPaneldetailsList();

        return "welcome";
    }

    /**
     *
     * @param paneldetails
     * @return
     */
    public String doDeletePaneldetails(Paneldetails paneldetails) {
        LOG.info("Preparing to delete " + paneldetails.toString());
        facesContext.addMessage(null, new FacesMessage("Panel details " + paneldetails.getFirstName() + " has been deleted!"));
        
        paneldetailsService.delete(paneldetails, assistant);
        refreshPaneldetailsList();
        return "welcome";
    }

    /**
     *
     * @return
     */
    public List<Paneldetails> getPaneldetailsList() {
        return paneldetailsList;
    }

    /**
     *
     * @param paneldetailsList
     */
    public void setPaneldetailsList(List<Paneldetails> paneldetailsList) {
        this.paneldetailsList = paneldetailsList;
    }

    /**
     *
     * @return
     */
    public Paneldetails getPaneldetails() {
        return paneldetails;
    }

    /**
     *
     * @param paneldetails
     */
    public void setPaneldetails(Paneldetails paneldetails) {
        this.paneldetails = paneldetails;
    }

    /**
     *
     * @return
     */
    public Assistant getAssistant() {
        return assistant;
    }

    /**
     *
     * @param assistant
     */
    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }

}
