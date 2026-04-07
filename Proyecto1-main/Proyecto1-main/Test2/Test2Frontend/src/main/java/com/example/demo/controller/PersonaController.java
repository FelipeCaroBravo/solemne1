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

import com.example.demo.entity.PersonaEntity;
import com.example.demo.interfeces.IPersonaService;

@Controller
@RequestMapping("crud/persona")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping("/")
    public String listarPersonas(Model model) {
        List<PersonaEntity> personas = service.listarTodos();
        model.addAttribute("personas", personas);
        model.addAttribute("persona", new PersonaEntity());
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String buscarPorId(@PathVariable long id, Model model) {
        PersonaEntity persona = service.findById(id);
        model.addAttribute("persona", persona);
        return "detalle";
    }

    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute PersonaEntity persona) {
        service.save(persona);
        return "redirect:/crud/persona/";
    }

    @GetMapping("/edit/{id}")
    public String editarPersona(@PathVariable long id, Model model) {
        PersonaEntity persona = service.findById(id);
        model.addAttribute("persona", persona);
        return "editar";
    }

    @PostMapping("/update")
    public String actualizarPersona(@ModelAttribute PersonaEntity persona) {
        service.update(persona.getId(), persona);
        return "redirect:/crud/persona/";
    }

    @GetMapping("/del/{id}")
    public String deleteById(@PathVariable long id) {
        service.deleteById(id);
        return "redirect:/crud/persona/";
    }
}
