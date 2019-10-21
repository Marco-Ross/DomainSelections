package com.marco.service.actors.impl;

import com.google.common.collect.Sets;
import com.marco.domain.actors.TicketClerk;
import com.marco.repository.actors.actorrepo.TicketClerkRepository;
import com.marco.service.actors.actorservice.TicketClerkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service("TicketClerkServiceImpl")
public class TicketClerkServiceImpl implements TicketClerkService {
    @Autowired
    private TicketClerkRepository repository;

    @Override
    public Set<TicketClerk> getAllTicketClerks() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public TicketClerk create(TicketClerk ticketClerk) {
        return this.repository.save(ticketClerk);
    }

    @Override
    public TicketClerk update(TicketClerk ticketClerk) {
        return this.repository.save(ticketClerk);
    }

    @Override
    public void delete(Integer ticketClerk) {
        this.repository.deleteById(ticketClerk);
    }

    @Override
    public Optional<TicketClerk> read(Integer ticketClerk) {
        return this.repository.findById(ticketClerk);
    }

    public void deleteAll() {
        this.repository.deleteAll();
    }
}
