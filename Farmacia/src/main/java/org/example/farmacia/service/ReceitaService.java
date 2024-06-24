package org.example.farmacia.service;

import org.example.farmacia.model.ReceitaModel;
import org.example.farmacia.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public List<ReceitaModel> findAll() {
        return receitaRepository.findAll();
    }

    public Optional<ReceitaModel> findById(Long id) {
        return receitaRepository.findById(id);
    }

    public ReceitaModel save(ReceitaModel receita) {
        return receitaRepository.save(receita);
    }

    public void deleteById(Long id) {
        receitaRepository.deleteById(id);
    }

    public ReceitaModel update(Long id, ReceitaModel receita) {
        if (receitaRepository.existsById(id)) {
            receita.setId(id);
            return receitaRepository.save(receita);
        } else {
            throw new RuntimeException("Receita não encontrada para o ID :: " + id);
        }
    }
}
