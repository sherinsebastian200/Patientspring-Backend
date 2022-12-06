package com.example.patientnewapp_backend.controller;

import com.example.patientnewapp_backend.model.Patients;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String Addpatients(@RequestBody Patients p){
        System.out.println(p.getName().toString());
        System.out.println(p.getId());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getContact());
        System.out.println(p.getDoa().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getDname());

        return "Patients added successfully";


}
