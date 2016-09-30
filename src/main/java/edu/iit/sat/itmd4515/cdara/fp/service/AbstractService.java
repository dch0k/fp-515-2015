/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *Project Abstract service
 * 
 * @author darac
 * @param <T>
 */
public abstract class AbstractService<T> {

    /**
     * Sets the Persistence Unit
     */
    @PersistenceContext(unitName = "cdaraPU")
    protected EntityManager em;

    private Class<T> entityClass;

    /**
     * Parameterized Constructor
     *
     * @param entityClass
     */
    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Create new record
     *
     * @param entity
     */
    public void create(T entity) {
        em.persist(entity);
    }

    /**
     * To Find a record
     *
     * @param id
     * @return
     */
    public T find(Object id) {
        return em.find(entityClass, id);
    }

    /**
     * To update record
     *
     * @param entity
     */
    public void update(T entity) {
        em.merge(entity);
    }

    /**
     * To delete the record
     *
     * @param entity
     */
    public void delete(T entity) {
        em.remove(entity);
    }

    /**
     * To find all records
     *
     * @return All
     */
    public abstract List<T> findAll();

}
