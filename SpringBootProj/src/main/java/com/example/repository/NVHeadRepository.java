package com.example.repository;

import com.example.model.NVHead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NVHeadRepository extends JpaRepository<NVHead, Integer> {

    NVHead findNVHeadByDescription(String description);
    NVHead findNVHeadByCumId(Integer cumId);

}
