package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.repositoryinterfaces.bookingrepo.OfflineBookingRepository;

import java.util.HashSet;
import java.util.Set;

public class OfflineBookingRepositoryImpl implements OfflineBookingRepository {
    private static OfflineBookingRepositoryImpl repository = null;
    private Set<OfflineBooking> offlineBookings;

    private OfflineBookingRepositoryImpl(){
        this.offlineBookings = new HashSet<>();
    }

    public static OfflineBookingRepositoryImpl getRepository(){
        if(repository == null) repository = new OfflineBookingRepositoryImpl();
        return repository;
    }

    @Override
    public Set<OfflineBooking> getAllOfflineBookings() {
        return this.offlineBookings;
    }

    @Override
    public OfflineBooking create(OfflineBooking offlineBooking) {
        this.offlineBookings.add(offlineBooking);
        return offlineBooking;
    }

    @Override
    public OfflineBooking update(OfflineBooking offlineBooking) {
        for(OfflineBooking offlineBookingA : offlineBookings){
            if(offlineBooking.getOfflineBookingId() == offlineBookingA.getOfflineBookingId()){
                this.offlineBookings.remove(offlineBookingA);
                this.offlineBookings.add(offlineBooking);
            }
        }
        return offlineBooking;
    }

    @Override
    public void delete(OfflineBooking offlineBooking) {
        this.offlineBookings.remove(offlineBooking);
    }

    @Override
    public OfflineBooking read(Integer bookingId) {
        OfflineBooking offlineBooking = null;
        for(OfflineBooking offlineBookingA : offlineBookings){
            if(bookingId == offlineBookingA.getOfflineBookingId()){
                offlineBooking = offlineBookingA;
            }
        }
        return offlineBooking;
    }
}
