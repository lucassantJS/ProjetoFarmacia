package org.example.farmacia.controller;

import org.example.farmacia.model.FarmaciaModel;
import org.example.farmacia.service.FarmaciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/farmacias")
public class FarmaciaController {

    @Autowired
    private FarmaciaService farmaciaService;

    @GetMapping
    public List<FarmaciaModel> getAllFarmacias() {
        return farmaciaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FarmaciaModel> getFarmaciaById(@PathVariable Long id) {
        Optional<FarmaciaModel> farmacia = farmaciaService.findById(id);
        if (farmacia.isPresent()) {
            return ResponseEntity.ok(farmacia.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public FarmaciaModel createFarmacia(@RequestBody FarmaciaModel farmacia) {
        return farmaciaService.save(farmacia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FarmaciaModel> updateFarmacia(@PathVariable Long id, @RequestBody FarmaciaModel farmacia) {
        try {
            FarmaciaModel updatedFarmacia = farmaciaService.update(id, farmacia);
            return ResponseEntity.ok(updatedFarmacia);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmacia(@PathVariable Long id) {
        if (farmaciaService.findById(id).isPresent()) {
            farmaciaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
