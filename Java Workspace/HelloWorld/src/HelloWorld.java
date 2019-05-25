import java.util.ArrayList;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		int x=1;
		int y=1;
		
		System.out.println(x++ + " " + (y=x+1));

		x=1;
		y=1;
		
		System.out.println(++x + " " + (y=x+1));
	}

}
