/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author darac
 */
@Entity
@Table(name = "panel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Panel.findAll", query = "SELECT p FROM Panel p"),
    @NamedQuery(name = "Panel.findById", query = "SELECT p FROM Panel p WHERE p.id = :id"),
    @NamedQuery(name = "Panel.findByRegistrationDate", query = "SELECT p FROM Panel p WHERE p.registrationDate = :registrationDate")})
public class Panel extends CommonEntity {
    private static final long serialVersionUID = 1L;
       @Basic(optional = false)
    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    private Date registrationDate;
    @ManyToMany(mappedBy = "panelList")
    private List<Bank> bankList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panelid")
    private List<Paneldetails> paneldetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panelid")
    private List<Account> accountList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panelid")
    private List<Card> cardList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "panelid")
    private List<Rewards> rewardsList;

    /**
     *Default Constructor
     */
    public Panel() {
    }

    /**
     *Parameterized Constructor
     * @param registrationDate
     */
    public Panel(Date registrationDate) {
        
        this.registrationDate = registrationDate;
    }

    /**
     *Returns the Panel registration date
     * @return registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the Panel registration date
     * @param registrationDate
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     *Returns the Bank list
     * @return bankList
     */
    @XmlTransient
    public List<Bank> getBankList() {
        return bankList;
    }

    /**
     *Sets the bank list
     * @param bankList
     */
    public void setBankList(List<Bank> bankList) {
        this.bankList = bankList;
    }

    /**
     *Returns the Panel Details list
     * @return paneldetailsList
     */
    @XmlTransient
    public List<Paneldetails> getPaneldetailsList() {
        return paneldetailsList;
    }

    /**
     *Sets the panel details list
     * @param paneldetailsList
     */
    public void setPaneldetailsList(List<Paneldetails> paneldetailsList) {
        this.paneldetailsList = paneldetailsList;
    }

    /**
     *Returns the Account list
     * @return accountList
     */
    @XmlTransient
    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     *Sets the account list
     * @param accountList
     */
    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    /**
     *Returns the Account list
     * @return cardList
     */
    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     *Sets the Card list
     * @param cardList
     */
    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    /**
     *Returns the Account list
     * @return rewardsList
     */
    @XmlTransient
    public List<Rewards> getRewardsList() {
        return rewardsList;
    }

    /**
     *Sets the Rewards list
     * @param rewardsList
     */
    public void setRewardsList(List<Rewards> rewardsList) {
        this.rewardsList = rewardsList;
    }

    @Override
    public String toString() {
        return "Panel{" + "id=" + id + ", registrationDate=" + registrationDate + '}';
    }

    
    
}
