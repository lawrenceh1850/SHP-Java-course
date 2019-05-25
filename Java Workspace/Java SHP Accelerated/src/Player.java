import java.util.Scanner;

public class Player {
	final int COMP = 0, HUMAN = 1;
	private int status;
	private int score;
	private Die myDie;
	private Scanner input;

	public Player(){//should not reach here
		score = 0;
	}
	
	public Player(int human){
		score = 0; 
		status = human;
	}

	public void play(int x){
		if(status == HUMAN){
			System.out.println("What do you want to do?");
			System.out.println("(1) Roll");
			System.out.println("(2) End Round");
		}
		else if(status == COMP){
			
		}
		else
			throw new IllegalStateException("The status (human/comp) of this player was never initialized");
	}

	//public int getScore() {
		//return total score of players
	//}
}
