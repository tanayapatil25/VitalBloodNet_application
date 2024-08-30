package com.app.controllers;

import com.app.entities.BloodGroup;
import com.app.entities.Request;
import com.app.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/user")
    public Request createUserRequest(@RequestParam Long userId, @RequestParam Long bloodBankId,
                                     @RequestParam BloodGroup bloodGroup, @RequestParam Integer quantity) {
        return requestService.createUserRequest(userId, bloodBankId, bloodGroup, quantity);
    }

    @PostMapping("/hospital")
    public Request createHospitalRequest(@RequestParam Long hospitalId, @RequestParam Long bloodBankId,
                                         @RequestParam BloodGroup bloodGroup, @RequestParam Integer quantity) {
        return requestService.createHospitalRequest(hospitalId, bloodBankId, bloodGroup, quantity);
    }

    @PutMapping("/{requestId}/status")
    public void updateRequestStatus(@PathVariable Long requestId, @RequestParam String status) {
        requestService.updateRequestStatus(requestId, status);
    }

    @GetMapping("/user/{userId}")
    public List<Request> getUserRequests(@PathVariable Long userId) {
        return requestService.getUserRequests(userId);
    }

    @GetMapping("/donor/{donorId}")
    public List<Request> getDonorRequests(@PathVariable Long donorId) {
        return requestService.getDonorRequests(donorId);
    }

    @GetMapping("/bloodbank/{bloodBankId}")
    public List<Request> getBloodBankRequests(@PathVariable Long bloodBankId) {
        return requestService.getBloodBankRequests(bloodBankId);
    }

    @GetMapping("/hospital/{hospitalId}")
    public List<Request> getHospitalRequests(@PathVariable Long hospitalId) {
        return requestService.getHospitalRequests(hospitalId);
    }
}

