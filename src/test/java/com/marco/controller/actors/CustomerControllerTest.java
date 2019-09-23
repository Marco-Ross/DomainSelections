package com.marco.controller.actors;

import com.marco.domain.actors.Customer;
import com.marco.factory.actors.CustomerFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/actor/customer";

    @Test
    public void a_create() {
        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 23, "12345678910", 200);

        ResponseEntity<Customer> postResponse = restTemplate.withBasicAuth("Kaylin", "pass02").postForEntity(baseURL + "/create", customer, Customer.class); //USE EXCHANGE FOR NEXT CREATE

        assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("CustomerHeader", "This is the getAll header");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        Customer customer = restTemplate.getForObject(baseURL + "/read/12345678910", Customer.class); //Reading announcer with empNumber 55
        Customer updated = new Customer.Builder().copy(customer).surname("newRoss").build();
        restTemplate.withBasicAuth("Kaylin", "pass02").put(baseURL + "/update", updated); //Void method(put) to link to (/update) EndPoint and update with new Announcer object

        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/read/12345678910", Customer.class); //Reading announcer with empNumber 55 to check if updated

        assertNotNull(updatedCustomer);
        assertEquals(updated.getSurname(), updatedCustomer.getSurname());
    }

    @Test
    public void e_delete() {
        Customer customer = restTemplate.getForObject(baseURL + "/read/12345678910", Customer.class);
        assertNotNull(customer);
        assertEquals("12345678910", customer.getIdNumber());

        restTemplate.withBasicAuth("Kaylin", "pass02").delete(baseURL + "/delete/" + customer.getIdNumber());
        customer = restTemplate.getForObject(baseURL + "/read/12345678910", Customer.class);

        assertNull(customer);
    }

    @Test
    public void b_read() {
        ResponseEntity<Customer> customerResponseEntity = restTemplate.withBasicAuth("Marco", "pass01").getForEntity(baseURL + "/read/12345678910", Customer.class);
        assertNotNull(customerResponseEntity.getBody());
        assertEquals("12345678910", customerResponseEntity.getBody().getIdNumber());
    }

    @Test
    public void d_getAllCustomers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("CustomerHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.withBasicAuth("Marco", "pass02").exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);

        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
    }
}