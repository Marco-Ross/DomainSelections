package com.marco.repository.bookings.bookingrepo;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.repository.RepositoryGI;

import java.util.ArrayList;

public interface OnlineBookingRepository extends RepositoryGI<OnlineBooking, Integer> {
    ArrayList<OnlineBooking> getAllOnlineBookings();
}
