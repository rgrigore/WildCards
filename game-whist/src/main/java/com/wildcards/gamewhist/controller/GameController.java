package com.wildcards.gamewhist.controller;

import com.wildcards.gamewhist.controller.service.GameService;
import com.wildcards.gamewhist.model.dto.BoardStateDTO;
import com.wildcards.gamewhist.model.dto.PlayCardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GameController {
    private final GameService service;

    @GetMapping("/state/{matchId}/{playerId}") // Temp solution until users get implemented
    public BoardStateDTO getBoardState(@PathVariable String matchId, @PathVariable Long playerId) {
        return service.getBoardStateForPlayer(matchId, playerId); // TODO Get the playerId from the gateway.
    }

    @PostMapping("/play/{matchId}/{playerId}")
    public void playCard(PlayCardDTO playCardDTO, @PathVariable String matchId, @PathVariable Long playerId) {
        service.playCard(matchId, playerId, playCardDTO.getCard());
    }

    @PostMapping("/predict/{matchId}/{playerId}")
    public void predictWins(@RequestParam int prediction, @PathVariable String matchId, @PathVariable Long playerId) {
        service.predictWins(matchId, playerId, prediction);
    }

    @PostMapping("/connect/{playerId}")
    public String connectToGame(@PathVariable Long playerId) {
        return service.connectPlayer(playerId);
    }
}
