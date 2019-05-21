package com.marco.service.bookings.bookingservice;

import com.marco.domain.bookings.OnlineBooking;
import com.marco.service.ServiceGI;

import java.util.ArrayList;

public interface OnlineBookingService extends ServiceGI<OnlineBooking, Integer> {
    ArrayList<OnlineBooking> getAllOnlineBookings();
}
