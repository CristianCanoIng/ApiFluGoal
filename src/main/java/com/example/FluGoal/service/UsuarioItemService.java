package com.example.FluGoal.service;

import com.example.FluGoal.model.UsuarioItem;
import com.example.FluGoal.repository.UsuarioItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioItemService {

    @Autowired
    private UsuarioItemRepository usuarioItemRepository;

    public List<UsuarioItem> listarUsuarioItems() {
        return usuarioItemRepository.findAll();
    }

    public UsuarioItem guardarUsuarioItem(UsuarioItem usuarioItem) {
        return usuarioItemRepository.save(usuarioItem);
    }

    public Optional<UsuarioItem> obtenerUsuarioItemPorId(int id) {
        return usuarioItemRepository.findById(id);
    }

    public void eliminarUsuarioItem(int id) {
        usuarioItemRepository.deleteById(id);
    }
}
