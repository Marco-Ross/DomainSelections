package com.marco.repository.repositoryinterfaces.bookingrepo;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.repositoryinterfaces.RepositoryGI;

import java.util.ArrayList;

public interface OnlineBookingRepository extends RepositoryGI<OnlineBooking, Integer> {
    ArrayList<OnlineBooking> getAllOnlineBookings();
}
