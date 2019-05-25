//Lawrence Huang
//BabyNames reads baby names/number of babies with that name from a certain year

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BabyNames {
 private int year;
 private int rank;
 private String gender;
 private Scanner sc;
 //
 //Constructors
 public BabyNames(){
  year = 0;
  rank = 0;
  gender = null;
 }

 //Private Methods
 private void navigate() throws FileNotFoundException{
  String sep = File.separator;

  String filePath = System.getProperty("user.dir") + sep +
    "Names" + sep + Integer.toString(year) + ".txt";

  File inputFile = new File(filePath);

  sc = new Scanner(inputFile);

  sc.nextLine(); // Clear Males/Females
  sc.nextLine(); // Clear Rank Name Number ...

  for(int i = 1;i<rank;i++) //navigate to proper rank
   sc.nextLine();//clears lines

  if(sc.nextInt() != rank) { //clears rank
   System.out.println("Rank in file does not match");
  }
 }

 private String getName(){
  try {
   navigate();
  }
  catch (FileNotFoundException e) {
    System.out.println("File " + year + ".txt could not be found");
   return null;
  }

  sc.useDelimiter("\\t");

  if(gender.equals("BOY")) {
   String boyName=sc.next();
   sc.close();
   boyName = boyName.replace("\t","");
   boyName = boyName.replace("\n","");
   return boyName;
  }
  else if(gender.equals("GIRL")) {
   sc.next(); //clears boy name
   sc.next(); //clears boy number
   String girlName = sc.next();
   sc.close();
   girlName = girlName.replace("\t","");
   girlName = girlName.replace("\n","");
   return girlName;
  }
  else {
   sc.close();
   return null;
  }
 }

 private String getNum(){
  try {
   navigate();
  }
  catch (FileNotFoundException e) {
    System.out.println("File " + year + ".txt could not be found");
   return null;
  }

  sc.useDelimiter("\t");

  if(gender.equals("BOY")) {
   sc.next(); //clears boy name
   String boyNum=sc.next();
   sc.close();
   boyNum = boyNum.replace("\t","");
   boyNum = boyNum.replace("\n","");
   return boyNum;
  }
  else if(gender.equals("GIRL")) {
   sc.next(); //clears boy name
   sc.next(); //clears boy number
   sc.next(); //clears girl name
   String girlNum = sc.nextLine();
   girlNum = girlNum.replace("\t","");
   girlNum = girlNum.replace("\n","");
   sc.close();
   return girlNum;
  }
  else {
   sc.close();
   return null;
  }
 }

 //Public Methods
 public void getInput(String args[]){

  Scanner sc = new Scanner(System.in);

  if(args.length!=1){
   System.out.println("Args Length error. Your command line argument must be an integer year. Valid options are: " +
     "1980, 1990, 2000, 2010");
   return;
  }

  System.out.println("The year you have selected is " + args[0]);

  year =Integer.valueOf(args[0]);

  if(!(year>=1980 && year<=2010 && year%10==0)){
   System.out.println("String parse error. That is not a valid year. Valid options"
     + " are: 1980, 1990, 2000, 2010");
   sc.close();
   return;
  }

  boolean validEntry = false;

  do{
   try{
    System.out.print("Enter rank of baby name: ");
    rank = sc.nextInt();
    sc.nextLine();//clears line for boy/girl
    if(rank>=1 && rank<=200)
     validEntry = true;
    else
     System.out.println("That is not a valid rank. Valid ranks"
       + " are 1-200");
   }
   catch (InputMismatchException e){
    System.out.println("That is not a valid rank. Valid ranks"
      + " are 1-200");
    sc.next();
   }
  }while(!validEntry);

  validEntry = false;

  do{
   try{
    System.out.print("Do you want the boy or girl name " +
      "(Enter \"boy\" or \"girl\", not case-sensitive): ");
    gender = sc.nextLine();
    gender = gender.toUpperCase();//gender is now UPPERCASE
    if(gender.equals("BOY") || gender.equals("GIRL"))
     validEntry = true;
    else
     System.out.println("Please select boy or girl");
   }
   catch (InputMismatchException e){
    System.out.println("Please select boy or girl");
    sc.next();
   }
  }while(!validEntry);
 }

 public void writeToFile() throws FileNotFoundException{
  Scanner sc = new Scanner(System.in);
  String answer = null;

  String sep = File.separator;

  System.out.println("Your user directory is " + System.getProperty("user.dir"));

  System.out.println("Is this the directory with the folder \"Names\" in it?");
  System.out.println("Enter \"Y\" or \"N\" (not case-sensitive): ");
  answer = sc.nextLine();
  answer = answer.toUpperCase(); // answer now uppercase

  if(answer.equals("N")) {
   System.out.println("Please move the folder \"Names\" to the directory " + System.getProperty("user.dir"));
   return;
  }

  String filePath = System.getProperty("user.dir") + sep + "result.txt";

  PrintWriter outfile = new PrintWriter(filePath);
  String name = getName();
  String num = getNum();

  if(name == null || num == null) {
   outfile.println("There was an error in reading the name or number");
   outfile.close();
   return;
  }
  else {
   outfile.println("Rank " + rank + " for " + gender.toLowerCase() + " name in " + year + "s was " + name + "(" + num + ")");
   outfile.close();
  }
 }
}
