//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.Announcer;
//import com.marco.factory.actors.AnnouncerFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import java.util.ArrayList;
//import java.util.Optional;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class AnnouncerRepositoryImplTest {
//    @Autowired
//    private AnnouncerRepository repository;
//    private Announcer announcer;
//
//    private Announcer getRepo(){
//        for(Announcer announcerA : repository.findAll()){
//            if(announcerA.getEmployeeNumber() == announcer.getEmployeeNumber()){
//                return announcerA;
//            }
//        }
//         return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        //this.repository = AnnouncerRepositoryImpl.getRepository(); //was used to initialize the repository impl. and initialize the dataSet
//        announcer = AnnouncerFactory.buildAnnouncer(3654, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllSecurity() {
//        ArrayList<Announcer> arrayList = (ArrayList<Announcer>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Announcer announcerTest = this.repository.save(announcer);
//        Assert.assertSame(announcer, announcerTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "hardy";
//        Announcer updated = new Announcer.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("Announcer updated");
//    }
//
//    @Test
//    public void e_delete() {
//        Assert.assertNotNull(getRepo());
//        Announcer saved = getRepo();
//        this.repository.deleteById(saved.getEmployeeNumber());
//
//        ArrayList<Announcer> arrayList = (ArrayList<Announcer>) repository.findAll();
//        Assert.assertEquals(0, arrayList.size());
//    }
//
//    @Test
//    public void b_read() {
//        Assert.assertNotNull(getRepo());
//        Announcer announcerList = getRepo();
//        Optional<Announcer> announcerRead = this.repository.findById(announcerList.getEmployeeNumber());
//        Assert.assertTrue(announcerRead.isPresent());
//
//        Assert.assertSame(announcerList, announcerRead.get());
//    }
//}