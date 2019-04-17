package com.marco.factory.bookings;

import com.marco.domain.bookings.OnlineBooking;

public class OnlineBookingFactory {
    public static OnlineBooking getOnlineBooking(int carriageBooked){
        return new OnlineBooking.Builder().carriageBooked(carriageBooked)
                .build();
    }
}
