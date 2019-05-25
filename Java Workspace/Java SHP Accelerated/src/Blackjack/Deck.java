package Blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Calendar;

/**
 * Created by Lawrence Huang on 12/4/2016.
 */
public class Deck {
    private ArrayList<Card> gameDeck;
    private final int NUM_CARD_TYPES = 13;
    private Calendar cal = Calendar.getInstance();
    private Random rand;

    public Deck(int numDecks){
        gameDeck = new ArrayList<Card>();

        for(int cardType=1;cardType<=NUM_CARD_TYPES;cardType++){
            for(int i=0;i<4;i++) {
                for (int deckNumCounter = 0; deckNumCounter < numDecks; deckNumCounter++) {
                    gameDeck.add(new Card(cardType));
                }
            }
        }
    }

    //getter
    public int getDeckSize(){
        return gameDeck.size();
    }

    public void shuffle(){
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();

        int initialGameDeckSize = gameDeck.size();

        rand = new Random(cal.getTimeInMillis());

        for(int i=0;i<initialGameDeckSize;i++){
            shuffledDeck.add(gameDeck.remove(rand.nextInt(gameDeck.size()))); //random exclusive for upper bound
        }

        gameDeck.clear();

        for(Card e:shuffledDeck)
            gameDeck.add(e);
    }

    public void addCards(ArrayList<Card> cardsAdded){
        for(Card e:cardsAdded){
            gameDeck.add(e);
        }
    }

    public void printDeck(){
        for(Card e:gameDeck) {
            System.out.println(e.getCardTypeInt() + " " + e.getCardTypeStr());
        }
    }

    public ArrayList<Card> deckDeal(ArrayList<Card> playerHand, int dealType) {
        ArrayList<Card> hand;

        rand = new Random(cal.getTimeInMillis());
        
        int initialGameDeckSize = gameDeck.size();

        if (dealType == 1) {
            hand = new ArrayList<Card>();
            hand.add(gameDeck.remove(rand.nextInt(initialGameDeckSize))); //arraylist starts from 0
            hand.add(gameDeck.remove(rand.nextInt(initialGameDeckSize)));
        }
        else if (dealType == 2){
            hand = new ArrayList<Card>(playerHand);
            hand.add(gameDeck.remove(gameDeck.size() - 1));

            System.out.println("Dealt a(n) " + hand.get(0).getCardTypeStr());
        }
        else{
            System.out.println("error with dealtype in deckdeal");
            Thread.dumpStack();
            return null;
        }

        return hand;
    }
}
