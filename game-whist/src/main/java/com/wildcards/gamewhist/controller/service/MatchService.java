package com.wildcards.gamewhist.controller.service;

import com.wildcards.gamewhist.model.CardValue;
import com.wildcards.gamewhist.model.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MatchService {
    private final DeckProvider deckProvider;

    private final List<Match> matches = new ArrayList<>();

    public Optional<Match> getMatch(String matchId) {
        return matches.stream().filter(match -> match.getId().toString().equals(matchId)).findFirst();
    }

    public void assignPlayerToMatch(Long playerId) {
        matches.stream().filter(match -> !match.isFull()).findFirst().ifPresentOrElse(
                match -> { // Existing match
                    match.addPlayer(playerId);
                    if (match.isFull()) {
                        startMatch(match);
                    }
                },
                () -> { // New match
                    Match newMatch = new Match();
                    newMatch.addPlayer(playerId);
                    matches.add(newMatch);
                }
        );
    }

    public void startMatch(Match match) {
        match.initializePlayers(ThreadLocalRandom.current().nextInt(match.getPlayers().size()));
        dealCards(match);
    }

    public void startNewRound(Match match) {
        match.advanceRound();
        dealCards(match);
    }

    public void dealCards(Match match) {
        Iterator<CardValue> deck = deckProvider.getShuffledDeck();

        int cardsToDeal = calculateRoundValue(match.getRoundCount());
        int currentPlayerIndex = match.getCurrentPlayerIndex();
        int playerCount = match.getPlayers().size();

        List<List<CardValue>> playerHands = new ArrayList<>(4);
        for (int i = currentPlayerIndex; i < currentPlayerIndex + playerCount; i++) {
            if (i >= playerCount) {
                playerHands.add(match.getPlayerHands(i - playerCount));
            } else {
                playerHands.add(match.getPlayerHands(i));
            }
        }

        for (int i = 0; i < cardsToDeal; i++) {
            playerHands.forEach(hand -> hand.add(deck.next()));
        }

        match.setTrumpCard(deck.next());
    }

    public int calculateRoundValue(int roundCount) { // 1 1 1 1 2 3 4 5 6 7 8 8 8 8 7 6 5 4 3 2 1 1 1 1
        if (roundCount < 4 || roundCount > 19) {
            return 1;
        } else if (roundCount < 10) {
            return roundCount - 2;
        } else if (roundCount > 13) {
            return 21 - roundCount;
        } else {
            return 8;
        }
    }

    public boolean validateCardToPlay(String matchId, Long playerId, CardValue playedCard) { // TODO
        Optional<Match> match = getMatch(matchId);

        if (match.isEmpty()) {
            return false;
        }

        CardValue trumpCard = match.get().getTrumpCard();

        return true;
    }

    public boolean validatePrediction(String matchId, int prediction) {
        Optional<Match> match = getMatch(matchId);

        if (match.isEmpty()) {
            return false;
        }
        if (match.get().getPlayerPredictions().size() < match.get().getPlayers().size() - 1) {
            return true;
        }

        int currentPredictionSum = match.get().getPlayerPredictions().values().stream().reduce(0, Integer::sum);
        return currentPredictionSum + prediction != calculateRoundValue(match.get().getRoundCount());
    }

    public void playCard(String matchId, Long playerId, CardValue playedCard) { // TODO

    }

    public void predictWins(String matchId, Long playerId, int prediction) { // TODO

    }
}
