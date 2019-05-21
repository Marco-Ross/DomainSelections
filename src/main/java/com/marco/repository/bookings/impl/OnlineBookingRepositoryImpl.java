package com.marco.repository.bookings.impl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.bookings.bookingrepo.OnlineBookingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("OnlineBookingRepoImpl")
public class OnlineBookingRepositoryImpl implements OnlineBookingRepository {
    private ArrayList<OnlineBooking> onlineBookings;

    private OnlineBookingRepositoryImpl(){
        this.onlineBookings = new ArrayList<>();
    }

    @Override
    public ArrayList<OnlineBooking> getAllOnlineBookings() {
        return this.onlineBookings;
    }

    @Override
    public OnlineBooking create(OnlineBooking onlineBooking) {
        this.onlineBookings.add(onlineBooking);
        for(OnlineBooking onlineBookingA : onlineBookings){
            if(onlineBooking == onlineBookingA){
                return onlineBookingA;
            }
        }
        return null;
    }

    @Override
    public OnlineBooking update(OnlineBooking onlineBooking) {
        for(int i = 0; i<onlineBookings.size();i++){
            if(onlineBooking.getOnlineBookingId() == onlineBookings.get(i).getOnlineBookingId()){
                this.onlineBookings.set(i, onlineBooking);
                return onlineBooking;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer bookingId) {
        for(OnlineBooking onlineBookingA : onlineBookings){
            if(bookingId == onlineBookingA.getOnlineBookingId()){
                this.onlineBookings.remove(onlineBookingA);
                break;
            }
        }
    }

    @Override
    public OnlineBooking read(Integer bookingId) {
        for(OnlineBooking onlineBookingA : onlineBookings){
            if(bookingId == onlineBookingA.getOnlineBookingId()){
                return onlineBookingA;
            }
        }
        return null;
    }
}
