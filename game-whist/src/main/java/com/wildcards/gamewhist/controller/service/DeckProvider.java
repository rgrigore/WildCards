package com.wildcards.gamewhist.controller.service;

import com.wildcards.gamewhist.model.CardValue;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DeckProvider {
    private final static List<CardValue> DECK = Arrays.asList(CardValue.values());

    public Iterator<CardValue> getShuffledDeck() {
        List<CardValue> deckCopy = new ArrayList<>(DECK);

        Collections.shuffle(deckCopy);
        return deckCopy.iterator();
    }
}
