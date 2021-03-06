//Lawrence Huang
//BabyNamesTester tests the BabyNames class

import java.io.FileNotFoundException;

public class BabyNamesTester {
 public static void main(String[] args){
  BabyNames babyNames1 = new BabyNames();

  try {
   babyNames1.getInput(args);
  }
  catch (IllegalArgumentException e){
   System.out.println("IllegalArgumentException. Your command line argument must be an integer year. Valid options are: " +
     "1980, 1990, 2000, 2010");
  }

  try {
   babyNames1.writeToFile();
  }
  catch (FileNotFoundException e){
   System.out.println("The file could not be found, see result.txt");
  }
 }
}
