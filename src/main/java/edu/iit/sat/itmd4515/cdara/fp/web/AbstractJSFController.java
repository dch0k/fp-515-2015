/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.web;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

/**
 *
 * @author darac
 */
public abstract class AbstractJSFController {

    /**
     * FacesContext Initialization
     */
    protected FacesContext facesContext;

    /**
     * FACES_REDIRECT Initialization
     */
    protected static final String FACES_REDIRECT = "?faces-redirect=true";

    /**
     * FacesContext method at postConstruct
     */
    @PostConstruct
    protected void postConstruct() {
        facesContext = FacesContext.getCurrentInstance();
    }
}
