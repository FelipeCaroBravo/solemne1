package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BusEntity;
import com.example.demo.interfaces.IBusService;
import com.example.demo.repository.BusRepository;

@Service
public class BusServiceIMPL implements IBusService {

    @Autowired
    private BusRepository repository;


    @Override
    public List<BusEntity> listarTodos() {
        return (List<BusEntity>) repository.findAll();
    }


    @Override
    public Optional<BusEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }


    @Override
    public BusEntity guardar(BusEntity bus) {
        return repository.save(bus);
    }


    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}