package com.marco.service.bookings.impl;

import com.google.common.collect.Sets;
import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.bookings.bookingrepo.BookingStatusRepository;
import com.marco.service.bookings.bookingservice.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("BookingStatusServiceImpl")
public class BookingStatusServiceImpl implements BookingStatusService {
    @Autowired
    private BookingStatusRepository repository;

    @Override
    public Set<BookingStatus> getAllBookingStatus() {
        return Sets.newHashSet(this.repository.findAll());
    }

    @Override
    public BookingStatus create(BookingStatus bookingStatus) {
        return this.repository.save(bookingStatus);
    }

    @Override
    public BookingStatus update(BookingStatus bookingStatus) {
        return this.repository.save(bookingStatus);
    }

    @Override
    public void delete(Integer bookingStatus) {
        this.repository.deleteById(bookingStatus);
    }

    @Override
    public Optional<BookingStatus> read(Integer bookingStatus) {
        return this.repository.findById(bookingStatus);
    }
}
