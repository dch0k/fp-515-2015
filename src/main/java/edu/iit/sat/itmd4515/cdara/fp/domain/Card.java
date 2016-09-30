/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darac
 */
@Entity
@Table(name = "card")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findById", query = "SELECT c FROM Card c WHERE c.id = :id"),
    @NamedQuery(name = "Card.findByBrand", query = "SELECT c FROM Card c WHERE c.brand = :brand"),
    @NamedQuery(name = "Card.findByType", query = "SELECT c FROM Card c WHERE c.type = :type"),
    @NamedQuery(name = "Card.findByActivationDate", query = "SELECT c FROM Card c WHERE c.activationDate = :activationDate")})
public class Card extends CommonEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @Column(name = "activation_date")
    @Temporal(TemporalType.DATE)
    private Date activationDate;
    @JoinColumn(name = "Account_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Account accountid;
    @JoinColumn(name = "Bank_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bank bankid;
    @JoinColumn(name = "Panel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Panel panelid;

    /**
     *Default Constructor
     */
    public Card() {
    }

    /**
     *Parameterized Constructor
     * @param brand
     * @param type
     * @param activationDate
     */
    public Card( String brand, String type, Date activationDate) {
        
        this.brand = brand;
        this.type = type;
        this.activationDate = activationDate;
    }

    /**
     *Returns the Card Brand name
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the Card Brand name
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *Returns the Card type name
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Card type name
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *Returns the Card Activation Date
     * @return activationDate
     */
    public Date getActivationDate() {
        return activationDate;
    }

    /**
     *Sets the Card Activation Date
     * @param activationDate
     */
    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    /**
     *Returns the Account id
     * @return accountid
     */
    public Account getAccountid() {
        return accountid;
    }

    /**
     *Sets the Account id
     * @param accountid
     */
    public void setAccountid(Account accountid) {
        this.accountid = accountid;
    }

    /**
     *Returns the Bank id
     * @return
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
     *Returns the Panel id
     * @return panelid
     */
    public Panel getPanelid() {
        return panelid;
    }

    /**
     *Sets the Panel id
     * @param panelid
     */
    public void setPanelid(Panel panelid) {
        this.panelid = panelid;
    }

    @Override
    public String toString() {
        return "Card{" + "id=" + id + ", brand=" + brand + ", type=" + type + ", activationDate=" + activationDate + '}';
    }

       
    
}
