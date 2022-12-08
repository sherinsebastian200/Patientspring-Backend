package com.example.patientnewapp_backend.controller;

import com.example.patientnewapp_backend.doa.PatientDao;
import com.example.patientnewapp_backend.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddPatients(@RequestBody Patients p) {
        System.out.println(p.getName().toString());
        System.out.println(p.getId());
        System.out.println(p.getAddress().toString());
        System.out.println(p.getContact());
        System.out.println(p.getDoa().toString());
        System.out.println(p.getImage().toString());
        System.out.println(p.getDname());
        dao.save(p);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search", consumes = "application/json", produces = "application/json")
    public List<Patients> searchPatients(@RequestBody Patients p) {
        Integer pid = (p.getPid ());
        System.out.println(pid);
        return (List<Patients>) dao.searchPatients(p.getPid());
    }


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> deletePatients(@RequestBody Patients p) {
        String id = String.valueOf(p.getId());
        System.out.println(id);
        dao.deletePatients(p.getId());
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Patients> viewAll(){
        return (List<Patients>) dao.findAll();
    }



}
