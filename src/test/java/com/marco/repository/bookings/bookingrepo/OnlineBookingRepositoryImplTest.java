//package com.marco.repository.bookings.bookingrepo;
//
//import com.marco.domain.bookings.OnlineBooking;
//import com.marco.factory.bookings.OnlineBookingFactory;
//import org.assertj.core.util.DateUtil;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class OnlineBookingRepositoryImplTest {
//    @Autowired
//    private OnlineBookingRepository repository;
//    private OnlineBooking onlineBooking;
//
//    private OnlineBooking getRepo(){
//         for(OnlineBooking onlineBookingA : repository.findAll()){
//            if(onlineBookingA.getOnlineBookingId() == onlineBooking.getOnlineBookingId()){
//                return onlineBookingA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 4, 31);
//        Date date = calendar.getTime();
//        Date bookedDate = DateUtil.truncateTime(date);
//
//        onlineBooking = OnlineBookingFactory.buildOnlineBooking(13, bookedDate,5);
//    }
//
//    @Test
//    public void d_getAllOnlineBookings() {
//        ArrayList<OnlineBooking> arrayList = (ArrayList<OnlineBooking>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        OnlineBooking onlineBookingTest = this.repository.save(onlineBooking);
//        Assert.assertEquals(onlineBooking, onlineBookingTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2019, 6, 12);
//        Date date = calendar.getTime();
//        Date bookedDate = DateUtil.truncateTime(date);
//
//        OnlineBooking updated = new OnlineBooking.Builder().copy(getRepo()).onlineBookingDate(bookedDate).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(bookedDate, updated.getOnlineBookingDate());
//        System.out.println("OnlineBooking updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(onlineBooking.getOnlineBookingId());
//        ArrayList<OnlineBooking> onlineBookings = (ArrayList<OnlineBooking>) repository.findAll();
//        Assert.assertEquals(0, onlineBookings.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<OnlineBooking> onlineBookingRead = repository.findById(13);
//        Assert.assertTrue(onlineBookingRead.isPresent());
//        Assert.assertSame(onlineBooking.getOnlineBookingId(), onlineBookingRead.get().getOnlineBookingId());
//    }
//}