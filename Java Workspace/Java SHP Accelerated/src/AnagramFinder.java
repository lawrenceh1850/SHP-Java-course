//Lawrence Huang

import java.util.ArrayList;
import java.util.Scanner;

public class AnagramFinder { 
  private static String swapStringChars(String originalString, int first, int second){
    char[] c = originalString.toCharArray();
    
    char temp = c[first];
    c[first] = c[second];
    c[second] = temp;
    
    return new String(c);
  }
  
  private static void anagramRec(String str, int first, int second, ArrayList<String> _anagramList){ //Anagram recursive     
    if(first >= (str.length())){ //first exchange element has reached end of string, base case
      return;
    }
    
    boolean uniqueAna = true;
    
    for(String ana:_anagramList){//check if term is unique
      if(str.equals(ana))
        uniqueAna = false;
    }
    
    if(uniqueAna)//adds unique term to arraylist
      _anagramList.add(str);  
    
    while(second < (str.length())){//second exchange element is not yet at the end of the string
      anagramRec(swapStringChars(str,first,second),first+1,first+2,_anagramList);//exchanges first element with remaining elements of string
      second++;
    }
    
    if(first<(str.length()-1))
      anagramRec(swapStringChars(str,++first,--second),first,first+1,_anagramList); //starts smaller element within the string
    
    return;
  }
  
  public static void doAnagram(String str){ //inital public method
    ArrayList<String> anagramList = new ArrayList<String>();//utilized arraylist for expandable capacity
    
    anagramList.add(str);//adds initial term to Arraylist
    
    anagramRec(str, 0, 1, anagramList);//runs private method
    
    if(anagramList.size()<1000){//less than a certain number of terms, print all values
    for(String ana:anagramList){
     System.out.println(ana);
     }
    }
    
    System.out.println("there are " + anagramList.size() + " unique anagrams");//print number of anagrams
  }
  
  public static void main(String[] args){
    String str=null;
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the string: ");
    str = sc.nextLine();
    
    while(!str.equals("endAnagram")){//end of input w sentinel value
      doAnagram(str);
      
      str = null;
      
      System.out.print("Enter the string: ");
      str = sc.nextLine();     
    }
    sc.close();
  }
}
