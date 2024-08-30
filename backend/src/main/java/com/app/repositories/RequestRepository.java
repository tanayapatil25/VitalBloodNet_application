package com.app.repositories;

import com.app.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByRequesterId(Long userId);
    List<Request> findByDonorId(Long userId);
    List<Request> findByBloodBankId(Long bloodBankId);
    List<Request> findByHospitalId(Long hospitalId);
}

