package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.BusEntity;
import com.example.demo.interfeces.IBusService;

@Service
public class BusServiceIMPL implements IBusService {

    private final String URL = "http://localhost:6789/api/v1/entities/bus";
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<BusEntity> listarTodos() {
        BusEntity[] buses = restTemplate.getForObject(URL + "/", BusEntity[].class);
        return Arrays.asList(buses);
    }

    @Override
    public BusEntity findById(long id) {
        return restTemplate.getForObject(URL + "/" + id, BusEntity.class);
    }

    @Override
    public BusEntity save(BusEntity bus) {
        return restTemplate.postForObject(URL + "/", bus, BusEntity.class);
    }

    @Override
    public BusEntity update(long id, BusEntity bus) {
        HttpEntity<BusEntity> requestEntity = new HttpEntity<>(bus);
        ResponseEntity<BusEntity> response = restTemplate.exchange(
                URL + "/" + id,
                HttpMethod.PUT,
                requestEntity,
                BusEntity.class
        );
        return response.getBody();
    }

    @Override
    public void deleteById(long id) {
        restTemplate.delete(URL + "/" + id);
    }
}
