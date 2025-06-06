package com.example.FluGoal.service;

import com.example.FluGoal.model.Usuario;
import com.example.FluGoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Boolean verificarCorreoExistente(String correo) {
        return usuarioRepository.existeCorreo(correo);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public String obtenerNombreUsuarioPorId(Long id) {
        return usuarioRepository.obtenerNombrePorId(id);
    }

}
