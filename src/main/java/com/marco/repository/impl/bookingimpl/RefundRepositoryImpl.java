package com.marco.repository.impl.bookingimpl;

import com.marco.domain.actors.Customer;
import com.marco.domain.bookings.Refund;
import com.marco.factory.bookings.RefundFactory;
import com.marco.repository.repositoryinterfaces.bookingrepo.RefundRepository;

import java.util.ArrayList;

public class RefundRepositoryImpl implements RefundRepository {
    private static RefundRepositoryImpl repository = null;
    private ArrayList<Refund> refunds;

    private RefundRepositoryImpl(){
        this.refunds = new ArrayList<>();
    }

    public static RefundRepositoryImpl getRepository(){
        if(repository == null) repository = new RefundRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<Refund> getAllRefunds() {
        return this.refunds;
    }

    @Override
    public Refund create(Refund refund) {
        this.refunds.add(refund);
        return refund;
    }

    @Override
    public Refund update(Refund refund) {
        for(int i = 0; i<refunds.size();i++){
            if(refund == refunds.get(i)){
                this.refunds.set(i, refund);
            }
        }
        return refund;
    }

    @Override
    public void delete(Refund refund) {
        this.refunds.remove(refund);
    }

    @Override
    public Refund read(Customer customer) {
        /*Refund refund = null;
        for(Refund refundA : refunds){
            if(customer == refundA){
                refund = refundA;
            }
        }*/
        return null;
    }
}
