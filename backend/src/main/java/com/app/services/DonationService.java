package com.app.services;

import com.app.entities.Donation;
import com.app.entities.User;
import com.app.entities.BloodBank;
import com.app.entities.BloodGroup;
import com.app.repositories.BloodBankRepository;
import com.app.repositories.DonationRepository;
import com.app.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DonationService {

	@Autowired
    private DonationRepository donationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BloodBankRepository bloodBankRepository;

    // Method to create a donation
    public Donation createDonation(Long donorId, Long receiverId, Long bloodBankId, BloodGroup bloodType, Integer quantity) {
        // Fetch Donor entity
        Optional<User> donorOptional = userRepository.findById(donorId);
        if (!donorOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid donor ID");
        }
        User donor = donorOptional.get();

        // Fetch Receiver entity
        Optional<User> receiverOptional = userRepository.findById(receiverId);
        if (!receiverOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid receiver ID");
        }
        User receiver = receiverOptional.get();

        // Fetch BloodBank entity
        Optional<BloodBank> bloodBankOptional = bloodBankRepository.findById(bloodBankId);
        if (!bloodBankOptional.isPresent()) {
            throw new IllegalArgumentException("Invalid blood bank ID");
        }
        BloodBank bloodBank = bloodBankOptional.get();

        // Create and save the donation
        Donation donation = new Donation();
        donation.setDonor(donor); // Set the donor as User entity
        donation.setReceiver(receiver); // Set the receiver as User entity
        donation.setBloodBank(bloodBank); // Set the blood bank as BloodBank entity
        donation.setBloodType(bloodType);
        donation.setQuantity(quantity);
        donation.setDonationDate(LocalDate.now());
        donation.setIsCompleted(true); // Mark the donation as completed
        return donationRepository.save(donation);
    }

    public List<Donation> getUserDonations(Long donorId) {
        return donationRepository.findByDonorId(donorId);
    }

    public List<Donation> getBloodBankDonations(Long bloodBankId) {
        return donationRepository.findByBloodBankId(bloodBankId);
    }
}

