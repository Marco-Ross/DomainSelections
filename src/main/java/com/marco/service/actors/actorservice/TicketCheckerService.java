package com.marco.service.actors.actorservice;

import com.marco.domain.actors.TicketChecker;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface TicketCheckerService extends ServiceGI<TicketChecker, Integer, Optional<TicketChecker>> {
    ArrayList<TicketChecker> getAllTicketCheckers();
}