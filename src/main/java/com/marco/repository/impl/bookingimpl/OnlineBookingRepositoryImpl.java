package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.repositoryinterfaces.bookingrepo.OnlineBookingRepository;

import java.util.ArrayList;

public class OnlineBookingRepositoryImpl implements OnlineBookingRepository {
    private static OnlineBookingRepositoryImpl repository = null;
    private ArrayList<OnlineBooking> onlineBookings;

    private OnlineBookingRepositoryImpl(){
        this.onlineBookings = new ArrayList<>();
    }

    public static OnlineBookingRepositoryImpl getRepository(){
        if(repository == null) repository = new OnlineBookingRepositoryImpl();
        return repository;
    }

    @Override
    public ArrayList<OnlineBooking> getAllOnlineBookings() {
        return this.onlineBookings;
    }

    @Override
    public OnlineBooking create(OnlineBooking onlineBooking) {
        this.onlineBookings.add(onlineBooking);
        return onlineBooking;
    }

    @Override
    public OnlineBooking update(OnlineBooking onlineBooking) {
        for(int i = 0; i<onlineBookings.size();i++){
            if(onlineBooking.getOnlineBookingId() == onlineBookings.get(i).getOnlineBookingId()){
                this.onlineBookings.set(i, onlineBooking);
            }
        }
        return onlineBooking;
    }

    @Override
    public void delete(OnlineBooking onlineBooking) {
        this.onlineBookings.remove(onlineBooking);
    }

    @Override
    public OnlineBooking read(Integer bookingId) {
        OnlineBooking onlineBooking = null;
        for(OnlineBooking onlineBookingA : onlineBookings){
            if(bookingId == onlineBookingA.getOnlineBookingId()){
                onlineBooking = onlineBookingA;
            }
        }
        return onlineBooking;
    }
}
