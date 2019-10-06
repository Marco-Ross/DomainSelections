package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.service.ServiceGI;

import java.util.ArrayList;
import java.util.Optional;

public interface OnlineBookingService extends ServiceGI<OnlineBooking, Integer, Optional<OnlineBooking>> {
    ArrayList<OnlineBooking> getAllOnlineBookings();
}
