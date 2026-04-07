package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.PersonaEntity;

public interface IPersonaService {

    List<PersonaEntity> listarTodos();

    Optional<PersonaEntity> buscarPorId(Long id);

    PersonaEntity guardar(PersonaEntity persona);

    void eliminar(Long id);
}