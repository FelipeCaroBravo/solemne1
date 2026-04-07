package com.example.demo.interfeces;

import java.util.List;
import com.example.demo.entity.BusEntity;

public interface IBusService {

    List<BusEntity> listarTodos();

    BusEntity findById(long id);

    BusEntity save(BusEntity persona);

    BusEntity update(long id, BusEntity persona);

    void deleteById(long id);
}
