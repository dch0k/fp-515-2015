/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darac
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findById", query = "SELECT b FROM Bank b WHERE b.id = :id"),
    @NamedQuery(name = "Bank.findByName", query = "SELECT b FROM Bank b WHERE b.name = :name")})
public class Bank extends CommonEntity {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @JoinTable(name = "panelbank", joinColumns = {
        @JoinColumn(name = "Bank_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "Panel_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Panel> panelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankid")
    private List<Account> accountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bankid")
    private List<Card> cardList;

    /**
     *Default Constructor
     */
    public Bank() {
    }

    /**
     *Parameterized Constructor
     * @param name
     */
    public Bank(String name) {
       this.name = name;
    }

    /**
     *Returns the Bank Name
     * @return name
     */ 
    public String getName() {
        return name;
    }

    /**
     *Sets the Bank Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *Returns the Panel list
     * @return panelList
     */
    @XmlTransient
    public List<Panel> getPanelList() {
        return panelList;
    }

    /**
     *Sets the Panel List
     * @param panelList
     */
    public void setPanelList(List<Panel> panelList) {
        this.panelList = panelList;
    }

    /**
     *Returns the Account List
     * @return accountList
     */
    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     *Sets the Panel List
     * @param accountList
     */
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    /**
     *Return the Card List
     * @return cardList
     */
    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     * Sets the Card List
     * @param cardList
     */
    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "Bank{" + "id=" + id + ", name=" + name + '}';
    }

      
}
