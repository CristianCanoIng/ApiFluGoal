package com.example.FluGoal.repository;

import com.example.FluGoal.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends JpaRepository<Meta, Integer> {

}
