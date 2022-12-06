package com.example.patientnewapp_backend.controller;

import com.example.patientnewapp_backend.doa.PatientDao;
import com.example.patientnewapp_backend.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class Patientcontroller {
    @Autowired
    private PatientDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping("/")
    public String Welcomepage()
    {
        return "Welcome to Patient website";
    }

    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String Addpatients(@RequestBody Patients p) {
        System.out.println(p.getName().toString());
        System.out.println(p.getId());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getContact());
        System.out.println(p.getDoa().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getDname());
        dao.save(p);
        return "Patients added successfully";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patients> viewAll(){
        return (List<Patients>) dao.findAll();
    }



}
