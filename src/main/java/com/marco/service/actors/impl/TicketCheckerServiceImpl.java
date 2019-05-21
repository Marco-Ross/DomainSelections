package com.marco.service.actors.impl;

import com.marco.domain.actors.TicketChecker;
import com.marco.repository.actors.actorrepo.TicketCheckerRepository;
import com.marco.repository.actors.impl.TicketCheckerRepositoryImpl;
import com.marco.service.actors.actorservice.TicketCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TicketCheckerServiceImpl")
public class TicketCheckerServiceImpl implements TicketCheckerService {
    @Autowired
    @Qualifier("TicketCheckerRepoImpl")
    private TicketCheckerRepository repository;

    @Override
    public ArrayList<TicketChecker> getAllTicketCheckers() {
        return this.repository.getAllTicketCheckers();
    }

    @Override
    public TicketChecker create(TicketChecker ticketChecker) {
        return this.repository.create(ticketChecker);
    }

    @Override
    public TicketChecker update(TicketChecker ticketChecker) {
        return this.repository.update(ticketChecker);
    }

    @Override
    public void delete(Integer ticketChecker) {
        this.repository.delete(ticketChecker);
    }

    @Override
    public TicketChecker read(Integer ticketChecker) {
        return this.repository.read(ticketChecker);
    }
}
