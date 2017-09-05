package com.company;


import java.util.*;

public class Main {

    public static final int MAX_TURNS = 52; //number of cards

    public static void main(String[] args) {

        DeckOfCards deckOfCards = new DeckOfCards();
        deckOfCards.newDeck(); //creates a new deck


        chooseValueOfAce();

        Thread p1 = new Thread(new Player(1));
        Thread p2 = new Thread(new Player(2));
        Thread p3 = new Thread(new Player(3));
        Thread p4 = new Thread(new Player(4));

        p1.start();
        p2.start();
        p3.start();
        p4.start();

        deckOfCards.drawRankedCard();
        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();
//        deckOfCards.drawRankedCard();

        deckOfCards.allDraws();

//        System.out.println("There's this many cards in the deck: "+ deckOfCards.returnedList().size() + ". Following is the entire shuffled deck:");
//
//        for (int i = 0; i < deckOfCards.returnedList().size(); i++) {
//            System.out.print(deckOfCards.returnedList().get(i).fullCardName() +", ");
//
//        }
//        System.out.println("\n");
//
//        chooseValueOfAce();
//
//        System.out.println("How many cards do you wanna draw? (max "+deckOfCards.returnedList().size() + ")");
//        Scanner scanner = new Scanner(System.in);
//        int cardsToDraw = scanner.nextInt();
//
//        System.out.println();
//
//        deckOfCards.getCards(cardsToDraw);

    }
    public static void chooseValueOfAce() {

        RankOfCards ace = RankOfCards.ACE;

        System.out.println("Press A if you want ACE to be worth 14");
        System.out.println("Press anything else if you want ACE to be worth 1");

        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();

        if (answer.equalsIgnoreCase("A")) {
            ace.setValues(14);
        } else
            ace.setValues(1);
    }


    }


