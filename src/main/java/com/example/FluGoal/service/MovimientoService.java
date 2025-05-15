package com.example.FluGoal.service;

import com.example.FluGoal.model.Avatar;
import com.example.FluGoal.model.Movimiento;
import com.example.FluGoal.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public List<Movimiento> listarMovimientos() {
        return movimientoRepository.findAll();
    }

    public Movimiento guardarMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public Optional<Movimiento> obtenerMovimientoPorId(int id) {
        return movimientoRepository.findById(id);
    }

    public void eliminarMovimiento(int id) {
        movimientoRepository.deleteById(id);
    }
}
