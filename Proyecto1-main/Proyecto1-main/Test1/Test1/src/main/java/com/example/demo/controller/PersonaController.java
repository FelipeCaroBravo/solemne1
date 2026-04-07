package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.repository.PersonaRepository;

@RestController
@RequestMapping("/api/v1/entities/persona")
public class PersonaController {

    @Autowired
    private PersonaRepository repository;

    @GetMapping("/")
    public ResponseEntity<?> readPersonas() {
        try {
            return ResponseEntity.ok(repository.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readPersonaById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(repository.findById(id).orElse(null));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }

    @PostMapping("/")
    public ResponseEntity<?> savePersona(@RequestBody PersonaEntity persona) {
        try {
            return ResponseEntity.ok(repository.save(persona));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePersona(@PathVariable Long id, @RequestBody PersonaEntity persona) {
        try {
            PersonaEntity personaActual = repository.findById(id).orElse(null);
    
            if (personaActual == null) {
                return ResponseEntity.notFound().build();
            }
    
            personaActual.setNombre(persona.getNombre());
    
            return ResponseEntity.ok(repository.save(personaActual));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e);
        }
    }
}
