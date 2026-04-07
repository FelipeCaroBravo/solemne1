package com.example.demo.interfeces;

import java.util.List;
import com.example.demo.entity.PersonaEntity;

public interface IPersonaService {

    List<PersonaEntity> listarTodos();

    PersonaEntity findById(long id);

    PersonaEntity save(PersonaEntity persona);

    PersonaEntity update(long id, PersonaEntity persona);

    void deleteById(long id);
}
