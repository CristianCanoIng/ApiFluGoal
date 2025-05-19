package com.example.FluGoal.controller;

import com.example.FluGoal.model.Meta;
import com.example.FluGoal.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<Meta> guardarMetaConUsuario(
            @PathVariable Integer usuarioId,
            @RequestBody Meta meta
    ) {
        Meta guardada = metaService.guardarMeta(meta, usuarioId);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Meta> obtenerMetasPorUsuario(@PathVariable Long usuarioId) {
        return metaService.obtenerMetasPorUsuario(usuarioId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meta> obtenerMetaPorId(@PathVariable Long id) {
        Meta meta = metaService.obtenerMetaPorId(id);
        return ResponseEntity.ok(meta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meta> actualizarMeta(
            @PathVariable Long id,
            @RequestBody Meta metaActualizada
    ) {
        Meta meta = metaService.actualizarMeta(id, metaActualizada);
        return ResponseEntity.ok(meta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMeta(@PathVariable Long id) {
        metaService.eliminarMeta(id);
        return ResponseEntity.noContent().build();
    }
}
