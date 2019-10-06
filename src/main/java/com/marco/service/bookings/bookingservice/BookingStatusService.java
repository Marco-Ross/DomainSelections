package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.BookingStatus;
import com.marco.service.ServiceGI;

import java.util.Optional;
import java.util.Set;

public interface BookingStatusService extends ServiceGI<BookingStatus, Integer, Optional<BookingStatus>> {
    Set<BookingStatus> getAllBookingStatus();
}
