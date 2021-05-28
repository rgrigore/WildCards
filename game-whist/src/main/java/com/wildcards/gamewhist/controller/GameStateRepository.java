package com.wildcards.gamewhist.controller;

import com.wildcards.gamewhist.model.GameState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameStateRepository extends JpaRepository<GameState, Long> {
}
