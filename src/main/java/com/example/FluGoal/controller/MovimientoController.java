package com.example.FluGoal.controller;

import com.example.FluGoal.model.Movimiento;
import com.example.FluGoal.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping
    public Movimiento guardarMovimiento(@RequestBody Movimiento movimiento) {
        return movimientoService.guardarMovimiento(movimiento);
    }

    @GetMapping("/metas/{metaId}/ingresosMeta")
    public ResponseEntity<Double> obtenerTotalIngresadoEnMeta(@PathVariable Long metaId) {
        double total = movimientoService.obtenerTotalIngresadoEnMeta(metaId);
        return ResponseEntity.ok(total);
    }



}
