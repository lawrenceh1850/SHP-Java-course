package Blackjack;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lawrence Huang on 12/4/2016.
 */
public class Player {
    //instance variables
    //player name
    private String playerName;
    //player number
    private int playerNumber;
    //amount of money
    private double amountMoney;
    //hand
    private ArrayList<Card> playerHand;
    //bet amount
    private double betAmount;
    //hand value
    private int handValue;
    //busted or not
    private boolean isBusted;
    //bankrupted
    private boolean isBankrupted;


    //Constructor
    public Player(String _name,int _playerNumber){
        playerName = _name;
        playerNumber = _playerNumber;
        amountMoney = 0;
        betAmount = 0;
        handValue = 0;
        isBusted = false;
        isBankrupted = false;
    }

    //Getter methods
    public String getPlayerName(){
        return playerName;
    }
    public int getPlayerNumber(){
        return playerNumber;
    }
    public double getAmountMoney() {
        return amountMoney;
    }
    public double getBetAmount(){
        return betAmount;
    }
    public int getHandValue(){
        return handValue;
    }
    public boolean getIsBusted(){
        return isBusted;
    }
    public boolean getIsBankrupted(){
        return isBankrupted;
    }
    public ArrayList<Card> getPlayerHand(){
        return playerHand;
    }

    //setter methods
    public void setMoneyAmount(double _amountMoney){
        amountMoney = _amountMoney;
    }
    public void wonBet(){
        amountMoney+=betAmount;
    }
    public void lostBet(){
        amountMoney-=betAmount;
    }
    public void updatePlayerNumber(int newPlayerNum){
        playerNumber=newPlayerNum;
    }
    public void setBusted(boolean setBustedVal){
        isBusted = setBustedVal;
    }

    //Testing purposes
//    public void setHand(ArrayList<Card> handSet){
//        playerHand = new ArrayList<>(handSet);
//    }

    //public methods
    public void bet(){
        Scanner sc = new Scanner(System.in);
        betAmount = 0;

        printDashedLine();
        System.out.println("Player " + playerNumber + ": " + playerName + " betting");
        System.out.println("You have $" + amountMoney);

        do {
            if(betAmount>amountMoney)
                System.out.println("You only have $" + amountMoney);

            System.out.print("How much money do you want to bet?: ");
            betAmount = sc.nextDouble();
        }while(betAmount <= 0 || betAmount > amountMoney);
    }

    //dealtype
    //1 - initial
    //2 - subsequent
    public void playerDeal(Deck gameDeck, int dealType){
        if(dealType==1) {
            handValue = 0;
            playerHand = null;
        }
        playerHand = gameDeck.deckDeal(playerHand, dealType);
        calculateHand();
    }

    //prints hand
    public void printHand(){
        System.out.println("Hand for Player " + playerNumber + ": " + playerName);

        for(int i=0;i<playerHand.size();i++){
            System.out.println(playerHand.get(i).getCardTypeStr());
        }

        System.out.println("Hand value for Player " + playerNumber + ": " + playerName);
        System.out.println(handValue + "\n");
    }

    //plays a round
    public void playRound(Deck gameDeck){
        //reset all values for each player
        isBusted = false;

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            printDashedLine();
            System.out.println("Player " + playerNumber + ": " + playerName + " playing");
            System.out.println("You bet $" + betAmount + " on this round");
            printHand();
            System.out.print("Do you want to hit (1) or stand (2): ");
            choice = sc.nextInt();

            if(choice == 1) {
                playerDeal(gameDeck, 2);
                printHand();
            }
            if(isBusted)
                return;
        }while(choice != 2);
    }

    //check bankruptcy
    public void checkBankruptcy(){
       if(amountMoney<=0){
           isBankrupted=true;
       }
    }

    //public static methods
    public static void printDashedLine(){
        System.out.println("--------------------------");
    }

    //private methods
    public void calculateHand(){
        handValue = 0;
        Card currentEval;
        int numAces = 0;

        for(int i=0;i<playerHand.size();i++) {
            currentEval=playerHand.get(i); //card currently being evaluated
            if(currentEval.getCardTypeInt()==1) {
                handValue+=11;
                numAces++;
            }
            else if(currentEval.getCardTypeInt()>10){
                handValue+=10;
            }
            else
                handValue+=currentEval.getCardTypeInt();
        }
        while(numAces>0 && handValue>21){ //correct for aces
            handValue-=10;
            numAces--;
        }

        if(handValue>21){
            if(playerNumber>0)
                System.out.println("Player " + playerNumber + ": " + playerName + " has busted");
            else
                System.out.println(playerName + " has busted"); //for dealer
            isBusted = true;
            return;
        }
    }
}
