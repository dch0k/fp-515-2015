/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Bank;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author darac
 */
@Stateless
public class BankService extends AbstractService<Bank> {

    /**
     * Default Constructor
     */
    public BankService() {
        super(Bank.class);
    }

    /**
     * Returns the all information
     *
     * @return
     */
    @Override
    public List<Bank> findAll() {
        return em.createNamedQuery("Bank.findAll", Bank.class).getResultList();
    }
}
