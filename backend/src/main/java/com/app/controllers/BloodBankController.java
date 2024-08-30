package com.app.controllers;

import com.app.entities.BloodBank;
import com.app.entities.Inventory;
import com.app.services.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodbanks")
public class BloodBankController {

    @Autowired
    private BloodBankService bloodBankService;

    @PostMapping("/register")
    public BloodBank registerBloodBank(@RequestBody BloodBank bloodBank) {
        return bloodBankService.registerBloodBank(bloodBank);
    }

    @GetMapping("/city")
    public List<BloodBank> findBloodBanksInCity(@RequestParam String city) {
        return bloodBankService.findBloodBanksInCity(city);
    }

    @PutMapping("/{bloodBankId}/inventory")
    public void updateInventory(@PathVariable Long bloodBankId, @RequestBody Inventory inventory) {
        bloodBankService.updateInventory(bloodBankId, inventory);
    }
}

