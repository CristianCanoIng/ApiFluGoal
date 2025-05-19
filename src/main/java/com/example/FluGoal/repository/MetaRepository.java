package com.example.FluGoal.repository;

import com.example.FluGoal.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Long> {

    @Query("SELECT m FROM Meta m WHERE m.usuario.id = :usuarioId")
    List<Meta> findByUsuarioId(@Param("usuarioId") Long usuarioId);
}
