package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.RepositoryGI;

import java.util.Date;
import java.util.Set;

public interface OfflineBookingRepository extends RepositoryGI<OfflineBooking, Date> {
    Set<OfflineBooking> getAllOfflineBookings();
}
