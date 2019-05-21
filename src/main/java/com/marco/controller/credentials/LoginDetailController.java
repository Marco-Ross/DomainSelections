package com.marco.controller.credentials;

import com.marco.domain.bookings.Report;
import com.marco.domain.credentials.LoginDetail;
import com.marco.service.bookings.bookingservice.ReportService;
import com.marco.service.credentials.credentialservice.LoginDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
@RequestMapping("/railway/logindetail")
public class LoginDetailController {
    @Autowired
    @Qualifier("LoginDetailServiceImpl")
    private LoginDetailService service;

    @PostMapping("/create")
    @ResponseBody
    public LoginDetail create(@RequestBody LoginDetail loginDetail){
        return service.create(loginDetail);
    }

    @PutMapping("/update")
    @ResponseBody
    public LoginDetail update(@RequestBody LoginDetail loginDetail){
        return service.update(loginDetail);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public LoginDetail read(@PathVariable String id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public Set<LoginDetail> getAllLoginDetails(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("LoginDetailHeader"));
        return service.getAllLoginDetails();
    }
}
