package org.example.farmacia.service;

import org.example.farmacia.model.MedicamentoModel;
import org.example.farmacia.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<MedicamentoModel> findAll() {
        return medicamentoRepository.findAll();
    }

    public Optional<MedicamentoModel> findById(Long id) {
        return medicamentoRepository.findById(id);
    }

    public MedicamentoModel save(MedicamentoModel medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public void deleteById(Long id) {
        medicamentoRepository.deleteById(id);
    }

    public MedicamentoModel update(Long id, MedicamentoModel medicamento) {
        if (medicamentoRepository.existsById(id)) {
            medicamento.setIdMedicamento(id);
            return medicamentoRepository.save(medicamento);
        } else {
            throw new RuntimeException("Medicamento não encontrado para o ID :: " + id);
        }
    }
}
