package com.marco.service.bookings.impl;

import com.google.common.collect.Sets;
import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.bookings.bookingrepo.OfflineBookingRepository;
import com.marco.service.bookings.bookingservice.OfflineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Service("OfflineBookingServiceImpl")
public class OfflineBookingServiceImpl implements OfflineBookingService {
    @Autowired
    private OfflineBookingRepository repository;

    @Override
    public Set<OfflineBooking> getAllOfflineBookings() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public OfflineBooking create(OfflineBooking offlineBooking) {
        return this.repository.save(offlineBooking);
    }

    @Override
    public OfflineBooking update(OfflineBooking offlineBooking) {
        return this.repository.save(offlineBooking);
    }

    @Override
    public void delete(Integer offlineBooking) {
        this.repository.deleteById(offlineBooking);
    }

    @Override
    public Optional<OfflineBooking> read(Integer offlineBooking) {
        return this.repository.findById(offlineBooking);
    }
}
