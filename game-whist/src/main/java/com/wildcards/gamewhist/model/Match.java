package com.wildcards.gamewhist.model;

import lombok.Data;

import java.util.*;

@Data()
public class Match {
    private final static int MATCH_CAPACITY = 2; // TODO Change this to 4
    private final UUID id = UUID.randomUUID();

    private CardValue trumpCard;

    private final List<Long> players = new ArrayList<>();
    private final Map<Long, CardValue> playedCards = new HashMap<>();
    private final Map<Long, List<CardValue>> playerHands = new HashMap<>();

    private final Map<Long, Integer> playerPredictions = new HashMap<>();

    private int roundLeaderIndex;
    private int currentPlayerIndex;
    private int roundCount;

    public void addPlayer(Long playerId) {
        players.add(playerId);
        playedCards.put(playerId, null);
        playerHands.put(playerId, new ArrayList<>());
    }

    public Long getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void advanceTurn() {
        currentPlayerIndex++;
        if (currentPlayerIndex == players.size()) {
            currentPlayerIndex = 0;
        }
    }

    public void advanceRound() {
        roundCount++;
        roundLeaderIndex++;
        if (roundLeaderIndex == players.size()) {
            roundLeaderIndex = 0;
        }
        currentPlayerIndex = roundLeaderIndex;
    }

    public void initializePlayers(int playerIndex) {
        roundLeaderIndex = playerIndex;
        currentPlayerIndex = roundLeaderIndex;
        roundCount = 0;
    }

    public boolean isFull() {
        return players.size() == MATCH_CAPACITY;
    }

    public List<CardValue> getPlayerHands(Long playerId) {
        return playerHands.get(playerId);
    }

    public List<CardValue> getPlayerHands(int playerIndex) {
        return getPlayerHands(players.get(playerIndex));
    }
}
