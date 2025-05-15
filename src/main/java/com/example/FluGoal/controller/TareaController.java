package com.example.FluGoal.controller;

import com.example.FluGoal.model.Tarea;
import com.example.FluGoal.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> listarTareas() {
        return tareaService.listarTareas();
    }

    @PostMapping
    public Tarea guardarTarea(@RequestBody Tarea tarea) {
        return tareaService.guardarTarea(tarea);
    }

    @GetMapping("/{id}")
    public Optional<Tarea> obtenerTareaPorId(@PathVariable int id) {
        return tareaService.obtenerTareaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable int id) {
        tareaService.eliminarTarea(id);
    }
}
