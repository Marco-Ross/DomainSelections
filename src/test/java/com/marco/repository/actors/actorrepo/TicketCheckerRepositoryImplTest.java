//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.TicketChecker;
//import com.marco.factory.actors.TicketCheckerFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class TicketCheckerRepositoryImplTest {
//    @Autowired
//    private TicketCheckerRepository repository;
//    private TicketChecker ticketChecker;
//
//    private TicketChecker getRepo(){
//        for(TicketChecker ticketCheckerA : repository.findAll()){
//            if(ticketCheckerA.getEmployeeNumber() == ticketChecker.getEmployeeNumber()){
//                return ticketCheckerA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        ticketChecker = TicketCheckerFactory.buildTicketChecker(3654, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllSecurity() {
//        ArrayList<TicketChecker> arrayList = (ArrayList<TicketChecker>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        TicketChecker ticketCheckerTest = this.repository.save(ticketChecker);
//        Assert.assertEquals(ticketChecker, ticketCheckerTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "hardy";
//        String name = "marcoopie";
//        TicketChecker updated = new TicketChecker.Builder().copy(getRepo()).surname(surname).name(name).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("TicketChecker updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(ticketChecker.getEmployeeNumber());
//        ArrayList<TicketChecker> ticketCheckers = (ArrayList<TicketChecker>) repository.findAll();
//        Assert.assertEquals(0, ticketCheckers.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<TicketChecker> ticketCheckersRead = repository.findById(3654);
//        Assert.assertTrue(ticketCheckersRead.isPresent());
//        Assert.assertEquals(ticketChecker.getEmployeeNumber(), ticketCheckersRead.get().getEmployeeNumber());
//    }
//}