package com.marco.service.actors.actorservice;

import com.marco.domain.actors.TicketChecker;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface TicketCheckerService extends ServiceGI<TicketChecker, Integer> {
    ArrayList<TicketChecker> getAllTicketCheckers();
}