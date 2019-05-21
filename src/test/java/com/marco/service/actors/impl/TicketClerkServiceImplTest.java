package com.marco.service.actors.impl;

import com.marco.domain.actors.TicketClerk;
import com.marco.factory.actors.TicketClerkFactory;
import com.marco.service.actors.actorservice.TicketClerkService;
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

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TicketClerkServiceImplTest {
    @Autowired
    @Qualifier("TicketClerkServiceImpl")
    private TicketClerkService service;
    private TicketClerk ticketClerk;

    private TicketClerk getRepo(){
        for(TicketClerk ticketClerkA : service.getAllTicketClerks()){
            if(ticketClerkA.getEmployeeNumber() == ticketClerk.getEmployeeNumber()){
                return ticketClerkA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        ticketClerk = TicketClerkFactory.buildTicketClerk("marco", "ross", 3654);
    }

    @Test
    public void d_getAllTicketClerks() {
        Set<TicketClerk> arrayList = service.getAllTicketClerks();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void a_create() {
        TicketClerk ticketClerkTest = this.service.create(ticketClerk);
        Assert.assertEquals(ticketClerk, ticketClerkTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "looper";
        TicketClerk updated = new TicketClerk.Builder().copy(getRepo()).surname(surname).build();

        this.service.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("TicketClerk updated");
    }

    @Test
    public void e_delete() {
        service.delete(ticketClerk.getEmployeeNumber());
        Set<TicketClerk> ticketClerks = service.getAllTicketClerks();
        Assert.assertEquals(0, ticketClerks.size());
    }

    @Test
    public void b_read() {
        TicketClerk ticketClerkRead = service.read(3654);
        Assert.assertEquals(ticketClerk.getEmployeeNumber(), ticketClerkRead.getEmployeeNumber());
    }
}