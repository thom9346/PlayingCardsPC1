package com.company;

import java.util.ArrayList;

public class Card {

    private final RankOfCards rankOfCards;
    private final Suit suit;


    public Card(RankOfCards rankOfCards, Suit suit) {
        this.rankOfCards = rankOfCards;
        this.suit = suit;
    }

    public RankOfCards getRankOfCards() {
        return rankOfCards;
    }

    public Suit getSuit() {
        return suit;
    }

    public String fullCardName(){ return rankOfCards + " Of " + suit; }

    public int getCardRank(){return rankOfCards.getValue();}

    public int getSuitRank(){return suit.getValues(); }


//    private class Ranking{
//
//        public int getCardRank(){
//
//           return rankOfCards.getValue();
//
//        }
//
//        public int getSuitRank(){
//
//            return suit.getValues();
////        }
//
//        public void compareRanks(){
//
//        }
//
//    }
        }


