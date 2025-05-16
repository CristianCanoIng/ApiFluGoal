package com.example.FluGoal.controller;

import com.example.FluGoal.model.Usuario;
import com.example.FluGoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/correo/{correo}")
    public ResponseEntity<Boolean> verificarCorreo(@PathVariable("correo") String correo) {
        Boolean existe = usuarioService.verificarCorreoExistente(correo);
        return ResponseEntity.ok(existe);
    }

    @PostMapping
    public ResponseEntity<Void> guardarUsuario(@RequestBody Usuario usuario) {
        usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Usuario> obtenerUsuarioPorEmail(@PathVariable String email) {
        return usuarioService.obtenerUsuarioPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}/nombre")
    public ResponseEntity<String> obtenerNombre(@PathVariable Long id) {
        String nombre = usuarioService.obtenerNombreUsuarioPorId(id);
        return nombre != null ? ResponseEntity.ok(nombre)
                : ResponseEntity.notFound().build();
    }

}
