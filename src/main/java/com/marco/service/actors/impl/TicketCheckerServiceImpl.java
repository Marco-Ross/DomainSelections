package com.marco.service.actors.impl;

import com.marco.domain.actors.TicketChecker;
import com.marco.repository.actors.actorrepo.TicketCheckerRepository;
import com.marco.service.actors.actorservice.TicketCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("TicketCheckerServiceImpl")
public class TicketCheckerServiceImpl implements TicketCheckerService {
    @Autowired
    private TicketCheckerRepository repository;

    @Override
    public ArrayList<TicketChecker> getAllTicketCheckers() {
        return (ArrayList<TicketChecker>) this.repository.findAll();
    }

    @Override
    public TicketChecker create(TicketChecker ticketChecker) {
        return this.repository.save(ticketChecker);
    }

    @Override
    public TicketChecker update(TicketChecker ticketChecker) {
        return this.repository.save(ticketChecker);
    }

    @Override
    public void delete(Integer ticketChecker) {
        this.repository.deleteById(ticketChecker);
    }

    @Override
    public Optional<TicketChecker> read(Integer ticketChecker) {
        return this.repository.findById(ticketChecker);
    }
}
