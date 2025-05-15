package com.example.FluGoal.repository;

import com.example.FluGoal.model.TiendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiendaItemRepository extends JpaRepository<TiendaItem, Integer> {

}
