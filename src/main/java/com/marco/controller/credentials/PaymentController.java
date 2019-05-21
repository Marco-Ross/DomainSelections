package com.marco.controller.credentials;

import com.marco.domain.credentials.LoginDetail;
import com.marco.domain.credentials.Payment;
import com.marco.service.credentials.credentialservice.LoginDetailService;
import com.marco.service.credentials.credentialservice.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/payment")
public class PaymentController {
    @Autowired
    @Qualifier("PaymentServiceImpl")
    private PaymentService service;

    @PostMapping("/create")
    @ResponseBody
    public Payment create(@RequestBody Payment payment){
        return service.create(payment);
    }

    @PutMapping("/update")
    @ResponseBody
    public Payment update(@RequestBody Payment payment){
        return service.update(payment);
    }

    @PostMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody String id){
        service.delete(id);
    }

    @PostMapping("/read")
    @ResponseBody
    public Payment read(@RequestBody String id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Payment> getAllPayments(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("PaymentHeader"));
        return service.getAllPayments();
    }
}
