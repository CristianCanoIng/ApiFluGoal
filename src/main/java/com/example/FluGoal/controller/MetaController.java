package com.example.FluGoal.controller;

import com.example.FluGoal.model.Meta;
import com.example.FluGoal.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> listarMetas() {
        return metaService.listarMetas();
    }

    @PostMapping
    public Meta guardarMeta(@RequestBody Meta meta) {
        return metaService.guardarMeta(meta);
    }

    @GetMapping("/{id}")
    public Optional<Meta> obtenerMetaPorId(@PathVariable int id) {
        return metaService.obtenerMetaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarMeta(@PathVariable int id) {
        metaService.eliminarMeta(id);
    }
}
