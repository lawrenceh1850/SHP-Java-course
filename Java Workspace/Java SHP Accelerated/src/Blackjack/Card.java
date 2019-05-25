package Blackjack;

/**
 * Created by Lawrence Huang on 12/4/2016.
 */
public class Card {
    private String cardTypeStr;
    private int cardTypeInt;

//    Cards 2-10 are valued at the face value of the card. - int value is value
//    Face cards such as the King, Queen, and Jack are valued at 10 each. - int value is 10
//    The Ace card, however, is a special card and which be valued either at 11 or 1. - int value is 1 fault but 11 depending

    //constructor
    public Card(int _cardTypeInt){
        cardTypeInt = _cardTypeInt;
        if (_cardTypeInt==1)
            cardTypeStr = "A";
        else if(_cardTypeInt==11)
            cardTypeStr = "J";
        else if(_cardTypeInt==12)
            cardTypeStr = "Q";
        else if(_cardTypeInt==13)
            cardTypeStr = "K";
        else
            cardTypeStr = Integer.toString(_cardTypeInt);
    }
    public Card(String _cardTypeStr){
        cardTypeStr = _cardTypeStr.trim();
        if(cardTypeStr.equals("A"))
            cardTypeInt = 1;
        else if(cardTypeStr.equals("J"))
            cardTypeInt = 10;
        else if(cardTypeStr.equals("Q"))
            cardTypeInt = 11;
        else if(cardTypeStr.equals("K"))
            cardTypeInt = 12;
        else
            cardTypeInt = Integer.parseInt(_cardTypeStr);
    }

    //getter methods
    public String getCardTypeStr(){
        return cardTypeStr;
    }
    public int getCardTypeInt(){
        return cardTypeInt;
    }

    //get value methods
    public int getCardValue(){
        if(cardTypeInt>10)
            return 10;
        else if(cardTypeInt==1)
            return 11;
        else
            return cardTypeInt;
    }
}
