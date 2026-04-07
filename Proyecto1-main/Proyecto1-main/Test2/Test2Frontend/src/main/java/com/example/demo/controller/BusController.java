package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.BusEntity;
import com.example.demo.interfeces.IBusService;

@Controller
@RequestMapping("crud/bus")
public class BusController {

    @Autowired
    private IBusService service;

    @GetMapping("/")
    public String listarBuses(Model model) {
        List<BusEntity> buses = service.listarTodos();
        model.addAttribute("buses", buses);
        model.addAttribute("bus", new BusEntity());
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String buscarPorId(@PathVariable long id, Model model) {
        BusEntity bus = service.findById(id);
        model.addAttribute("bus", bus);
        return "detalle";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute BusEntity bus) {
        service.save(bus);
        return "redirect:/crud/bus/";
    }

    @GetMapping("/edit/{id}")
    public String editarPersona(@PathVariable long id, Model model) {
        BusEntity bus = service.findById(id);
        model.addAttribute("bus", bus);
        return "editar";
    }

    @PostMapping("/update")
    public String actualizarPersona(@ModelAttribute BusEntity bus) {
        service.update(bus.getId(), bus);
        return "redirect:/crud/bus/";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/crud/bus/";
    }
}
