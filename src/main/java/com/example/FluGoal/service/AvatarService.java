package com.example.FluGoal.service;

import com.example.FluGoal.model.Avatar;
import com.example.FluGoal.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    public List<Avatar> listarAvatares() {
        return avatarRepository.findAll();
    }

    public Avatar guardarAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }

    public Optional<Avatar> obtenerAvatarPorId(int id) {
        return avatarRepository.findById(id);
    }

    public void eliminarAvatar(int id) {
        avatarRepository.deleteById(id);
    }
}
