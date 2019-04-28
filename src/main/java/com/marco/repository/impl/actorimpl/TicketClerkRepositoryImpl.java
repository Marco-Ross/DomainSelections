package com.marco.repository.impl.actorimpl;

import com.marco.domain.actors.TicketClerk;
import com.marco.repository.repositoryinterfaces.actorrepo.TicketClerkRepository;

import java.util.ArrayList;

public class TicketClerkRepositoryImpl implements TicketClerkRepository {
    private static TicketClerkRepositoryImpl repository = null;
    private ArrayList<TicketClerk> ticketClerks;

    private TicketClerkRepositoryImpl(){
        this.ticketClerks = new ArrayList<>();
    }

    public static TicketClerkRepositoryImpl getRepository(){
        if(repository == null) repository = new TicketClerkRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<TicketClerk> getAllTicketClerks() {
        return this.ticketClerks;
    }

    @Override
    public TicketClerk create(TicketClerk ticketClerk) {
        this.ticketClerks.add(ticketClerk);
        return ticketClerk;
    }

    @Override
    public TicketClerk update(TicketClerk ticketClerk) {
        for(int i = 0; i<ticketClerks.size();i++){
            if(ticketClerk.getEmployeeNumber() == ticketClerks.get(i).getEmployeeNumber()){
                this.ticketClerks.set(i, ticketClerk);
            }
        }
        return ticketClerk;
    }

    @Override
    public void delete(TicketClerk ticketClerk) {
        this.ticketClerks.remove(ticketClerk);
    }

    @Override
    public TicketClerk read(Integer empNumb) {
        TicketClerk ticketClerk = null;
        for(TicketClerk ticketClerkA : ticketClerks){
            if(empNumb == ticketClerkA.getEmployeeNumber()){
                ticketClerk = ticketClerkA;
            }
        }
        return ticketClerk;
    }
}
