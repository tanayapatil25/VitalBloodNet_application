package com.app.repositories;

import com.app.entities.BloodGroup;
import com.app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByCityAndIsActiveDonorAndBloodGroup(String city, Boolean isActiveDonor, BloodGroup bloodGroup);
}

