package org.example.farmacia.service;

import org.example.farmacia.model.MedicoModel;
import org.example.farmacia.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoModel> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<MedicoModel> findById(Long id) {
        return medicoRepository.findById(id);
    }

    public MedicoModel save(MedicoModel medico) {
        return medicoRepository.save(medico);
    }

    public void deleteById(Long id) {
        medicoRepository.deleteById(id);
    }

    public MedicoModel update(Long id, MedicoModel medico) {
        if (medicoRepository.existsById(id)) {
            medico.setId(id);
            return medicoRepository.save(medico);
        } else {
            throw new RuntimeException("Medico não encontrado para o ID :: " + id);
        }
    }
}
