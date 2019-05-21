package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.TicketClerk;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;
import java.util.Set;

public interface TicketClerkRepository extends RepositoryGI<TicketClerk, Integer> {
    Set<TicketClerk> getAllTicketClerks();
}
