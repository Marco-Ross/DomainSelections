package com.marco.repository.actors.impl;

import com.marco.domain.actors.TicketChecker;
import com.marco.repository.actors.actorrepo.TicketCheckerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("TicketCheckerRepoImpl")
public class TicketCheckerRepositoryImpl implements TicketCheckerRepository {
    private ArrayList<TicketChecker> ticketCheckers;

    private TicketCheckerRepositoryImpl(){
        this.ticketCheckers = new ArrayList<>();
    }

    @Override
    public ArrayList<TicketChecker> getAllTicketCheckers() {
        return this.ticketCheckers;
    }

    @Override
    public TicketChecker create(TicketChecker ticketChecker) {
        this.ticketCheckers.add(ticketChecker);
        for(TicketChecker ticketCheckerA : ticketCheckers){
            if(ticketChecker == ticketCheckerA){
                return ticketCheckerA;
            }
        }
        return null;
    }

    @Override
    public TicketChecker update(TicketChecker ticketChecker) {
        for(int i = 0; i<ticketCheckers.size();i++){
            if(ticketChecker.getEmployeeNumber() == ticketCheckers.get(i).getEmployeeNumber()){
                this.ticketCheckers.set(i, ticketChecker);
                return ticketChecker;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer empNumb) {
        for(TicketChecker ticketCheckerA : ticketCheckers){
            if(empNumb == ticketCheckerA.getEmployeeNumber()){
                this.ticketCheckers.remove(ticketCheckerA);
                break;
            }
        }

    }

    @Override
    public TicketChecker read(Integer empNumb) {
        for(TicketChecker ticketCheckerA : ticketCheckers){
            if(empNumb == ticketCheckerA.getEmployeeNumber()){
                return ticketCheckerA;
            }
        }
        return null;
    }
}
