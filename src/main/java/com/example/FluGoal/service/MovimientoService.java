package com.example.FluGoal.service;

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

    public Movimiento guardarMovimiento(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }

    public double obtenerTotalIngresadoEnMeta(Long metaId) {
        return movimientoRepository.sumarIngresosMetaPorMetaId(metaId);
    }

}
