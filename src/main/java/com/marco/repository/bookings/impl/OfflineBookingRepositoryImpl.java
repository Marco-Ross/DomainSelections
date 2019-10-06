//package com.marco.repository.bookings.impl;
//
//import com.marco.domain.bookings.OfflineBooking;
//import com.marco.repository.bookings.bookingrepo.OfflineBookingRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("OfflineBookingRepoImpl")
//public class OfflineBookingRepositoryImpl implements OfflineBookingRepository {
//    private Set<OfflineBooking> offlineBookings;
//
//    private OfflineBookingRepositoryImpl(){
//        this.offlineBookings = new HashSet<>();
//    }
//
//    @Override
//    public Set<OfflineBooking> getAllOfflineBookings() {
//        return this.offlineBookings;
//    }
//
//    @Override
//    public OfflineBooking create(OfflineBooking offlineBooking) {
//        this.offlineBookings.add(offlineBooking);
//        for(OfflineBooking offlineBookingA : offlineBookings){
//            if(offlineBooking.equals(offlineBookingA)){
//                return offlineBookingA;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public OfflineBooking update(OfflineBooking offlineBooking) {
//        for(OfflineBooking offlineBookingA : offlineBookings){
//            if(offlineBooking.getOfflineBookingDate().equals(offlineBookingA.getOfflineBookingDate())){
//                this.offlineBookings.remove(offlineBookingA);
//                this.offlineBookings.add(offlineBooking);
//                return offlineBooking;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void delete(Date bookingDate) {
//        for(OfflineBooking offlineBookingA : offlineBookings){
//            if(bookingDate.equals(offlineBookingA.getOfflineBookingDate())){
//                this.offlineBookings.remove(offlineBookingA);
//            }
//        }
//    }
//
//    @Override
//    public OfflineBooking read(Date bookingDate) {
//        for(OfflineBooking offlineBookingA : offlineBookings){
//            if(bookingDate.equals(offlineBookingA.getOfflineBookingDate())){
//                return offlineBookingA;
//            }
//        }
//        return null;
//    }
//}
