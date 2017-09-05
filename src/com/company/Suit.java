package com.company;

public enum Suit {
    SPADES(1),
    HEARTS(2),
    DIAMONDS(3),
    CLUBS(4);

    private int values;

    Suit(int values) {
        this.values = values;
    }

    public int getValues() {
        return values;
    }
    //enums are constants that are also objects

}
