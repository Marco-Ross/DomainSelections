package com.marco.repository.repositoryinterfaces.bookingrepo;

import com.marco.domain.bookings.OfflineBooking;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.Set;

public interface OfflineBookingRepository extends RepositoryGI<OfflineBooking, Integer> {
    Set<OfflineBooking> getAllOfflineBookings();
}
