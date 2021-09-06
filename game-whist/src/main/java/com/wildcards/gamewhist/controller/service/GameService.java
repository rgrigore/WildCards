package com.wildcards.gamewhist.controller.service;

import com.wildcards.gamewhist.model.dto.BoardStateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameService {
    private final MatchService matchService;

    public BoardStateDTO getBoardStateForPlayer(String matchId, Long playerId) { // TODO
        return null;
    }

    public void playCard(String matchId, Long playerId, String card) {

    }

    public void predictWins(String matchId, Long playerId, int prediction) {

    }

    public String connectPlayer(Long playerId) {
        return null;
    }
}
