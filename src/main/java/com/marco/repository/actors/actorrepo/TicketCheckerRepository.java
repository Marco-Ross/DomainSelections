package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.TicketChecker;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface TicketCheckerRepository extends RepositoryGI<TicketChecker, Integer> {
    ArrayList<TicketChecker> getAllTicketCheckers();
}