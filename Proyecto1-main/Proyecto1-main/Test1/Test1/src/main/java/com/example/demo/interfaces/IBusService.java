package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.BusEntity;

public interface IBusService {

    List<BusEntity> listarTodos();

    Optional<BusEntity> buscarPorId(Long id);

    BusEntity guardar(BusEntity persona);

    void eliminar(Long id);
}