/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Admin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author darac
 */
@Stateless
public class AdminService extends AbstractService<Admin> {

    /**
     * Default Constructor
     */
    public AdminService() {
        super(Admin.class);
    }

    /**
     * Returns the list of info
     *
     * @return
     */
    @Override
    public List<Admin> findAll() {
        return em.createNamedQuery("Admin.findAll").getResultList();
    }

    /**
     * Return the information
     *
     * @param username
     * @return
     */
    public Admin findByUsername(String username) {
        TypedQuery<Admin> query = em.createNamedQuery("Admin.findByUsername", Admin.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }
}
