package com.marco.service.actors.impl;

import com.marco.domain.actors.TicketClerk;
import com.marco.repository.actors.actorrepo.TicketClerkRepository;
import com.marco.repository.actors.impl.TicketClerkRepositoryImpl;
import com.marco.service.actors.actorservice.TicketClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service("TicketClerkServiceImpl")
public class TicketClerkServiceImpl implements TicketClerkService {
    @Autowired
    @Qualifier("TicketClerkRepoImpl")
    private TicketClerkRepository repository;

    @Override
    public Set<TicketClerk> getAllTicketClerks() {
        return this.repository.getAllTicketClerks();
    }

    @Override
    public TicketClerk create(TicketClerk ticketClerk) {
        return this.repository.create(ticketClerk);
    }

    @Override
    public TicketClerk update(TicketClerk ticketClerk) {
        return this.repository.update(ticketClerk);
    }

    @Override
    public void delete(Integer ticketClerk) {
        this.repository.delete(ticketClerk);
    }

    @Override
    public TicketClerk read(Integer ticketClerk) {
        return this.repository.read(ticketClerk);
    }
}
