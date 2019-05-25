import java.text.DecimalFormat;

/**
 * Created by Lawrence Huang on 11/1/2016.
 * CDCollection simulates a CD collection and allows a user to add/remove CD's and print the contents of the collection
 */
public class CDCollection {
    //Static variables
    private static final int TERMINAL_WIDTH = 80;

    //Instance variables
    private final int COLLECTION_SIZE = 100;
    private CD[] collection = new CD[COLLECTION_SIZE];
    private int count;
    private double totalCost;

    //constructors
    public CDCollection(){
        count = 0;
        totalCost = 0;
    }

    //private static methods
    private static String getSepLine(int numDashes){
        String line="";

        for(int x=0;x<numDashes;x++)
            line += "-";

        return line;
    }

    //public methods
    public void addCD(String title, String artist, double cost, int tracks){
        CD CDInsert = new CD(title, artist, cost, tracks);
        int insert=0;

        try {
            for (insert = count; insert > 0 && collection[insert-1].compareTo(CDInsert) > 0; insert--) {
                collection[insert] = collection[insert-1];
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The CD Collection is full.");
        }
        catch (NullPointerException e){
            System.out.println("CD missing from position " + insert);
        }

        try{
            collection[insert] = new CD(title, artist, cost, tracks);
            totalCost += cost;
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The CD Collection is full.");
        }

        count++;
    }
    // add this CD to “collection” while maintaining the
    // collection in order

    // Since you are starting the CD collection from scratch,
    // you can assume that the array is always ordered
    // and you just have to find the correct spot for this one }

    public void removeCD(String title) {
        // remove the correct CD and maintain the
        // order of the array afterward
        // (no null elements in between CDs)

        int location=0;

        try {
            while (location <= count && collection[location].getTitle().equals(title)!=true) {
                location++;
            }
            if(location>count){
                System.out.println("The title \"" + title + " was not found within the collection.");
                return;
            }
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("The title \"" + title + " was not found within the collection.");
        }

        //erase CD, deprecate count, subtract cost
        count--;
        totalCost-=-collection[location].getCost();
        collection[location]=null;

        for(int i=location;i<=count;i++)
            collection[i]=collection[i+1];
    }

    public String toString () {
        // must include total # of CDs, total cost, average cost,
        // and a list of all the CDs
        // (hint: toString of CD class is public)

        DecimalFormat df = new DecimalFormat("0.00");

        String CDCollectionDetails = getSepLine(TERMINAL_WIDTH) + "Number of CD's: " + Integer.toString(count) + "\n" + "Total Cost: $"
                + df.format(totalCost) + "\n\n" +  "List of all CD's:\n";

        try {
            if(count==0){
                CDCollectionDetails+="No CD's in this collection" + "\n";
            }
            else {
                for (int i = 0; i < collection.length && collection[i] != null; i++) {
                    CDCollectionDetails += "CD Number " + (i + 1) + "\n" + collection[i].toString();
                }
            }
        }
        catch (NullPointerException e){
            System.out.println("\n\nCD missing from middle of collection");
        }

        CDCollectionDetails+= getSepLine(TERMINAL_WIDTH);

        return CDCollectionDetails;
    }

    //public static methods
    //used only for user input
    public static void printMenu(String[] menuOptions){

        System.out.println(getSepLine(TERMINAL_WIDTH));
        for(int i=0;i<menuOptions.length;i++){
            System.out.println(i + ".) " + menuOptions[i]);
        }
        System.out.println(getSepLine(TERMINAL_WIDTH));
    }

    public static void printInitialOptions(){
        String[] initialMenuOptions = {"Print contents of collection", "Add CD", "Remove CD"};

        printMenu(initialMenuOptions);
    }

    public static void printInputOptions(){
        String[] inputOptions = {"Title", "Artist", "Cost", "Number of Tracks"};

        printMenu(inputOptions);
    }
}