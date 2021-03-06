//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.Security;
//import com.marco.factory.actors.SecurityFactory;
//import org.junit.*;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Optional;
//import java.util.Set;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class SecurityRepositoryImplTest {
//    @Autowired
//    private SecurityRepository repository;
//    private Security security;
//
//    private Security getRepo(){
//        for(Security securityA : repository.findAll()){
//            if(securityA.getEmployeeNumber() == security.getEmployeeNumber()){
//                return security;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        security = SecurityFactory.buildSecurity(3654, "marco", "ross");
//    }
//
//    @Test
//    public void d_getAllSecurity() {
//        Set<Security> arrayList = (Set<Security>) repository.findAll();
//        Assert.assertEquals(1, arrayList.size());
//    }
//
//    @Test
//    public void a_create() {
//        Security securityTest = this.repository.save(security);
//        Assert.assertEquals(security, securityTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "toolie";
//        Security updated = new Security.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("Security updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(security.getEmployeeNumber());
//        Set<Security> securities = (Set<Security>) repository.findAll();
//        Assert.assertEquals(0, securities.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Security> securityRead = repository.findById(3654);
//        Assert.assertTrue(securityRead.isPresent());
//        Assert.assertEquals(security.getEmployeeNumber(), securityRead.get().getEmployeeNumber());
//    }
//}