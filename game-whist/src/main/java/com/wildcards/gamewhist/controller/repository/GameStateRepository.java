package com.wildcards.gamewhist.controller.repository;

import com.wildcards.gamewhist.model.entity.GameState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStateRepository extends JpaRepository<GameState, Long> {
}
