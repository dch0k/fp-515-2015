/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Account;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author darac
 */
@Stateless
public class AccountService extends AbstractService<Account> {

    /**
     * Default Constructor
     */
    public AccountService() {
        super(Account.class);
    }

    /**
     * Returns the all information about accounts of various
     *
     * @return
     */
    @Override
    public List<Account> findAll() {
        return em.createNamedQuery("Account.findAll", Account.class).getResultList();
    }
}