package com.marco.service.actors.actorservice;

import com.marco.domain.actors.TicketClerk;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public interface TicketClerkService extends ServiceGI<TicketClerk, Integer, Optional<TicketClerk>> {
    Set<TicketClerk> getAllTicketClerks();
}
