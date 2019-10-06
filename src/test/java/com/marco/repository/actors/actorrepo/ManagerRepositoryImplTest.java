//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.Manager;
//import com.marco.factory.actors.ManagerFactory;
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
//public class ManagerRepositoryImplTest {
//    @Autowired
//    private ManagerRepository repository;
//    private Manager manager;
//
//    private Manager getRepo(){
//        for(Manager managerA : repository.findAll()){
//            if(managerA.getEmployeeNumber() == manager.getEmployeeNumber()){
//                return managerA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        manager = ManagerFactory.buildManager(5532, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllManagers() {
//        ArrayList<Manager> arrayList = (ArrayList<Manager>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Manager managerTest = this.repository.save(manager);
//        Assert.assertEquals(manager, managerTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "rusoo";
//        Manager updated = new Manager.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("Manager updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(manager.getEmployeeNumber());
//        ArrayList<Manager> managerList = (ArrayList<Manager>) repository.findAll();
//        Assert.assertEquals(0, managerList.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Manager> managerRead = repository.findById(5532);
//        Assert.assertTrue(managerRead.isPresent());
//        Assert.assertEquals(manager.getEmployeeNumber(), managerRead.get().getEmployeeNumber());
//    }
//}