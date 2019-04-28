package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.TicketClerk;
import com.marco.factory.actors.TicketClerkFactory;
import com.marco.repository.repositoryinterfaces.actorrepo.TicketClerkRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TicketClerkRepositoryImplTest {
    private TicketClerkRepository repository;
    private TicketClerk ticketClerk;

    @Before
    public void setUp() throws Exception {
        this.repository = TicketClerkRepositoryImpl.getRepository();
        ticketClerk = TicketClerkFactory.getTicketClerk("marco", "ross", 3654);
        this.repository.create(ticketClerk);
    }

    @After
    public void tearDown() throws Exception {
        ArrayList<TicketClerk> arrayList = repository.getAllTicketClerks();
        arrayList.clear();
    }

    @Test
    public void getAllTicketClerks() {
        ArrayList<TicketClerk> arrayList = repository.getAllTicketClerks();
        Assert.assertEquals(1, arrayList.size());
    }

    @Test
    public void create() {
        TicketClerk ticketClerk = TicketClerkFactory.getTicketClerk("peter", "guy", 3045);
        TicketClerk ticketClerkTest = this.repository.create(ticketClerk);

        Assert.assertEquals(ticketClerk, ticketClerkTest);
    }

    @Test
    public void update() {
        TicketClerk ticketClerk = TicketClerkFactory.getTicketClerk("marco", "hardy", 3654);
        this.repository.update(ticketClerk);

        ArrayList<TicketClerk> ticketClerks = repository.getAllTicketClerks();
        Assert.assertTrue(ticketClerks.contains(ticketClerk));
        System.out.println("TicketClerk updated");
    }

    @Test
    public void delete() {
        repository.delete(ticketClerk);
        ArrayList<TicketClerk> ticketClerks = repository.getAllTicketClerks();
        Assert.assertEquals(0, ticketClerks.size());
    }

    @Test
    public void read() {
        TicketClerk ticketClerkList = repository.read(3654);
        Assert.assertEquals(ticketClerkList, ticketClerk);
    }
}