package com.app.services;

import com.app.entities.Hospital;
import com.app.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital registerHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> findHospitalsInCity(String city) {
        return hospitalRepository.findByCity(city);
    }
}

