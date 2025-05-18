package com.example.FluGoal.service;

import com.example.FluGoal.model.Meta;
import com.example.FluGoal.model.Usuario;
import com.example.FluGoal.repository.MetaRepository;
import com.example.FluGoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Meta guardarMeta(Meta meta, Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));
        meta.setUsuario(usuario);
        return metaRepository.save(meta);
    }

    public List<Meta> obtenerMetasPorUsuario(Long usuarioId) {
        return metaRepository.findByUsuarioId(usuarioId);
    }

}
