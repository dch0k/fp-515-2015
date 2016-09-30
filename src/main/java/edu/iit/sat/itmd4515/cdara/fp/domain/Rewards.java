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
@Table(name = "rewards")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rewards.findAll", query = "SELECT r FROM Rewards r"),
    @NamedQuery(name = "Rewards.findById", query = "SELECT r FROM Rewards r WHERE r.id = :id"),
    @NamedQuery(name = "Rewards.findByFile", query = "SELECT r FROM Rewards r WHERE r.file = :file"),
    @NamedQuery(name = "Rewards.findByPoints", query = "SELECT r FROM Rewards r WHERE r.points = :points"),
    @NamedQuery(name = "Rewards.findByLastUpdated", query = "SELECT r FROM Rewards r WHERE r.lastUpdated = :lastUpdated")})
public class Rewards extends CommonEntity {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "file")
    private Boolean file;
    @Column(name = "points")
    private Integer points;
    @Column(name = "last_updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    @JoinColumn(name = "Panel_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Panel panelid;

    /**
     *Default Constructor
     */
    public Rewards() {
    }

    /**
     *Parameterized Constructor
     * 
     * @param file
     * @param points
     * @param lastUpdated
     */
    public Rewards(Boolean file, Integer points, Date lastUpdated) {
        this.file = file;
        this.points = points;
        this.lastUpdated = lastUpdated;
    }

    /**
     *Returns the File status
     * @return
     */
    public Boolean getFile() {
        return file;
    }

    /**
     *Sets the file status
     * @param file
     */
    public void setFile(Boolean file) {
        this.file = file;
    }

    /**
     *Returns the Reward Points value
     * @return points
     */
    public Integer getPoints() {
        return points;
    }

    /**
     *Sets the Reward Points value
     * @param points
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    /**
     *Returns the Last Updated date
     * @return
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     *Sets the Last Updated date
     * @param lastUpdated
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     *Returns the Panel Id
     * @return
     */
    public Panel getPanelid() {
        return panelid;
    }

    /**
     *Sets the Panel Id
     * 
     * @param panelid
     */
    public void setPanelid(Panel panelid) {
        this.panelid = panelid;
    }

    @Override
    public String toString() {
        return "Rewards{" + "id=" + id + ", file=" + file + ", points=" + points + ", lastUpdated=" + lastUpdated + '}';
    }

    
    
}
