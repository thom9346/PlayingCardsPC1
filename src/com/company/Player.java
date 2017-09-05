package com.company;

import java.util.HashMap;
import java.util.Map;

public class Player implements Runnable {

    private DeckOfCards deckOfCards = new DeckOfCards();

    private int turns = Main.MAX_TURNS;
    private Player nextPlayer;
    private boolean mustPlay = false;
    private int playerNumber;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    //    private Map drawCard = new HashMap();
//
//    public Player(Map drawCard) {
//        this.drawCard = drawCard;
//    }

    @Override
    public void run() {

        try {

            //deckOfCards.drawRankedCard();
            System.out.println("Player " + playerNumber + " drew a: " + deckOfCards.drawRankedCard().fullCardName());
            Thread.sleep(5000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private boolean gameFinished(){
        return turns == 0;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void setMustPlay(boolean mustPlay) {
        this.mustPlay = mustPlay;
    }
}
