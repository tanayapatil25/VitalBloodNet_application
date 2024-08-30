package com.app.controllers;

import com.app.entities.Hospital;
import com.app.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @PostMapping("/register")
    public Hospital registerHospital(@RequestBody Hospital hospital) {
        return hospitalService.registerHospital(hospital);
    }

    @GetMapping("/city")
    public List<Hospital> findHospitalsInCity(@RequestParam String city) {
        return hospitalService.findHospitalsInCity(city);
    }
}

