package com.app.services;

import com.app.entities.*;
import com.app.repositories.BloodBankRepository;
import com.app.repositories.HospitalRepository;
import com.app.repositories.RequestRepository;
import com.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {


    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Autowired
    private HospitalRepository hospitalRepository;

    // Method to create a user request
    public Request createUserRequest(Long userId, Long bloodBankId, BloodGroup bloodGroup, Integer quantity) {
        // Fetch User entity
        Optional<User> userOptional = userRepository.findById(userId);
        if (!userOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        User user = userOptional.get();

        // Fetch BloodBank entity
        Optional<BloodBank> bloodBankOptional = bloodBankRepository.findById(bloodBankId);
        if (!bloodBankOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid blood bank ID");
        }
        BloodBank bloodBank = bloodBankOptional.get();

        // Create and save the request
        Request request = new Request();
        request.setRequester(user); // Set the requester as User entity
        request.setBloodBank(bloodBank); // Set the blood bank as BloodBank entity
        request.setBloodType(bloodGroup);
        request.setQuantity(quantity);
        request.setStatus("PENDING");
        request.setRequestDate(LocalDate.now());
        return requestRepository.save(request);
    }

    // Method to create a hospital request
    public Request createHospitalRequest(Long hospitalId, Long bloodBankId, BloodGroup bloodType, Integer quantity) {
        // Fetch Hospital entity
        Optional<Hospital> hospitalOptional = hospitalRepository.findById(hospitalId);
        if (!hospitalOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid hospital ID");
        }
        Hospital hospital = hospitalOptional.get();

        // Fetch BloodBank entity
        Optional<BloodBank> bloodBankOptional = bloodBankRepository.findById(bloodBankId);
        if (!bloodBankOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid blood bank ID");
        }
        BloodBank bloodBank = bloodBankOptional.get();

        // Create and save the request
        Request request = new Request();
        request.setHospital(hospital); // Set the hospital
        request.setBloodBank(bloodBank); // Set the blood bank
        request.setBloodType(bloodType);
        request.setQuantity(quantity);
        request.setStatus("PENDING");
        request.setRequestDate(LocalDate.now());
        return requestRepository.save(request);
    }

    public void updateRequestStatus(Long requestId, String status) {
        requestRepository.findById(requestId).ifPresent(request -> {
            request.setStatus(status);
            if (status.equals("Fulfilled")) {
                request.setFulfillDate(LocalDate.now());
            }
            requestRepository.save(request);
        });
    }

    public List<Request> getUserRequests(Long userId) {
        return requestRepository.findByRequesterId(userId);
    }

    public List<Request> getDonorRequests(Long userId) {
        return requestRepository.findByDonorId(userId);
    }

    public List<Request> getBloodBankRequests(Long bloodBankId) {
        return requestRepository.findByBloodBankId(bloodBankId);
    }

    public List<Request> getHospitalRequests(Long hospitalId) {
        return requestRepository.findByHospitalId(hospitalId);
    }
}
