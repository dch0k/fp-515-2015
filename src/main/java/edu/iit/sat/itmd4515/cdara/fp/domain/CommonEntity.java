/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author darac
 */
@MappedSuperclass
public class CommonEntity {
    
    /**
     * Used to assign id for each entity
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * Used to assign date of creation
     */
    @Temporal(value = TemporalType.TIMESTAMP)
    protected Date creationDate;

    /**
     * Default Constructor
     */
    public CommonEntity() {
    }

    /**
     * This will assign creation date
     */
    @PrePersist
    @PreUpdate
    protected void doCreationDate() {
        this.creationDate = new Date();
    }
    /**
     * Returns the ID for the given object
     *
     * @return id
     */
    
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

   

    /**
     * Returns the object creation date
     *
     * @return creationDate
     */
    public Date getCreationDate() {
        return creationDate;
    }
}
