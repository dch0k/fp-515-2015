/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Assistant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author darac
 */
@Stateless
public class AssistantService extends AbstractService<Assistant> {

    /**
     * Default Constructor
     */
    public AssistantService() {
        super(Assistant.class);
    }

    /**
     * Returns the list of all Assistant's login information
     *
     * @return
     */
    @Override
    public List<Assistant> findAll() {
        return em.createNamedQuery("Assistant.findAll").getResultList();
    }

    /**
     * Return the information of Single Assistant by username
     *
     * @param username
     * @return
     */
    public Assistant findByUsername(String username) {
        TypedQuery<Assistant> query = em.createNamedQuery("Assistant.findByUsername", Assistant.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

}