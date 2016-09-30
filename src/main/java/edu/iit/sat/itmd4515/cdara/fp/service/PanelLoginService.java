/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;


import edu.iit.sat.itmd4515.cdara.fp.domain.PanelLogin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author darac
 */
@Stateless
public class PanelLoginService extends AbstractService<PanelLogin> {

    /**
     * Default Constructor
     */
    public PanelLoginService() {
        super(PanelLogin.class);
    }

    /**
     * Returns the list of all PanelLogin's login information
     *
     * @return
     */
    @Override
    public List<PanelLogin> findAll() {
        return em.createNamedQuery("PanelLogin.findAll").getResultList();
    }

    /**
     * Return the information of Single PanelLogin by username
     *
     * @param username
     * @return
     */
    public PanelLogin findByUsername(String username) {
        TypedQuery<PanelLogin> query = em.createNamedQuery("PanelLogin.findByUsername", PanelLogin.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

}
