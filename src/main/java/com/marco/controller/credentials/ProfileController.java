package com.marco.controller.credentials;

import com.marco.domain.credentials.Payment;
import com.marco.domain.credentials.Profile;
import com.marco.service.credentials.credentialservice.PaymentService;
import com.marco.service.credentials.credentialservice.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/railway/profile")
public class ProfileController {
    @Autowired
    @Qualifier("ProfileServiceImpl")
    private ProfileService service;

    @PostMapping("/create")
    @ResponseBody
    public Profile create(@RequestBody Profile profile){
        return service.create(profile);
    }

    @PutMapping("/update")
    @ResponseBody
    public Profile update(@RequestBody Profile profile){
        return service.update(profile);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Profile read(@PathVariable Integer id){
        return service.read(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Profile> getAllProfiles(@RequestHeader HttpHeaders headers){
        System.out.println(headers.getFirst("ProfileHeader"));
        return service.getAllProfiles();
    }
}
