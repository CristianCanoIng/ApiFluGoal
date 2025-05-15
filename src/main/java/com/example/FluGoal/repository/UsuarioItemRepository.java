package com.example.FluGoal.repository;

import com.example.FluGoal.model.UsuarioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioItemRepository extends JpaRepository<UsuarioItem, Integer> {

}
