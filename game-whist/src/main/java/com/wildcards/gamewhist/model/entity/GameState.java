package com.wildcards.gamewhist.model.entity;

import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import com.wildcards.gamewhist.model.CardValue;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@TypeDef(
        name = "card_array",
        typeClass = ListArrayType.class,
        parameters = {
                @Parameter(
                        name = ListArrayType.SQL_ARRAY_TYPE,
                        value = "card"
                )
        }
)
public class GameState {
    @Id
    private Float id;

    private Long player1;
    private Long player2;

    @Column(columnDefinition = "card")
    private CardValue player1Played;
    @Column(columnDefinition = "card")
    private CardValue player2Played;

    @Type(type = "card_array")
    @Column(
            name = "player1_hand",
            columnDefinition = "card[]"
    )
    private List<CardValue> player1Hand;
    @Type(type = "card_array")
    @Column(
            name = "player2_hand",
            columnDefinition = "card[]"
    )
    private List<CardValue> player2Hand;

    @Column(columnDefinition = "card")
    private CardValue trumpCard;
}
