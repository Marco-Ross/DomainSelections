package com.marco.service.bookings.impl;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.actors.actorrepo.TicketClerkRepository;
import com.marco.repository.actors.impl.TicketClerkRepositoryImpl;
import com.marco.repository.bookings.bookingrepo.BookingStatusRepository;
import com.marco.repository.bookings.impl.BookingStatusRepositoryImpl;
import com.marco.service.bookings.bookingservice.BookingStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("BookingStatusServiceImpl")
public class BookingStatusServiceImpl implements BookingStatusService {
    @Autowired
    @Qualifier("BookingStatusRepoImpl")
    private BookingStatusRepository repository;

    @Override
    public Set<BookingStatus> getAllBookingStatus() {
        return this.repository.getAllBookingStatus();
    }

    @Override
    public BookingStatus create(BookingStatus bookingStatus) {
        return this.repository.create(bookingStatus);
    }

    @Override
    public BookingStatus update(BookingStatus bookingStatus) {
        return this.repository.update(bookingStatus);
    }

    @Override
    public void delete(Integer bookingStatus) {
        this.repository.delete(bookingStatus);
    }

    @Override
    public BookingStatus read(Integer bookingStatus) {
        return this.repository.read(bookingStatus);
    }
}
