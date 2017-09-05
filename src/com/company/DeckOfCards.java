package com.company;


import java.util.*;

public class DeckOfCards {

    private static final List<Card> deck = new ArrayList<>();
    private static final ArrayList<Card> orderedDeck = new ArrayList<>();

    private Map<Integer, String> cardsRank = new TreeMap<>();
    private Map<String, Integer> drawnCardNumber= new HashMap<>();
    private int cardsDrawn = 1;

    public void newDeck(){
        for (Suit suit: Suit.values()) {

            for (RankOfCards rankOfCards : RankOfCards.values()) {
                deck.add(new Card(rankOfCards, suit));
                orderedDeck.add(new Card(rankOfCards, suit));
            }
        }
        //shuffles the deck after its been created
        Collections.shuffle(deck);
    }


    public List<Card> returnedList(){
        return deck;
    }



public void getCards(int cardnumber) {
    OrderOfCards o = new OrderOfCards();
    o.amountToDraw(cardnumber);
}

    public Card drawCard(){


        Card c = returnedList().get(0);
        returnedList().remove(0);

        return c;
    }

    public int cardsLeft(){
        return returnedList().size();
    }

    public Card drawRankedCard(){
        OrderOfCards o = new OrderOfCards();

        return o.drawnRanks();

    }
    public void allDraws(){
        OrderOfCards o = new OrderOfCards();
        o.cardsRanksString();
    }


//inner-class below
    private class OrderOfCards {


    public List<Card> listByRank(){

//code below can be replaced by Lambda expressions. (But to me, this is more understandable rn)
        Collections.sort(orderedDeck, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {

                return Integer.compare(o1.getCardRank(), o2.getCardRank());


            }
        });

        return orderedDeck;

        //above sorts the deck according to the value it has
    }

    public List<Card> fullSortedList(){

        Collections.sort(listByRank(), new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {

                return Integer.compare(o1.getSuitRank(), o2.getSuitRank());
            }
        });
        return listByRank();
    }


    public  void amountToDraw(int cardNumbers) {

        try {

            int draw = 1;
            //unlikes HashMap treeMaps sorts the keys by value
            Map<Integer, String> finalRank = new TreeMap<>();

            //Hasmap to keep track of which draw each card was
            HashMap<String, Integer> drawnCard = new HashMap<>();

            //Draws as many cards as user inputted, and puts the draw number in a hashmap. Also shows how many cards are left
            for (int i = 0; i < cardNumbers; i++) {
                Card temp = drawCard();
                System.out.println("Draw " + draw + " is a: " + temp.fullCardName());
                System.out.println("Cards left: " + cardsLeft());
                drawnCard.put(temp.fullCardName(), draw);


                /*Loops through the entire size of the deck. fullSortedList == an orderedList which index of a card = to the cards full value (ie. ACE of SPADES == 52, if ACE=14).
                then checks if the card we drew first(from the shuffled deck) is equal to any of the cards in the ordered deck
                this will be true eventually, and when it is, the index of the orderedList will be put as the Key in the treeMap and the card name as String value
                 since the orderedlist is sorted in whatever rank the cards have, this will work. */

                for (int j = 0; j < fullSortedList().size(); j++) {

                    if (temp.fullCardName().equals(fullSortedList().get(j).fullCardName())) {
                        finalRank.put(j, temp.fullCardName()); //puts the complete value of the cards as int and the cards full name
                    }
                }
                draw++;

            }

            int rank = finalRank.size();
            System.out.println("\n From the cards drawn, the best/worst of the cards is the following: \n");
            for (Integer i : finalRank.keySet()) {
                System.out.println(finalRank.get(i) + " is rank #" + rank + ". (Drawn card number #" + drawnCard.get(finalRank.get(i)) + ")");
                rank--;

            }

            System.out.println("\nThere's now: " + cardsLeft() + " cards left. ");
        }catch (Exception e) {
            System.out.println(e);
        }

    }

    public Card drawnRanks() {

        Card card = drawCard();
       // int numberOfCards = fullSortedList().size();

//        for (int i = 0; i < numberOfCards; i++) {
//            if (card.fullCardName().equals(fullSortedList().get(i).fullCardName()))
//                cardsRank.put(i, card.fullCardName());
//
//        }
        drawnCardNumber.put(card.fullCardName(), cardsDrawn);
        cardsDrawn++;



        return card;
    }

    public void cardsRanksString(){
        int rank = cardsRank.size();



        for (Integer i : cardsRank.keySet()) {
            System.out.println(cardsRank.get(i) + " is rank # " + rank + ". (Drawn cards number #" + drawnCardNumber.get(cardsRank.get(i)) + ")" );
            rank--;
        }
    }


        }

}

