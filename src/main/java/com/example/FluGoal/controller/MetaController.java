package com.example.FluGoal.controller;

import com.example.FluGoal.model.Meta;
import com.example.FluGoal.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metas")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @PostMapping
    public Meta guardarMeta(@RequestBody Meta meta) {
        return metaService.guardarMeta(meta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Meta> obtenerMetasPorUsuario(@PathVariable Long usuarioId) {
        return metaService.obtenerMetasPorUsuario(usuarioId);
    }
}
