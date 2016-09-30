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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
    @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
    @NamedQuery(name = "Account.findByNumber", query = "SELECT a FROM Account a WHERE a.number = :number"),
    @NamedQuery(name = "Account.findByType", query = "SELECT a FROM Account a WHERE a.type = :type"),
    @NamedQuery(name = "Account.findByOpeningDate", query = "SELECT a FROM Account a WHERE a.openingDate = :openingDate")})
public class Account extends CommonEntity {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "number")
    private int number;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "opening_date")
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @JoinColumn(name = "Bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankid;
    @JoinColumn(name = "Panel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Panel panelid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountid")
    private List<Card> cardList;

    /**
     * Default Constructor
     */
    public Account() {
    }

    /**
     *
     * @param number
     * @param type
     * @param openingDate
     */
    public Account(int number, String type, Date openingDate) {
        this.number = number;
        this.type = type;
        this.openingDate = openingDate;
    }

    /**
     *Returns the Account number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     *Sets the Account Number
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *Returns the Account Type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     *Sets the Account Type
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *Returns the openingDate
     * @return openingDate
     */
    public Date getOpeningDate() {
        return openingDate;
    }

    /**
     *Sets the openingDate
     * @param openingDate
     */
    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    /**
     *Returns the Bank id
     * @return bankid
     */
    public Bank getBankid() {
        return bankid;
    }

    /**
     *Sets the Bank id
     * @param bankid
     */
    public void setBankid(Bank bankid) {
        this.bankid = bankid;
    }

    /**
     *Returns the Panel Id
     * @return panelid
     */
    public Panel getPanelid() {
        return panelid;
    }

    /**
     *Sets the Panel Id
     * @param panelid
     */
    public void setPanelid(Panel panelid) {
        this.panelid = panelid;
    }

    /**
     *Returns the Card List
     * @return cardList
     */
    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    /**
     *Sets the Card List
     * @param cardList
     */
    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", number=" + number + ", type=" + type + ", openingDate=" + openingDate + '}';
    }

   
    
}
