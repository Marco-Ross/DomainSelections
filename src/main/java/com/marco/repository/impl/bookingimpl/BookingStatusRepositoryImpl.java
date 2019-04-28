package com.marco.repository.impl.bookingimpl;

import com.marco.domain.bookings.BookingStatus;
import com.marco.repository.repositoryinterfaces.bookingrepo.BookingStatusRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class BookingStatusRepositoryImpl implements BookingStatusRepository {
    private static BookingStatusRepositoryImpl repository = null;
    private Set<BookingStatus> bookingStatuses;

    private BookingStatusRepositoryImpl(){
        this.bookingStatuses = new HashSet<>();
    }

    public static BookingStatusRepositoryImpl getRepository(){
        if(repository == null) repository = new BookingStatusRepositoryImpl();
        return repository;
    }

    @Override
    public Set<BookingStatus> getAllBookingStatus() {
        return this.bookingStatuses;
    }

    @Override
    public BookingStatus create(BookingStatus bookingStatus) {
        this.bookingStatuses.add(bookingStatus);
        return bookingStatus;
    }

    @Override //will use composition to make up booking statuses
    public BookingStatus update(BookingStatus bookingStatus) {
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingStatus.getBookingId() == bookingS.getBookingId()){ //&& also used for customerId
                this.bookingStatuses.remove(bookingS);
                this.bookingStatuses.add(bookingStatus);
            }
        }
        return bookingStatus;
    }

    @Override
    public void delete(BookingStatus bookingStatus) {
        this.bookingStatuses.remove(bookingStatus);
    }

    @Override
    public BookingStatus read(Integer bookingId) {
        BookingStatus bookingStatus = null;
        for(BookingStatus bookingS : bookingStatuses){
            if(bookingId == bookingS.getBookingId()){
                bookingStatus = bookingS;
            }
        }
        return bookingStatus;
    }
}
