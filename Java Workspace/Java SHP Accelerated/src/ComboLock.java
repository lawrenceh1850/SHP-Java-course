//Lawrence Huang
//ComboLock simulates the action of a 3-digit combination lock

public class ComboLock {
 private int combo[]; //0,1,2
 private int current; //0-24
 private int spinNum; //0,1,2
 final static private int MAX = 24;
 final static private int NUM_TURNS = 3;

 //Constructors
 public ComboLock(){
  combo = new int[3];
  current = 0;
  spinNum = 0;
 }

 public ComboLock(int[] comboIn){  
  if (comboIn.length != NUM_TURNS)
   throw new IllegalArgumentException("The combination must have " + NUM_TURNS + " numbers");

  combo = new int[3];

  for(int i=0;i<comboIn.length;i++)
   combo[i]=comboIn[i];

  spinNum = 0;
 }

 //Methods
 public void reset(){
  spinNum=0;
  System.out.println("The lock has been reset\n");
 }

 public void printCurrent(){
  System.out.println("Your current position is " + current + "\n");
 }

 public void turnRight(int ticks){
  if(spinNum%2 != 0){ //only turns right on spins 0 or 2
   System.out.println("You have turned the lock the wrong way\n");
   this.reset();
   return;
  }

  current-=ticks; //turn lock right
  //System.out.println("current is " + current);
  current%=(MAX+1); //accounts for turning more than once
  //System.out.println("current is " + current);
  if(current<0)
   current=MAX+1+current;

  System.out.println("The lock has been turned right to " + current + "\n");

  if(current != combo[spinNum]){//if number is wrong
   System.out.println("Incorrect code entered");
   this.reset();
   return;
  }

  if(spinNum==2){  //on the third turn
   System.out.println("The lock has been unlocked");
   return;
  }
  spinNum++; //in preparation for next turn
 }

 public void turnLeft(int ticks){
  if(spinNum%2 != 1){ //only turns left on spin 1
   System.out.println("You have turned the lock the wrong way");
   this.reset();
   return;
  }
  
  current+=ticks; //turn lock left
  current%=(MAX+1); //accounts for turning more than once

  if(current<0)
   current=MAX+1+current;

  System.out.println("The lock has been turned left to " + current + "\n");
  
  
  if(current != combo[spinNum]){//if number is wrong
   System.out.println("Incorrect code entered");
   this.reset();
   return;
  }

  spinNum++; //in preparation for next turn
 }
 
 //Testing methods
 public void getLockInfo(){
  System.out.println("spinNum: " + spinNum);
 }
}
