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

    public List<Movimiento> obtenerEgresosPorUsuario(Long usuarioId) {
        return movimientoRepository.findEgresosByUsuarioIdOrderByFechaDesc(usuarioId);
    }

    public void eliminarMovimientoPorId(Integer movimientoId) {
        if (!movimientoRepository.existsById(movimientoId)) {
            throw new RuntimeException("Movimiento no encontrado con ID: " + movimientoId);
        }
        movimientoRepository.deleteById(movimientoId);
    }

    public Movimiento actualizarMovimiento(Integer movimientoId, Movimiento movimientoActualizado) {
        Movimiento movimientoExistente = movimientoRepository.findById(movimientoId)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con ID: " + movimientoId));

        movimientoExistente.setDescripcion(movimientoActualizado.getDescripcion());
        movimientoExistente.setMonto(movimientoActualizado.getMonto());
        movimientoExistente.setFecha(movimientoActualizado.getFecha());
        movimientoExistente.setTipo(movimientoActualizado.getTipo());
        movimientoExistente.setPresupuesto(movimientoActualizado.getPresupuesto());

        return movimientoRepository.save(movimientoExistente);
    }

    public Movimiento obtenerMovimientoPorId(Integer movimientoId) {
        return movimientoRepository.findById(movimientoId)
                .orElseThrow(() -> new RuntimeException("Movimiento no encontrado con ID: " + movimientoId));
    }

}
