package com.marco.service.bookings.impl;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.bookings.bookingrepo.OnlineBookingRepository;
import com.marco.service.bookings.bookingservice.OnlineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service("OnlineBookingServiceImpl")
public class OnlineBookingServiceImpl implements OnlineBookingService {
    @Autowired
    private OnlineBookingRepository repository;

    @Override
    public ArrayList<OnlineBooking> getAllOnlineBookings() {
        return (ArrayList<OnlineBooking>) this.repository.findAll();
    }

    @Override
    public OnlineBooking create(OnlineBooking onlineBooking) {
        return this.repository.save(onlineBooking);
    }

    @Override
    public OnlineBooking update(OnlineBooking onlineBooking) {
        return this.repository.save(onlineBooking);
    }

    @Override
    public void delete(Integer onlineBooking) {
        this.repository.deleteById(onlineBooking);
    }

    @Override
    public Optional<OnlineBooking> read(Integer onlineBooking) {
        return this.repository.findById(onlineBooking);
    }
}
