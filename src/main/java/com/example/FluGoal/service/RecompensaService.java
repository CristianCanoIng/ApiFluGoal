package com.example.FluGoal.service;

import com.example.FluGoal.model.Recompensa;
import com.example.FluGoal.repository.RecompensaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    public List<Recompensa> listarRecompensas() {
        return recompensaRepository.findAll();
    }

    public Recompensa guardarRecompensa(Recompensa recompensa) {
        return recompensaRepository.save(recompensa);
    }

    public Optional<Recompensa> obtenerRecompensaPorId(int id) {
        return recompensaRepository.findById(id);
    }

    public void eliminarRecompensa(int id) {
        recompensaRepository.deleteById(id);
    }
}
