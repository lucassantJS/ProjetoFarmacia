package org.example.farmacia.controller;

import org.example.farmacia.model.ReceitaModel;
import org.example.farmacia.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @GetMapping
    public List<ReceitaModel> getAllReceitas() {
        return receitaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReceitaModel> getReceitaById(@PathVariable Long id) {
        Optional<ReceitaModel> receita = receitaService.findById(id);
        if (receita.isPresent()) {
            return ResponseEntity.ok(receita.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ReceitaModel createReceita(@RequestBody ReceitaModel receita) {
        return receitaService.save(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReceitaModel> updateReceita(@PathVariable Long id, @RequestBody ReceitaModel receita) {
        try {
            ReceitaModel updatedReceita = receitaService.update(id, receita);
            return ResponseEntity.ok(updatedReceita);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id) {
        if (receitaService.findById(id).isPresent()) {
            receitaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
