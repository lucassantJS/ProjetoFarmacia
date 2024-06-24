package org.example.farmacia.controller;

import org.example.farmacia.model.MedicamentoModel;
import org.example.farmacia.service.MedicamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public List<MedicamentoModel> getAllMedicamentos() {
        return medicamentoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicamentoModel> getMedicamentoById(@PathVariable Long id) {
        Optional<MedicamentoModel> medicamento = medicamentoService.findById(id);
        if (medicamento.isPresent()) {
            return ResponseEntity.ok(medicamento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MedicamentoModel createMedicamento(@RequestBody MedicamentoModel medicamento) {
        return medicamentoService.save(medicamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicamentoModel> updateMedicamento(@PathVariable Long id, @RequestBody MedicamentoModel medicamento) {
        try {
            MedicamentoModel updatedMedicamento = medicamentoService.update(id, medicamento);
            return ResponseEntity.ok(updatedMedicamento);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicamento(@PathVariable Long id) {
        if (medicamentoService.findById(id).isPresent()) {
            medicamentoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
