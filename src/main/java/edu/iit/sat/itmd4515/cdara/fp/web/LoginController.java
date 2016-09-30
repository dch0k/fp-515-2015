/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.web;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 *
 * @author darac
 */
@Named
@RequestScoped
public class LoginController extends AbstractJSFController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @NotNull(message = "Please enter the username")
    private String username;
    @NotNull(message = "Please enter the password")
    private String password;

    /**
     * Default Constructor
     */
    public LoginController() {
    }

    /**
     * Post Construct Method
     */
    @Override
    @PostConstruct
    protected void postConstruct() {
        super.postConstruct();
    }

    /**
     * Returns the User name
     *
     * @return
     */
    public String getRemoteUser() {
        return facesContext.getExternalContext().getRemoteUser();
    }

    /**
     * Check whether Administrator user is logged in
     *
     * @return
     */
    public boolean isAdmin() {
        return facesContext.getExternalContext().isUserInRole("ADMIN");
    }

    /**
     * 
     *
     * @return
     */
    public boolean isAssistant() {
        return facesContext.getExternalContext().isUserInRole("ASSISTANT");
    }

    /**
     * 
     *
     * @return
     */
    public boolean isPanel() {
        return facesContext.getExternalContext().isUserInRole("PANEL");
    }

    /**
     * Check the role of user
     *
     * @param path
     * @return
     */
    public String getRoleContextPath(String path) {
        if (isAdmin()) {
            return "/admin/" + path + FACES_REDIRECT;
        } else if (isAssistant()) {
            return "/assistantPortal/" + path + FACES_REDIRECT;
        } else if (isPanel()) {
            return "/panelPortal/" + path + FACES_REDIRECT;
        }

        return path;
    }

    /**
     * Method to do login into application
     *
     * @return
     */
    public String doLogin() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            req.login(username, password);
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "Failed login for " + username);
            facesContext.addMessage(null, new FacesMessage("Login Failed", "Incorrect Username and Password"));
            return "login.xhtml";
        }
        return getRoleContextPath("welcome.xhtml");
    }

    /**
     * Method to do logout into application
     *
     * @return
     */
    public String doLogout() {
        HttpServletRequest req = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        try {
            req.logout();
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, "Failed login from " + username);
            facesContext.addMessage(null, new FacesMessage("Bad Logout"));
            return "login.xhtml";
        }
        return "/login.xhtml";
    }

    /**
     * forward to Login page
     *
     * @return
     */
    public String redirectLogin() {
        return "login.xhtml";
    }

    /**
     * Returns the username
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns user's password
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}