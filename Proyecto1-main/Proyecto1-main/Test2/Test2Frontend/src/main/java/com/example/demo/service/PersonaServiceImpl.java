package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfeces.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private final String URL = "http://localhost:6789/api/v1/entities/persona";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<PersonaEntity> listarTodos() {
        PersonaEntity[] personas = restTemplate.getForObject(URL + "/", PersonaEntity[].class);
        return Arrays.asList(personas);
    }

    @Override
    public PersonaEntity findById(long id) {
        return restTemplate.getForObject(URL + "/" + id, PersonaEntity.class);
    }

    @Override
    public PersonaEntity save(PersonaEntity persona) {
        return restTemplate.postForObject(URL + "/", persona, PersonaEntity.class);
    }

    @Override
    public PersonaEntity update(long id, PersonaEntity persona) {
        HttpEntity<PersonaEntity> requestEntity = new HttpEntity<>(persona);
        ResponseEntity<PersonaEntity> response = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.PUT,
                requestEntity,
                PersonaEntity.class
        );
        return response.getBody();
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(URL + "/" + id);
    }
}
