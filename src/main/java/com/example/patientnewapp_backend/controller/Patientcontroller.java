package com.example.patientnewapp_backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Patientcontroller {

    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public String Welcomepage()
    {
        return "Welcome to Patient website";
    }
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")

}
