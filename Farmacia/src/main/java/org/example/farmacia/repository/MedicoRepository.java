package org.example.farmacia.repository;

import org.example.farmacia.model.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
}
