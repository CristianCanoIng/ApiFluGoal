package com.example.FluGoal.repository;

import com.example.FluGoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END FROM usuario u WHERE u.email = :correo", nativeQuery = true)
        Boolean existeCorreo(@Param("correo") String correo);

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> findByEmail(@Param("email") String email);

    @Query("SELECT u.nombre FROM Usuario u WHERE u.id = :id")
    String obtenerNombrePorId(@Param("id") Long id);

    @Query("SELECT u.id, u.nombre FROM Usuario u WHERE u.email = :email AND u.password = :password")
    List<Object[]> findIdAndNombreByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
