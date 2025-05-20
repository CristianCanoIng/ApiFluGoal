package com.example.FluGoal.repository;

import com.example.FluGoal.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT COALESCE(SUM(m.monto), 0) FROM Movimiento m WHERE m.presupuesto.id = :metaId AND m.tipo = 'IngresoMeta'")
    double sumarIngresosMetaPorMetaId(@Param("metaId") Long metaId);

    @Query("SELECT m FROM Movimiento m WHERE m.usuario.id = :usuarioId ORDER BY m.fecha DESC")
    List<Movimiento> findAllByUsuarioIdOrderByFechaDesc(@Param("usuarioId") Long usuarioId);

    @Query("SELECT m FROM Movimiento m WHERE m.usuario.id = :usuarioId AND m.tipo = 'Egreso' ORDER BY m.fecha DESC")
    List<Movimiento> findEgresosByUsuarioIdOrderByFechaDesc(@Param("usuarioId") Long usuarioId);

    @Query("SELECT m FROM Movimiento m WHERE m.usuario.id = :usuarioId AND m.tipo = 'Ingreso' ORDER BY m.fecha DESC")
    List<Movimiento> findIngresosByUsuarioIdOrderByFechaDesc(@Param("usuarioId") Long usuarioId);

    @Query("SELECT m FROM Movimiento m WHERE m.usuario.id = :usuarioId AND m.tipo = 'IngresoMeta' ORDER BY m.fecha DESC")
    List<Movimiento> findIngresosMetasByUsuarioIdOrderByFechaDesc(@Param("usuarioId") Long usuarioId);

    @Query("SELECT m FROM Movimiento m WHERE m.usuario.id = :usuarioId AND m.tipo = 'Ahorro' ORDER BY m.fecha DESC")
    List<Movimiento> findAhorrosByUsuarioIdOrderByFechaDesc(@Param("usuarioId") Long usuarioId);

}
