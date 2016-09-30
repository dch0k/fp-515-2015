/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import edu.iit.sat.itmd4515.cdara.fp.security.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author darac
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Assistant.findAll", query = "select e from Assistant e"),
    @NamedQuery(name = "Assistant.findByUsername", query = "select e from Assistant e where e.user.userName = :username")
})
public class Assistant extends CommonEntity {

    @OneToOne
    @JoinColumn(name = "username")
    private User user;
    @OneToMany(mappedBy = "assistant")
    private List<Paneldetails> paneldetailsList = new ArrayList<>();
    /**
     * Default Constructor
     */
    public Assistant() {
    }

    /**
     *
     * @param p
     */
    public void addPaneldetails(Paneldetails p) {
        if (!this.paneldetailsList.contains(p)) {
            this.paneldetailsList.add(p);
        }
        p.setAssistant(this);
    }

    /**
     * Used to get User information
     *
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Used to assign User information to User class
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
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

}
