package com.marco.service.actors.impl;

import com.marco.domain.actors.TicketChecker;
import com.marco.factory.actors.TicketCheckerFactory;
import com.marco.service.actors.actorservice.TicketCheckerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketCheckerServiceImplTest {
    @Autowired
    @Qualifier("TicketCheckerServiceImpl")
    private TicketCheckerService service;
    private TicketChecker ticketChecker;

    private TicketChecker getRepo(){
        for(TicketChecker ticketCheckerA : service.getAllTicketCheckers()){
            if(ticketCheckerA.getEmployeeNumber() == ticketChecker.getEmployeeNumber()){
                return ticketCheckerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        ticketChecker = TicketCheckerFactory.buildTicketChecker(3654, "marco", "ross");
    }

    @Test
    public void d_getAllSecurity() {
        ArrayList<TicketChecker> arrayList = service.getAllTicketCheckers();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        TicketChecker ticketCheckerTest = this.service.create(ticketChecker);
        Assert.assertEquals(ticketChecker.getEmployeeNumber(), ticketCheckerTest.getEmployeeNumber());
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        String name = "marcoopie";
        TicketChecker updated = new TicketChecker.Builder().copy(getRepo()).surname(surname).name(name).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("TicketChecker updated");
    }

    @Test
    public void e_delete() {
        service.delete(ticketChecker.getEmployeeNumber());
        ArrayList<TicketChecker> ticketCheckers = service.getAllTicketCheckers();
        Assert.assertEquals(0, ticketCheckers.size());
    }

    @Test
    public void b_read() {
        Optional<TicketChecker> ticketCheckersRead = service.read(3654);
        Assert.assertTrue(ticketCheckersRead.isPresent());
        Assert.assertEquals(ticketChecker.getEmployeeNumber(), ticketCheckersRead.get().getEmployeeNumber());
    }
}