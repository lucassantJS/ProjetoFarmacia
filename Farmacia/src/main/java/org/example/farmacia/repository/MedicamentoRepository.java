package org.example.farmacia.repository;


import org.example.farmacia.model.MedicamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {

}