package org.example.farmacia.service;

import org.example.farmacia.model.FarmaciaModel;
import org.example.farmacia.repository.FarmaciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmaciaService {

    @Autowired
    private FarmaciaRepository farmaciaRepository;

    public List<FarmaciaModel> findAll() {
        return farmaciaRepository.findAll();
    }

    public Optional<FarmaciaModel> findById(Long id) {
        return farmaciaRepository.findById(id);
    }

    public FarmaciaModel save(FarmaciaModel farmacia) {
        return farmaciaRepository.save(farmacia);
    }

    public void deleteById(Long id) {
        farmaciaRepository.deleteById(id);
    }

    public FarmaciaModel update(Long id, FarmaciaModel farmacia) {
        if (farmaciaRepository.existsById(id)) {
            farmacia.setCnpj(id);
            return farmaciaRepository.save(farmacia);
        } else {
            throw new RuntimeException("Farmacia não encontrada para o ID :: " + id);
        }
    }
}
