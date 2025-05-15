package com.example.FluGoal.controller;

import com.example.FluGoal.model.Recompensa;
import com.example.FluGoal.service.RecompensaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    @Autowired
    private RecompensaService recompensaService;

    @GetMapping
    public List<Recompensa> listarRecompensas() {
        return recompensaService.listarRecompensas();
    }

    @PostMapping
    public Recompensa guardarRecompensa(@RequestBody Recompensa recompensa) {
        return recompensaService.guardarRecompensa(recompensa);
    }

    @GetMapping("/{id}")
    public Optional<Recompensa> obtenerRecompensaPorId(@PathVariable int id) {
        return recompensaService.obtenerRecompensaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarRecompensa(@PathVariable int id) {
        recompensaService.eliminarRecompensa(id);
    }
}
