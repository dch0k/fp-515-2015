/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "paneldetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paneldetails.findAll", query = "SELECT p FROM Paneldetails p"),
    @NamedQuery(name = "Paneldetails.findById", query = "SELECT p FROM Paneldetails p WHERE p.id = :id"),
    @NamedQuery(name = "Paneldetails.findByFirstName", query = "SELECT p FROM Paneldetails p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Paneldetails.findByLastName", query = "SELECT p FROM Paneldetails p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Paneldetails.findByGender", query = "SELECT p FROM Paneldetails p WHERE p.gender = :gender"),
    @NamedQuery(name = "Paneldetails.findByEmail", query = "SELECT p FROM Paneldetails p WHERE p.email = :email"),
    @NamedQuery(name = "Paneldetails.findByPhone", query = "SELECT p FROM Paneldetails p WHERE p.phone = :phone"),
    @NamedQuery(name = "Paneldetails.findByAddress", query = "SELECT p FROM Paneldetails p WHERE p.address = :address"),
    @NamedQuery(name = "Paneldetails.findByDateOfBirth", query = "SELECT p FROM Paneldetails p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Paneldetails.findByAnnualIncome", query = "SELECT p FROM Paneldetails p WHERE p.annualIncome = :annualIncome"),
    @NamedQuery(name = "Paneldetails.findByZip", query = "SELECT p FROM Paneldetails p WHERE p.zip = :zip"),
    @NamedQuery(name = "Paneldetails.findByState", query = "SELECT p FROM Paneldetails p WHERE p.state = :state")})
public class Paneldetails extends CommonEntity {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "annual_income")
    private int annualIncome;
    @Basic(optional = false)
    @Column(name = "Zip")
    private int zip;
    @Basic(optional = false)
    @Column(name = "State")
    private String state;
    @JoinColumn(name = "Panel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Panel panelid;
    @JoinColumn(name = "Assistant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Assistant assistant;

    /**
     *Default Constructor
     */
    public Paneldetails() {
    }

    /**
     *Parameterized Constructor
     * 
     * @param firstName
     * @param lastName
     * @param gender
     * @param email
     * @param phone
     * @param address
     * @param dateOfBirth
     * @param annualIncome
     * @param zip
     * @param state
     * @param panelid
     * @param assistant
     */
   
    public Paneldetails(String firstName, String lastName, String gender, String email, String phone, String address, Date dateOfBirth, int annualIncome, int zip, String state, Panel panelid, Assistant assistant) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.annualIncome = annualIncome;
        this.zip = zip;
        this.state = state;
        this.panelid = panelid;
        this.assistant = assistant;
    }


    /**
     *Returns the First name
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *Sets the First name
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *Returns the Last name
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *Sets the Last name
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *Returns the Gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the Gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *Returns the Email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     *Sets the email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *Returns the  Phone number
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *Sets the Phone Number
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *Returns the Address
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *Sets the Address
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *Returns the Date of Birth
     * @return
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *Sets the Date of Birth
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     *Returns the Annual Income
     * @return
     */
    public int getAnnualIncome() {
        return annualIncome;
    }

    /**
     *Sets the Annual Income
     * @param annualIncome
     */
    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    /**
     *Returns the Zip
     * @return
     */
    public int getZip() {
        return zip;
    }

    /**
     *Sets the Zip
     * @param zip
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     *Returns the State
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *Sets the State
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *Returns the panel id 
     * @return
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

    /**
     *
     * @return
     */
    @XmlTransient
    public Assistant getAssistant() {
        return assistant;
    }

    /**
     *
     * @param assistant
     */
    public void setAssistant(Assistant assistant) {
        this.assistant = assistant;
    }
 
    

//    @Override
//    public String toString() {
//        return "Paneldetails{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", annualIncome=" + annualIncome + ", zip=" + zip + ", state=" + state + '}';
//    }

    @Override
    public String toString() {
        return "Paneldetails{" + "firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", annualIncome=" + annualIncome + ", zip=" + zip + ", state=" + state + ", assistant=" + assistant + '}';
    }

    
    
}
