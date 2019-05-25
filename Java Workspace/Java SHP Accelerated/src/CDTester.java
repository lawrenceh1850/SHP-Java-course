import java.util.InputMismatchException;

/**
 * Created by Lawrence Huang on 11/4/2016.
 * CDTester tests the CDCollection class
 */
public class CDTester {
    public static void main(String[] args){
        CDCollection myCollection = new CDCollection();

        CD myCD = new CD();
        System.out.println(myCD.getCost());

        //empty
        System.out.println(myCollection.toString());

        //add CD
        myCollection.addCD("A Night at the Opera","Queen",18.50,12);

        //print newly updated
        System.out.println(myCollection.toString());

        //remove
        myCollection.removeCD("A Night at the Opera");

        //after removal
        System.out.println(myCollection.toString());
    }
}
