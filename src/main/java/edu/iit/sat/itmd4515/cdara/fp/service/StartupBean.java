/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.service;

import edu.iit.sat.itmd4515.cdara.fp.domain.Admin;
import edu.iit.sat.itmd4515.cdara.fp.domain.Assistant;
import edu.iit.sat.itmd4515.cdara.fp.domain.Account;
import edu.iit.sat.itmd4515.cdara.fp.domain.Panel;
import edu.iit.sat.itmd4515.cdara.fp.domain.PanelLogin;
import edu.iit.sat.itmd4515.cdara.fp.domain.Bank;
import edu.iit.sat.itmd4515.cdara.fp.domain.Card;
import edu.iit.sat.itmd4515.cdara.fp.domain.Paneldetails;
import edu.iit.sat.itmd4515.cdara.fp.domain.Rewards;
import edu.iit.sat.itmd4515.cdara.fp.security.Group;
import edu.iit.sat.itmd4515.cdara.fp.security.User;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author darac
 */
@Singleton
@Startup
public class StartupBean {

    @PersistenceContext(name = "cdaraPU")
    EntityManager em;

    @EJB
    AccountService accountService;

    @EJB
    AdminService adminService;

    @EJB
    AssistantService assistantService;

    @EJB
    BankService bankService;

    @EJB
    CardService cardService;

    @EJB
    PanelService panelService;

    @EJB
    PanelLoginService panelloginService;

    @EJB
    PaneldetailsService paneldetailsService;

    @EJB
    RewardsService rewardsService;

    /**
     * Default Constructor
     */
    public StartupBean() {
    }

    @PostConstruct
    private void doResearch() {
        Group admin = new Group("Admin", "This group is only for Admins");
        Group assistants = new Group("Assistants", "This group is only for Assistants");
        Group panels = new Group("Panels", "This group is only for Panels");
        em.persist(admin);
        em.persist(assistants);
        em.persist(panels);

        User assistant1 = new User("asst1", "aone");
        User assistant2 = new User("asst2", "atwo");
        User panel1 = new User("pan1", "pone");
        User panel2 = new User("pan2", "ptwo");
        User administrator = new User("admin", "god");
       

        assistant1.addUserToGroup(assistants);
        assistant2.addUserToGroup(assistants);
        panel1.addUserToGroup(panels);
        panel2.addUserToGroup(panels);
        administrator.addUserToGroup(admin);
        

        em.persist(assistant1);
        em.persist(assistant2);
        em.persist(panel1);
        em.persist(panel2);
        em.persist(administrator);
        

        Assistant a1 = new Assistant();
        a1.setUser(assistant1);
        Assistant a2 = new Assistant();
        a2.setUser(assistant2);
        PanelLogin p1 = new PanelLogin();
        p1.setUser(panel1);
        PanelLogin p2 = new PanelLogin();
        p2.setUser(panel2);
        Admin admins = new Admin();
        admins.setUser(administrator);
       
        
        assistantService.create(a1);
        assistantService.create(a2);
        panelloginService.create(p1);
        panelloginService.create(p2);
        adminService.create(admins);
       

        //data
        Panel pa1 = new Panel(new GregorianCalendar(2015, 11, 23).getTime());
        Paneldetails pd1 = new Paneldetails("Mark", "Luther", "Male", "markl@aol.com", "3125347788", "S King Dr", new GregorianCalendar(1985, 11, 29).getTime(), 60000, 60615, "IL",pa1, a1);
        Bank b1 = new Bank("Chase");
        Card c1 = new Card("Master", "Credit", new GregorianCalendar(2015, 12, 24).getTime());
        Account act1 = new Account(1111, "Credit", new GregorianCalendar(2015, 11, 28).getTime());
        Rewards r1 = new Rewards(true, 100, new Date());

        panelService.create(pa1);
        paneldetailsService.create(pd1);
        bankService.create(b1);
        cardService.create(c1);
        accountService.create(act1);
        rewardsService.create(r1);

        Panel pa2 = new Panel(new GregorianCalendar(2015, 12, 30).getTime());
        Paneldetails pd2 = new Paneldetails("Tina", "George", "Female", "Tinag@ymail.com", "3125551123", " 400 E", new GregorianCalendar(1990, 10, 21).getTime(), 70000, 60611, "IL",pa2, a2);
        Bank b2 = new Bank("Citi");
        Card c2 = new Card("Visa", "Debit", new GregorianCalendar(2015, 10, 23).getTime());
        Account act2 = new Account(9999, "Checking", new GregorianCalendar(2015, 10, 25).getTime());
        Rewards r2 = new Rewards(true, 200, new Date());

        panelService.create(pa2);
        paneldetailsService.create(pd2);
        bankService.create(b2);
        cardService.create(c2);
        accountService.create(act2);
        rewardsService.create(r2);
        
        Panel pa3 = new Panel(new GregorianCalendar(2015, 12, 30).getTime());
        Paneldetails pd3 = new Paneldetails("Sam", "Tony", "Male", "Tsam@gmail.com", "3125431129", " 600 N LakeView", new GregorianCalendar(1995, 04, 20).getTime(), 90000, 60923, "IL",pa3, a1);
        Bank b3 = new Bank("PNC");
        Card c3 = new Card("Master", "Debit", new GregorianCalendar(2015, 10, 23).getTime());
        Account act3 = new Account(5555, "Checking", new GregorianCalendar(2015, 10, 25).getTime());
        Rewards r3= new Rewards(true, 500, new Date());

        panelService.create(pa3);
        paneldetailsService.create(pd3);
        bankService.create(b3);
        cardService.create(c3);
        accountService.create(act3);
        rewardsService.create(r3);
    }
}
