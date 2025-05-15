package com.example.FluGoal.controller;

import com.example.FluGoal.model.TiendaItem;
import com.example.FluGoal.service.TiendaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tienda-items")
public class TiendaItemController {

    @Autowired
    private TiendaItemService tiendaItemService;

    @GetMapping
    public List<TiendaItem> listarTiendaItems() {
        return tiendaItemService.listarTiendaItems();
    }

    @PostMapping
    public TiendaItem guardarTiendaItem(@RequestBody TiendaItem tiendaItem) {
        return tiendaItemService.guardarTiendaItem(tiendaItem);
    }

    @GetMapping("/{id}")
    public Optional<TiendaItem> obtenerTiendaItemPorId(@PathVariable int id) {
        return tiendaItemService.obtenerTiendaItemPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarTiendaItem(@PathVariable int id) {
        tiendaItemService.eliminarTiendaItem(id);
    }
}
