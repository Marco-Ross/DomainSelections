package com.marco.factory.bookings;

import com.marco.domain.actors.Customer;
import com.marco.domain.bookings.Refund;
import com.marco.domain.credentials.LoginDetail;
import com.marco.factory.actors.CustomerFactory;
import com.marco.factory.credentials.LoginDetailFactory;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RefundFactoryTest {

    @Test
    public void getRefund() {
        double refundAmount = 80.50;

        Customer customer = CustomerFactory.getCustomer("marco", "ross", 20, "12345678910", 200);
        LoginDetail loginDetail = LoginDetailFactory.getLoginDetail("laome", "password01", customer);

        Refund refund = RefundFactory.getRefund(refundAmount, loginDetail);
        //Assert.assertSame(refund.getCustomerId(), customer.getIdNumber());
    }
}