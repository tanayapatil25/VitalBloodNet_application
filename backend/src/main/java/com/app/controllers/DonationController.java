package com.app.controllers;

import com.app.entities.Donation;
import com.app.entities.BloodGroup;
import com.app.services.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private DonationService donationService;

    @PostMapping("/create")
    public Donation createDonation(@RequestParam Long donorId, @RequestParam Long receiverId, 
                                   @RequestParam Long bloodBankId, @RequestParam BloodGroup bloodGroup, 
                                   @RequestParam Integer quantity) {
        return donationService.createDonation(donorId, receiverId, bloodBankId, bloodGroup, quantity);
    }

    @GetMapping("/user/{userId}")
    public List<Donation> getUserDonations(@PathVariable Long userId) {
        return donationService.getUserDonations(userId);
    }

    @GetMapping("/bloodbank/{bloodBankId}")
    public List<Donation> getBloodBankDonations(@PathVariable Long bloodBankId) {
        return donationService.getBloodBankDonations(bloodBankId);
    }
}

