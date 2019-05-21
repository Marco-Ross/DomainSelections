package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.RepositoryGI;

import java.util.Set;

public interface BookingStatusRepository extends RepositoryGI<BookingStatus, Integer> {
    Set<BookingStatus> getAllBookingStatus();
}
