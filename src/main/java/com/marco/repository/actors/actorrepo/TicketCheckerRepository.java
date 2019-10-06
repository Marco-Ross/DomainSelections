package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.TicketChecker;
import com.marco.repository.RepositoryGI;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TicketCheckerRepository extends CrudRepository<TicketChecker, Integer> {
}