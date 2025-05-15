package com.example.FluGoal.controller;

import com.example.FluGoal.model.UsuarioItem;
import com.example.FluGoal.service.UsuarioItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario-items")
public class UsuarioItemController {

    @Autowired
    private UsuarioItemService usuarioItemService;

    @GetMapping
    public List<UsuarioItem> listarUsuarioItems() {
        return usuarioItemService.listarUsuarioItems();
    }

    @PostMapping
    public UsuarioItem guardarUsuarioItem(@RequestBody UsuarioItem usuarioItem) {
        return usuarioItemService.guardarUsuarioItem(usuarioItem);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioItem> obtenerUsuarioItemPorId(@PathVariable int id) {
        return usuarioItemService.obtenerUsuarioItemPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioItem(@PathVariable int id) {
        usuarioItemService.eliminarUsuarioItem(id);
    }
}
