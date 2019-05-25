/**
 * Created by Lawrence Huang on 11/1/2016.
 */
import java.text.DecimalFormat;

public class CD implements Comparable<CD>{
    private String title;
    private String artist;
    private double cost;
    private int numTracks;

    //constructors
    public CD(){
        title = null;
        artist = null;
        cost = 0.0;
        numTracks = 0;
    }

    public CD(String _title, String _artist, double _cost, int _numberOfTracks){
        this.title = _title;
        this.artist = _artist;
        this.cost = _cost;
        this.numTracks = _numberOfTracks;
    }

    //public methods
    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public double getCost(){
        return this.cost;
    }

    public int getNumTracks(){
        return this.numTracks;
    }

    public int compareTo(CD otherCD){ //alphabetical by title
        if(this.title.compareTo(otherCD.getTitle())<0) //alphabetically less
            return -1;
        else if (this.title.compareTo(otherCD.getTitle())==0)
            return 0;
        else
            return 1;
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.00");

        return "Title: " + title + "\n" + "Artist: " + artist + "\n" + "Cost: "
                + df.format(this.cost) + "\n" + "Number of Tracks: " + numTracks + "\n\n";
    }
}
