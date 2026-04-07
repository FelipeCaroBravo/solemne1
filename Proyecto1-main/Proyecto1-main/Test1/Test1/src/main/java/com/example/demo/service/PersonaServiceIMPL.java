package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfaces.IPersonaService;
import com.example.demo.repository.PersonaRepository;

@Service
public class PersonaServiceIMPL implements IPersonaService {

    @Autowired
    private PersonaRepository repository;

    // Obtener todas las personas
    @Override
    public List<PersonaEntity> listarTodos() {
        return (List<PersonaEntity>) repository.findAll();
    }

    // Obtener persona por ID
    @Override
    public Optional<PersonaEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    // Guardar persona
    @Override
    public PersonaEntity guardar(PersonaEntity persona) {
        return repository.save(persona);
    }

    // Eliminar persona
    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}