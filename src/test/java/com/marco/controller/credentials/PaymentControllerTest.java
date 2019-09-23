package com.marco.controller.credentials;

import com.marco.domain.actors.Customer;
import com.marco.domain.credentials.Payment;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.PaymentFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/railway/payment";
    private Payment payment;

    @Before
    public void setUp() throws Exception {
        Customer customer = CustomerFactory.buildCustomer("marco", "ross", 23, "12345678910", 200);
        payment = PaymentFactory.buildPayment(50, customer);
    }

    @Test
    public void a_create() {
        ResponseEntity<Payment> postResponse = restTemplate.postForEntity(baseURL + "/create", payment, Payment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    @Ignore
    public void c_update() {
        //Cannot update payments
    }

    @Test
    public void e_delete() {
        ResponseEntity<Payment> paymentResponseEntity = restTemplate.postForEntity(baseURL + "/read", payment.getCustomer().getIdNumber(), Payment.class);
        assertNotNull(paymentResponseEntity.getBody());
        assertEquals(payment.getCustomer().getIdNumber(), paymentResponseEntity.getBody().getCustomer().getIdNumber());

        restTemplate.postForEntity(baseURL + "/delete", paymentResponseEntity.getBody().getCustomer(), void.class);

        paymentResponseEntity = restTemplate.postForEntity(baseURL + "/read", payment.getCustomer(), Payment.class);

        assertNull(paymentResponseEntity.getBody());
    }

    @Test
    public void b_read() {
        ResponseEntity<Payment> paymentResponseEntity = restTemplate.postForEntity(baseURL + "/read", payment.getCustomer().getIdNumber(), Payment.class);

        assertNotNull(paymentResponseEntity.getBody());
        assertEquals("12345678910", paymentResponseEntity.getBody().getCustomer().getIdNumber());
    }

    @Test
    public void d_getAllPayments() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("PaymentHeader", "This is the getAll header");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String>  responseEntity = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
    }
}