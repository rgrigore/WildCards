package com.wildcards.gamewhist.model;

public enum CardValue {
    HEARTS_ACE("H1"), HEARTS_2("H2"), HEARTS_3("H3"), HEARTS_4("H4"), HEARTS_5("H5"),
    HEARTS_6("H6"), HEARTS_7("H7"), HEARTS_8("H8"),HEARTS_9("H9"),HEARTS_10("H10"),
    HEARTS_JACK("H12"), HEARTS_QUEEN("H13"), HEARTS_KING("H14"),

    DIAMONDS_ACE("D1"), DIAMONDS_2("D2"), DIAMONDS_3("D3"), DIAMONDS_4("D4"), DIAMONDS_5("D5"),
    DIAMONDS_6("D6"), DIAMONDS_7("D7"), DIAMONDS_8("D8"), DIAMONDS_9("D9"), DIAMONDS_10("D10"),
    DIAMONDS_JACK("D12"), DIAMONDS_QUEEN("D13"), DIAMONDS_KING("D14"),

    SPADES_ACE("S1"), SPADES_2("S2"), SPADES_3("S3"), SPADES_4("S4"), SPADES_5("S5"),
    SPADES_6("S6"), SPADES_7("S7"), SPADES_8("S8"), SPADES_9("S9"), SPADES_10("S10"),
    SPADES_JACK("S12"), SPADES_QUEEN("S13"), SPADES_KING("S14"),

    CLUBS_ACE("C1"), CLUBS_2("C2"), CLUBS_3("C3"), CLUBS_4("C4"), CLUBS_5("C5"),
    CLUBS_6("C6"), CLUBS_7("C7"), CLUBS_8("C8"), CLUBS_9("C9"), CLUBS_10("C10"),
    CLUBS_JACK("C12"), CLUBS_QUEEN("C13"), CLUBS_KING("C14");

    private final String value;

    CardValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
