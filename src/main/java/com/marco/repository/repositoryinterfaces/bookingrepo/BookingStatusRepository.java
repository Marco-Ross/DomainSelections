package com.marco.repository.repositoryinterfaces.bookingrepo;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Date;
import java.util.Set;

public interface BookingStatusRepository extends RepositoryGI<BookingStatus, Integer> {
    Set<BookingStatus> getAllBookingStatus();
}
