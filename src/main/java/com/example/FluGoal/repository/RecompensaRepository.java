package com.example.FluGoal.repository;

import com.example.FluGoal.model.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Integer> {

}
