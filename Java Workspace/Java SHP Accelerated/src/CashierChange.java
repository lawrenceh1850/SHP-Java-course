import java.util.Scanner;

public class CashierChange {
	final static int PENNIES_PER_DOLLAR = 100;
	final static int PENNIES_PER_QUARTER = 25;
	final static int PENNIES_PER_DIME = 10;


	public static void printChange(int penniesPaid, int penniesRec){
		int diff = penniesRec-penniesPaid;
		
		System.out.println("You should return:");
		
		System.out.println(diff/PENNIES_PER_DOLLAR + " dollar(s)");
		diff%=PENNIES_PER_DOLLAR;
		
		System.out.println(diff/PENNIES_PER_QUARTER + " quarter(s)");
		diff%=PENNIES_PER_QUARTER;
		
		System.out.println(diff/PENNIES_PER_DIME + " dime(s)");
		diff%=PENNIES_PER_DIME;

		System.out.println(diff + " pennies");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int penniesPaid, penniesRec;
		
		System.out.println("How many pennies was the customer supposed to pay? ");
		penniesPaid = sc.nextInt();
		
		System.out.println("How many pennies did you receive? ");
		penniesRec = sc.nextInt();
		
		printChange(penniesPaid,penniesRec);
		
		sc.close();
	}

}
/*
How many pennies was the customer supposed to pay? 
100
How many pennies did you receive? 
1359
You should return:
12 dollar(s)
2 quarter(s)
0 dime(s)
9 pennies
*/