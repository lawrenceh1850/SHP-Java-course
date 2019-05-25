import java.util.InputMismatchException;
import java.util.Scanner;
public class Exceptions {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		while (true) {
			try {
				System.out.println(s.nextInt());
			}
			catch (InputMismatchException e) {
				System.out.println("yo, thats not a number dumb dumb");
				s.next();
			}
		}
	}
}
