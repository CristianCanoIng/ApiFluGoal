package com.example.FluGoal.service;

import com.example.FluGoal.model.Movimiento;
import com.example.FluGoal.model.Usuario;
import com.example.FluGoal.repository.MovimientoRepository;
import com.example.FluGoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Movimiento guardarMovimiento(Movimiento movimiento, Integer usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + usuarioId));
        movimiento.setUsuario(usuario);
        return movimientoRepository.save(movimiento);
    }

    public double obtenerTotalIngresadoEnMeta(Long metaId) {
        return movimientoRepository.sumarIngresosMetaPorMetaId(metaId);
    }

    public List<Movimiento> obtenerMovimientosPorUsuarioOrdenadosPorFecha(Long usuarioId) {
        return movimientoRepository.findAllByUsuarioIdOrderByFechaDesc(usuarioId);
    }

}
