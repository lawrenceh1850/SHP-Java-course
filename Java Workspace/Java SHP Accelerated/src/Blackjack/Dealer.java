package Blackjack;

/**
 * Created by Lawrence Huang on 12/4/2016.
 */
public class Dealer extends Player {
    //instance variables - all in super
    //player name
    //player number
    //amount of money - unlimited
    //hand
    //bet amount
    //hand value
    //is busted

    public Dealer(){
        super("Dealer",0);
    }

    //Getter methods
    //all super default

    //public methods

    public void printHand(int gameStage){ //1 - before everybody is done, 2 - everybody is done
        System.out.println("Hand for " + super.getPlayerName());

        if(gameStage==1){
            System.out.println(getPlayerHand().get(0).getCardTypeStr() + "\n");

            System.out.println("Hand value for " + super.getPlayerName());
            System.out.println(super.getPlayerHand().get(0).getCardValue());
        }
        else if (gameStage==2) {
            for (int i = 0; i < super.getPlayerHand().size(); i++) {
                System.out.println(getPlayerHand().get(i).getCardTypeStr());
            }

            System.out.println("Hand value for " + super.getPlayerName() );
            System.out.println(super.getHandValue());
        }
        else {
            System.out.println("error in gamestage");
            Thread.dumpStack();
        }
    }

    //plays a round
    public void playRound(Deck gameDeck) {
        //reset
        super.setBusted(false);

        printDashedLine();
        System.out.println(super.getPlayerName() + " playing");
        printHand(2);

        while (super.getHandValue() <= 15) {

            //dealer has already been dealt in blackjack game - ***maybe change for later so that the dealer is initially dealt here more self contained
            super.playerDeal(gameDeck, 2);
            printHand(2);

            if(super.getIsBusted())
                return;
            if(super.getHandValue()<=15) {
                printDashedLine();
                System.out.println(super.getPlayerName() + " playing");
                printHand(2);
            }
        }
    }

    //private methods
}
