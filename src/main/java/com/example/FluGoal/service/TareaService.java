package com.example.FluGoal.service;

import com.example.FluGoal.model.Tarea;
import com.example.FluGoal.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> obtenerTareaPorId(int id) {
        return tareaRepository.findById(id);
    }

    public void eliminarTarea(int id) {
        tareaRepository.deleteById(id);
    }
}
