package com.marco.service.bookings.impl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.bookings.bookingrepo.OnlineBookingRepository;
import com.marco.repository.bookings.impl.OnlineBookingRepositoryImpl;
import com.marco.service.bookings.bookingservice.OnlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("OnlineBookingServiceImpl")
public class OnlineBookingServiceImpl implements OnlineBookingService {
    @Autowired
    @Qualifier("OnlineBookingRepoImpl")
    private OnlineBookingRepository repository;

    @Override
    public ArrayList<OnlineBooking> getAllOnlineBookings() {
        return this.repository.getAllOnlineBookings();
    }

    @Override
    public OnlineBooking create(OnlineBooking onlineBooking) {
        return this.repository.create(onlineBooking);
    }

    @Override
    public OnlineBooking update(OnlineBooking onlineBooking) {
        return this.repository.update(onlineBooking);
    }

    @Override
    public void delete(Integer onlineBooking) {
        this.repository.delete(onlineBooking);
    }

    @Override
    public OnlineBooking read(Integer onlineBooking) {
        return this.repository.read(onlineBooking);
    }
}
