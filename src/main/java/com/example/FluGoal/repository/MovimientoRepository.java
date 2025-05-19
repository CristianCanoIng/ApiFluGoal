package com.example.FluGoal.repository;

import com.example.FluGoal.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

    @Query("SELECT COALESCE(SUM(m.monto), 0) FROM Movimiento m WHERE m.presupuesto.id = :metaId AND m.tipo = 'IngresoMeta'")
    double sumarIngresosMetaPorMetaId(@Param("metaId") Long metaId);

}
