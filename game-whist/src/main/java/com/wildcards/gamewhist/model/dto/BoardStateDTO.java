package com.wildcards.gamewhist.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardStateDTO {
    private List<String> playerHand;
    private String playerPlayedCard;
    private Map<Long, Integer> opponentsHandSizes;
    private Map<Long, String> playedCards;
    private String trumpCard;
    private Long playerTurn;
}
