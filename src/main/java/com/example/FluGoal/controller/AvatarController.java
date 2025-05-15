package com.example.FluGoal.controller;

import com.example.FluGoal.model.Avatar;
import com.example.FluGoal.service.AvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avatares")
public class AvatarController {

    @Autowired
    private AvatarService avatarService;

    @GetMapping
    public List<Avatar> listarAvatares() {
        return avatarService.listarAvatares();
    }

    @PostMapping
    public Avatar guardarAvatar(@RequestBody Avatar avatar) {
        return avatarService.guardarAvatar(avatar);
    }

    @GetMapping("/{id}")
    public Optional<Avatar> obtenerAvatarPorId(@PathVariable int id) {
        return avatarService.obtenerAvatarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAvatar(@PathVariable int id) {
        avatarService.eliminarAvatar(id);
    }
}
