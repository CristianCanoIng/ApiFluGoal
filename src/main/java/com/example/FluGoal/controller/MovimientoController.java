package com.example.FluGoal.controller;

import com.example.FluGoal.model.Movimiento;
import com.example.FluGoal.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Movimiento> guardarMovimientoConUsuario(
            @PathVariable Integer usuarioId,
            @RequestBody Movimiento movimiento
    ) {
        Movimiento guardada = movimientoService.guardarMovimiento(movimiento, usuarioId);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping("/metas/{metaId}/ingresosMeta")
    public ResponseEntity<Double> obtenerTotalIngresadoEnMeta(@PathVariable Long metaId) {
        double total = movimientoService.obtenerTotalIngresadoEnMeta(metaId);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/usuario/{usuarioId}/historial")
    public ResponseEntity<List<Movimiento>> obtenerHistorialDeMovimientos(@PathVariable Long usuarioId) {
        List<Movimiento> movimientos = movimientoService.obtenerMovimientosPorUsuarioOrdenadosPorFecha(usuarioId);
        return ResponseEntity.ok(movimientos);
    }
}
