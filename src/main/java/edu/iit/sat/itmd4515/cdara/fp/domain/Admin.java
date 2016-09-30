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
    @NamedQuery(name = "Admin.findAll", query = "select a from Admin a"),
    @NamedQuery(name = "Admin.findByUsername", query = "select a from Admin a where a.user.userName = :username")
})
public class Admin extends CommonEntity {

    @OneToOne
    @JoinColumn(name = "username")
    private User user;

    /**
     * Default Constructor
     */
    public Admin() {
    }

    /**
     * Returns the user information
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user information
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
