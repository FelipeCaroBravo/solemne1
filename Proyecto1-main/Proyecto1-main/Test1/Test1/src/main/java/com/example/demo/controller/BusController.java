package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BusEntity;
import com.example.demo.repository.BusRepository;

@RestController
@RequestMapping("/api/v1/entities/bus")
public class BusController {

    @Autowired
    private BusRepository repository;

    @GetMapping("/")
    public ResponseEntity<?> readBuses() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readBusesById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(repository.findById(id).orElse(null));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> saveBuses(@RequestBody BusEntity bus) {
        try {
            return ResponseEntity.ok(repository.save(bus));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBus(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBus(@PathVariable Long id, @RequestBody BusEntity bus) {
        try {
            BusEntity busActual = repository.findById(id).orElse(null);
    
            if (busActual == null) {
                return ResponseEntity.notFound().build();
            }
    
            busActual.setPatente(bus.getPatente());
            busActual.setMarca(bus.getMarca());
            busActual.setAnio(bus.getAnio());
            busActual.setKm(bus.getKm());
            busActual.setCombustible(bus.getCombustible());
            busActual.setRevisionAlDia(bus.isRevisionAlDia());
            
    
            return ResponseEntity.ok(repository.save(busActual));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e);
        }
    }
}
