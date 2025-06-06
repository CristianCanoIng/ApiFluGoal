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

    @GetMapping("/usuario/{usuarioId}/egresos")
    public ResponseEntity<List<Movimiento>> obtenerEgresosPorUsuario(@PathVariable Long usuarioId) {
        List<Movimiento> egresos = movimientoService.obtenerEgresosPorUsuario(usuarioId);
        return ResponseEntity.ok(egresos);
    }

    @GetMapping("/usuario/{usuarioId}/ingresos")
    public ResponseEntity<List<Movimiento>> obtenerIngresosPorUsuario(@PathVariable Long usuarioId) {
        List<Movimiento> ingresos = movimientoService.obtenerIngresosPorUsuario(usuarioId);
        return ResponseEntity.ok(ingresos);
    }

    @GetMapping("/usuario/{usuarioId}/ahorros")
    public ResponseEntity<List<Movimiento>> obtenerAhorrosPorUsuario(@PathVariable Long usuarioId) {
        List<Movimiento> ahorros = movimientoService.obtenerAhorrosPorUsuario(usuarioId);
        return ResponseEntity.ok(ahorros);
    }

    @GetMapping("/usuario/{usuarioId}/ingresos_metas")
    public ResponseEntity<List<Movimiento>> obtenerIngresosMetasPorUsuario(@PathVariable Long usuarioId) {
        List<Movimiento> ingresos_metas = movimientoService.obtenerIngresosMetasPorUsuario(usuarioId);
        return ResponseEntity.ok(ingresos_metas);
    }

    @PutMapping("/{movimientoId}")
    public ResponseEntity<Movimiento> actualizarMovimiento(
            @PathVariable Integer movimientoId,
            @RequestBody Movimiento movimientoActualizado
    ) {
        Movimiento movimiento = movimientoService.actualizarMovimiento(movimientoId, movimientoActualizado);
        return ResponseEntity.ok(movimiento);
    }

    @DeleteMapping("/{movimientoId}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Integer movimientoId) {
        movimientoService.eliminarMovimientoPorId(movimientoId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{movimientoId}")
    public ResponseEntity<Movimiento> obtenerMovimientoPorId(@PathVariable Integer movimientoId) {
        Movimiento movimiento = movimientoService.obtenerMovimientoPorId(movimientoId);
        return ResponseEntity.ok(movimiento);
    }
}
