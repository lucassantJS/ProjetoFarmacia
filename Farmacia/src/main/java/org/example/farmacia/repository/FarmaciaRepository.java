package org.example.farmacia.repository;

import org.example.farmacia.model.FarmaciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmaciaRepository extends JpaRepository<FarmaciaModel, Long> {

}