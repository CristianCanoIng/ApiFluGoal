package com.example.FluGoal.service;

import com.example.FluGoal.model.Usuario;
import com.example.FluGoal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public Map<String, Object> obtenerIdYNombre(String email, String password) {
        List<Object[]> resultado = usuarioRepository.findIdAndNombreByEmailAndPassword(email, password);
        if (resultado.isEmpty()) return null;

        Object[] fila = resultado.get(0);
        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("id", fila[0]);
        respuesta.put("nombre", fila[1]);
        return respuesta;
    }

}
