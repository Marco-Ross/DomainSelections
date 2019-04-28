package com.marco.repository.repositoryinterfaces.actorrepo;

import com.marco.domain.actors.TicketClerk;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface TicketClerkRepository extends RepositoryGI<TicketClerk, Integer> {
    ArrayList<TicketClerk> getAllTicketClerks();
}
