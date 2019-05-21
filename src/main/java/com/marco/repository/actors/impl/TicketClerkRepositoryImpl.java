package com.marco.repository.actors.impl;

import com.marco.domain.actors.TicketClerk;
import com.marco.repository.actors.actorrepo.TicketClerkRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("TicketClerkRepoImpl")
public class TicketClerkRepositoryImpl implements TicketClerkRepository {
    private Map<Integer, TicketClerk> ticketClerks;

    private TicketClerkRepositoryImpl(){
        this.ticketClerks = new HashMap<>();
    }

    @Override
    public Set<TicketClerk> getAllTicketClerks() {
        Collection<TicketClerk> platforms = this.ticketClerks.values();
        Set<TicketClerk> set = new HashSet<>();
        set.addAll(platforms);
        return set;
    }

    @Override
    public TicketClerk create(TicketClerk ticketClerk) {
        this.ticketClerks.put(ticketClerk.getEmployeeNumber(), ticketClerk);
        return this.ticketClerks.get(ticketClerk.getEmployeeNumber());
    }

    @Override
    public TicketClerk update(TicketClerk ticketClerk) {
        this.ticketClerks.replace(ticketClerk.getEmployeeNumber(), ticketClerk);
        return this.ticketClerks.get(ticketClerk.getEmployeeNumber());
    }

    @Override
    public void delete(Integer empNumb) {
        this.ticketClerks.remove(empNumb);
    }

    @Override
    public TicketClerk read(Integer empNumb) {
        return this.ticketClerks.get(empNumb);
    }
}
