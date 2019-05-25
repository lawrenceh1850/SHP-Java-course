/**
 * Created by Lawrence Huang on 11/7/2016.
 */
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LetterFreq {
    public static void main (String[] args){
        String sep = File.separator;
        String filePath = null;
        File inputFile = null;
        Scanner sc = null;
        int[] letterFreq = new int[26];
        int totalLetters = 0;
        double[] letterPerc = new double[26];

        for(int i=0;i<letterFreq.length;i++) {
            letterFreq[i] = 0;
            letterPerc[i] = 0;
        }

        System.out.println(System.getProperty("user.dir"));

        try {
            filePath = System.getProperty("user.dir") + sep + "src" + sep + "Input.txt";
            inputFile = new File(filePath);
            sc = new Scanner(inputFile);
        }
        catch (FileNotFoundException e){
            System.out.println("File " + inputFile.toString() + " not found.");
            return;
        }

        while(sc.hasNext()){
            String word = sc.next();
            word = word.toUpperCase();
            for(int i=0;i<word.length();i++) {
                char letter = word.charAt(i);
                int letterNum = (int) (letter - 'A');

                if (letterNum <= 25 && letterNum >= 0)
                    letterFreq[letterNum]++;
            }
        }

        for(int i=0;i<letterFreq.length;i++){
            totalLetters+=letterFreq[i];
        }

        for(int i=0;i<letterFreq.length;i++){
            letterPerc[i] = (double) letterFreq[i]/ (double) totalLetters*100;
        }

        System.out.println("Letter \t\t Frequency \t\t Percentage");

        for(int i=0;i<letterFreq.length;i++){
            int max = 0;
            int maxLoc = 0;
            for(int x=0;x<letterFreq.length;x++) {
                if (letterFreq[x] >= max){
                    max = letterFreq[x];
                    maxLoc=x;
                }
            }
            System.out.println((char) (maxLoc + 'A') + "\t\t\t" + letterFreq[maxLoc]
                    + "\t\t\t\t" + letterPerc[maxLoc] + "%");

            letterFreq[maxLoc]=-1;
        }
    }
}


//used samples from The Giver, Catcher in the Rye, Great Gatsby, random Wikipedia files