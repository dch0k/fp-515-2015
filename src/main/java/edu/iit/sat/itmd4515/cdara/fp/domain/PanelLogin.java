/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import edu.iit.sat.itmd4515.cdara.fp.security.User;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author darac
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "PanelLogin.findAll", query = "select c from PanelLogin c"),
    @NamedQuery(name = "PanelLogin.findByUsername", query = "select c from PanelLogin c where c.user.userName = :username")
})
public class PanelLogin extends CommonEntity {

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    /**
     * Default Constructor
     */
    public PanelLogin() {
    }

    /**
     * Returns the User Information
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets User information to User class
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
