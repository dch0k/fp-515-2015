/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Rewards;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author darac
 */
@Stateless
public class RewardsService extends AbstractService<Rewards> {

    /**
     * Default Constructor
     */
    public RewardsService() {
        super(Rewards.class);
    }

    /**
     * Returns the all information
     *
     * @return
     */
    @Override
    public List<Rewards> findAll() {
        return em.createNamedQuery("Rewards.findAll", Rewards.class).getResultList();
    }
}