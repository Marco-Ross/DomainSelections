package com.marco.repository.bookings.impl;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.bookings.bookingrepo.BookingStatusRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository("BookingStatusRepoImpl")
public class BookingStatusRepositoryImpl implements BookingStatusRepository {
    private Set<BookingStatus> bookingStatuses;

    private BookingStatusRepositoryImpl(){
        this.bookingStatuses = new HashSet<>();
    }

    @Override
    public Set<BookingStatus> getAllBookingStatus() {
        return this.bookingStatuses;
    }

    @Override
    public BookingStatus create(BookingStatus bookingStatus) {
        this.bookingStatuses.add(bookingStatus);
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingStatus == bookingS){
                return bookingS;
            }
        }
        return null;
    }

    @Override //will use composition to make up booking statuses
    public BookingStatus update(BookingStatus bookingStatus) {
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingStatus.getBookingId() == bookingS.getBookingId()){ //&& also used for customerId
                this.bookingStatuses.remove(bookingS);
                this.bookingStatuses.add(bookingStatus);
                return bookingStatus;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer bookingId) {
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingId == bookingS.getBookingId()){
                this.bookingStatuses.remove(bookingS);
            }
        }
    }

    @Override
    public BookingStatus read(Integer bookingId) {
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingId == bookingS.getBookingId()){
                return bookingS;
            }
        }
        return null;
    }
}
