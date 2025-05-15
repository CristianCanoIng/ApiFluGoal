package com.example.FluGoal.controller;

import com.example.FluGoal.model.Movimiento;
import com.example.FluGoal.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public List<Movimiento> listarMovimientos() {
        return movimientoService.listarMovimientos();
    }

    @PostMapping
    public Movimiento guardarMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.guardarMovimiento(movimiento);
    }

    @GetMapping("/{id}")
    public Optional<Movimiento> obtenerMovimientoPorId(@PathVariable int id) {
        return movimientoService.obtenerMovimientoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMovimiento(@PathVariable int id) {
        movimientoService.eliminarMovimiento(id);
    }
}
