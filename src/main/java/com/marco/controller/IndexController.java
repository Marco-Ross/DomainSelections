package com.marco.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    @ResponseBody
    public String getHomePage(){
        return " HOME PAGE (NEEDS SOME WORK) ";
    }

    @GetMapping("/railway")
    @ResponseBody
    public String getLoginPage(){
        return "Logged In";
    }

}
