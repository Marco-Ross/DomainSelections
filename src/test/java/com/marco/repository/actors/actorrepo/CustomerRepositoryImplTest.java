package com.marco.repository.actors.actorrepo;

import com.marco.domain.actors.Customer;
import com.marco.factory.actors.CustomerFactory;
import com.marco.repository.actors.impl.CustomerRepositoryImpl;
import com.marco.repository.actors.actorrepo.CustomerRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CustomerRepositoryImplTest {
    @Autowired
    @Qualifier("CustomerRepoImpl")
    private CustomerRepository repository;
    private Customer customer;

    private Customer getRepo(){
        for(Customer customerA : repository.getAllCustomers()){
            if(customerA.getIdNumber().equals(customer.getIdNumber())){
                return customerA;
            }
        }
        return null;
    }

    @Before
    public void setUp() throws Exception {
        customer = CustomerFactory.buildCustomer("marco", "ross", 23, "12345678910", 200);
    }

    @Test
    public void a_create() {
        Customer customerTest = this.repository.create(customer);
        Assert.assertEquals(customer, customerTest);
    }

    @Test
    public void c_update() {
        Assert.assertNotNull(getRepo());
        String surname = "hardy";
        Customer updated = new Customer.Builder().copy(getRepo()).surname(surname).build();

        this.repository.update(updated);

        Assert.assertSame(surname, updated.getSurname());
        System.out.println("Customer updated");
    }

    @Test
    public void e_delete() {
        repository.delete(customer.getIdNumber());
        Set<Customer> customerSet = repository.getAllCustomers();
        Assert.assertEquals(0, customerSet.size());
    }

    @Test
    public void b_read() {
        Customer customerRead = repository.read(customer.getIdNumber());
        Assert.assertSame(customer.getIdNumber(), customerRead.getIdNumber());
    }

    @Test
    public void d_getAllCustomers() {
        Set<Customer> customerSet = repository.getAllCustomers();
        Assert.assertEquals(1, customerSet.size());
    }
}