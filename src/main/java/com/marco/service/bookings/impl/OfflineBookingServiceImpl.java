package com.marco.service.bookings.impl;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.bookings.bookingrepo.OfflineBookingRepository;
import com.marco.repository.bookings.impl.OfflineBookingRepositoryImpl;
import com.marco.service.bookings.bookingservice.OfflineBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

@Service("OfflineBookingServiceImpl")
public class OfflineBookingServiceImpl implements OfflineBookingService {
    @Autowired
    @Qualifier("OfflineBookingRepoImpl")
    private OfflineBookingRepository repository;

    @Override
    public Set<OfflineBooking> getAllOfflineBookings() {
        return this.repository.getAllOfflineBookings();
    }

    @Override
    public OfflineBooking create(OfflineBooking offlineBooking) {
        return this.repository.create(offlineBooking);
    }

    @Override
    public OfflineBooking update(OfflineBooking offlineBooking) {
        return this.repository.update(offlineBooking);
    }

    @Override
    public void delete(Date offlineBooking) {
        this.repository.delete(offlineBooking);
    }

    @Override
    public OfflineBooking read(Date offlineBooking) {
        return this.repository.read(offlineBooking);
    }
}
