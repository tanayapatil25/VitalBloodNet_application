package com.app.services;

import com.app.entities.BloodBank;
import com.app.entities.Inventory;
import com.app.repositories.BloodBankRepository;
import com.app.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodBankService {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public BloodBank registerBloodBank(BloodBank bloodBank) {
        return bloodBankRepository.save(bloodBank);
    }

    public List<BloodBank> findBloodBanksInCity(String city) {
        return bloodBankRepository.findByCity(city);
    }

    public void updateInventory(Long bloodBankId, Inventory inventory) {
        Optional<BloodBank> bloodBankOpt = bloodBankRepository.findById(bloodBankId);
        if (bloodBankOpt.isPresent()) {
            Inventory existingInventory = bloodBankOpt.get().getInventory();
            if (existingInventory != null) {
                existingInventory.setBloodTypeQuantities(inventory.getBloodTypeQuantities());
                existingInventory.setLastUpdated(inventory.getLastUpdated());
                inventoryRepository.save(existingInventory);
            } else {
                inventory.setBloodBank(bloodBankOpt.get());
                inventoryRepository.save(inventory);
            }
        }
    }
}

