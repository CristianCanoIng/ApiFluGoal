package com.example.FluGoal.service;

import com.example.FluGoal.model.Meta;
import com.example.FluGoal.repository.MetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    public Meta guardarMeta(Meta meta) {
        return metaRepository.save(meta);
    }

    public List<Meta> obtenerMetasPorUsuario(Long usuarioId) {
        return metaRepository.findByUsuarioId(usuarioId);
    }

}
