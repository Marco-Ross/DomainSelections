//package com.marco.repository.actors.actorrepo;
//
//import com.marco.domain.actors.Customer;
//import com.marco.factory.actors.CustomerFactory;
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
//public class CustomerRepositoryImplTest {
//    @Autowired
//    private CustomerRepository repository;
//    private Customer customer;
//
//    private Customer getRepo(){
//        for(Customer customerA : repository.findAll()){
//            if(customerA.getIdNumber() == customer.getIdNumber()){
//                return customerA;
//            }
//        }
//        return null;
//    }
//
//    @Before
//    public void setUp() throws Exception {
//        customer = CustomerFactory.buildCustomer(1234567891, "marco", "ross", 23, 200);
//    }
//
//    @Test
//    public void a_create() {
//        Customer customerTest = this.repository.save(customer);
//        Assert.assertEquals(customer, customerTest);
//    }
//
//    @Test
//    public void c_update() {
//        Assert.assertNotNull(getRepo());
//        String surname = "hardy";
//        Customer updated = new Customer.Builder().copy(getRepo()).surname(surname).build();
//
//        this.repository.save(updated);
//
//        Assert.assertSame(surname, updated.getSurname());
//        System.out.println("Customer updated");
//    }
//
//    @Test
//    public void e_delete() {
//        repository.deleteById(customer.getIdNumber());
//        Set<Customer> customerSet = (Set<Customer>) repository.findAll();
//        Assert.assertEquals(0, customerSet.size());
//    }
//
//    @Test
//    public void b_read() {
//        Optional<Customer> customerRead = repository.findById(customer.getIdNumber());
//        Assert.assertTrue(customerRead.isPresent());
//        Assert.assertSame(customer.getIdNumber(), customerRead.get().getIdNumber());
//    }
//
//    @Test
//    public void d_getAllCustomers() {
//        Set<Customer> customerSet = (Set<Customer>) repository.findAll();
//        Assert.assertEquals(1, customerSet.size());
//    }
//}