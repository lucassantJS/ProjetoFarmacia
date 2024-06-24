package org.example.farmacia.controller;

import org.example.farmacia.model.MedicoModel;
import org.example.farmacia.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public List<MedicoModel> getAllMedicos() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoModel> getMedicoById(@PathVariable Long id) {
        Optional<MedicoModel> medico = medicoService.findById(id);
        if (medico.isPresent()) {
            return ResponseEntity.ok(medico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public MedicoModel createMedico(@RequestBody MedicoModel medico) {
        return medicoService.save(medico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoModel> updateMedico(@PathVariable Long id, @RequestBody MedicoModel medico) {
        try {
            MedicoModel updatedMedico = medicoService.update(id, medico);
            return ResponseEntity.ok(updatedMedico);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedico(@PathVariable Long id) {
        if (medicoService.findById(id).isPresent()) {
            medicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
