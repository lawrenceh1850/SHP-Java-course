//Lawrence Huang
//LockTester uses hardcoded combinations to test the ComboLock class

public class LockTester {
 public static void main(String[] args){
  //Make a lock with code (0,0,0) and show a situation where the user opens it correctly
  System.out.println("Situation 1: Make a lock with code (0,0,0) and show a situation where the user opens it correctly");
  
  int[] myCombo1 = {0,0,0};
  
  ComboLock myLock1 = new ComboLock(myCombo1);
  
  myLock1.printCurrent();
  myLock1.turnRight(0);
  myLock1.turnLeft(0);
  myLock1.turnRight(0);
  
  
  //Make a lock with any code (hard-code it) and show a situation where the user fails to open
  System.out.println("\nSituation 2: Make a lock with any code (hard-code it) and show a situation where the user fails to open");

  int[] myCombo2 = {14,19,15};
  
  ComboLock myLock2 = new ComboLock(myCombo2);
  
  myLock2.printCurrent();
  myLock2.turnRight(11);
  myLock2.turnLeft(5); //wrong number entered here
  myLock2.turnRight(6); //wrong code entered here b/c supposed to turn right after reset in previous line
  
  //Make a lock with any code (hard-code it) and show a situation where the user messes up in the middle, resets, and succeeds
  System.out.println("Situation 3: Make a lock with any code (hard-code it) and show a situation where the user messes up in the middle, resets, and succeeds");
  ComboLock myLock3 = new ComboLock(myCombo2);
  
  myLock3.printCurrent();
  myLock3.turnRight(11);
  myLock3.turnLeft(50); //wrong code entered here b/c supposed to turn left by 8
  
  myLock3.printCurrent();
  
  myLock3.turnRight(0);
  myLock3.turnLeft(5);
  myLock3.turnRight(4);
 }
}

/*Output
Situation 1: Make a lock with code (0,0,0) and show a situation where the user opens it correctly
Your current position is 0

The lock has been turned right to 0

The lock has been turned left to 0

The lock has been turned right to 0

The lock has been unlocked

Situation 2: Make a lock with any code (hard-code it) and show a situation where the user fails to open
Your current position is 0

The lock has been turned right to 14

The lock has been turned left to 19

The lock has been turned right to 13

Incorrect code entered
The lock has been reset

Situation 3: Make a lock with any code (hard-code it) and show a situation where the user messes up in the middle, resets, and succeeds
Your current position is 0

The lock has been turned right to 14

The lock has been turned left to 14

Incorrect code entered
The lock has been reset

Your current position is 14

The lock has been turned right to 14

The lock has been turned left to 19

The lock has been turned right to 15

The lock has been unlocked
*/