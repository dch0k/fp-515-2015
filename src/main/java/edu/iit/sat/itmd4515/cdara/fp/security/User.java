/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Used to store user information for login
 *
 * @author darac
 */
@Entity
@Table(name = "sec_user")
public class User {

    @Id
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "groupname"))
    private List<Group> userGroups = new ArrayList<>();

    /**
     * Default Constructor
     */
    public User() {
    }

    /**
     * Constructor Parameters
     *
     * @param username
     * @param password
     */
    public User(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    /**
     * Hash code algorithm for password
     */
    @PrePersist
    @PreUpdate
    private void hashPassword() {
        String digestPassword = DigestUtils.sha256Hex(this.password);
        this.password = digestPassword;
    }

    /**
     * Used for User to a respective Group
     *
     * @param g
     */
    public void addUserToGroup(Group g) {
        if (!this.userGroups.contains(g)) {
            this.userGroups.add(g);
        }
        if (!g.getGroupMembers().contains(this)) {
            g.getGroupMembers().add(this);
        }
    }

    /**
     * Return the User name
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Set the User Name
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the Password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the Password for User account
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the User Group information
     *
     * @return userGroups
     */
    public List<Group> getUserGroups() {
        return userGroups;
    }

    /**
     * Set the User Group Information
     *
     * @param userGroups
     */
    public void setUserGroups(List<Group> userGroups) {
        this.userGroups = userGroups;
    }

}
