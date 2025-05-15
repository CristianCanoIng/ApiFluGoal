package com.example.FluGoal.service;

import com.example.FluGoal.model.TiendaItem;
import com.example.FluGoal.repository.TiendaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaItemService {

    @Autowired
    private TiendaItemRepository tiendaItemRepository;

    public List<TiendaItem> listarTiendaItems() {
        return tiendaItemRepository.findAll();
    }

    public TiendaItem guardarTiendaItem(TiendaItem tiendaItem) {
        return tiendaItemRepository.save(tiendaItem);
    }

    public Optional<TiendaItem> obtenerTiendaItemPorId(int id) {
        return tiendaItemRepository.findById(id);
    }

    public void eliminarTiendaItem(int id) {
        tiendaItemRepository.deleteById(id);
    }
}
