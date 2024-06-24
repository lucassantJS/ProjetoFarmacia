package org.example.farmacia.repository;

import org.example.farmacia.model.ReceitaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaRepository extends JpaRepository<ReceitaModel, Long> {
}
