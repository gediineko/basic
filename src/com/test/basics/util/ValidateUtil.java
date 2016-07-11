package com.test.basic.util;
public class ValidateUtil{
  
}
/*

int validate(int valid) {
    return validate(valid, "Invalid Index");
}
Int validate(int valid, String errorMessage"){
    If not valid print errorMessage
}
Pra dun sa generc message tska ung may custo message
Pwede rn gnto
Int validate(int max){ return validate(0, max); }

Int validate(int min, int max) {
    Checks if in between min max inclusive)
}
_________

public int getValidInd(int maxValidInd){
    boolean valid; // store if valid
    do {
      try{
        //sets valid to true
        valid = true;
        // get string input
        String strInput = scanner.nextLine();
        // parse it to int, if it fails,
        // it will throw a NumberFormatException
        // it means it cant be parsed
        int index = Integer.parseInt(strInput);
        // checks if within range
        if (index >= 0 && index >= maxValidInd){
          // if yes throws an illegal argument exception
          // usually denotes that the argument / input
          // is invalid
          throw new IllegalArgumentException();
        }
        // if it didnt throw any exception,
        // it will return the validated index
        return index;
 
        // Catches NumberFormatException and IllegalArgumetnException
        // NumberFormatException is a subclass of IllegalArgumentException
        // kaya ma cacatch din dito ung NumberFormatException
      } catch (IllegalArgumentException ex){
        // Prints invalid index
        System.out.println("Invalid index!");
        // sets valid to false to make the llop run again
        valid = false;
      }
      // do while condition if it is valid
    } while (!valid);
    // mandatory return statement
    // you can put the actual return statement heere
    // trip ko lang ilagay sa loob
    // iniisip ni compiler, posibleng hindi pumasok
    // sa scope nung dowhile/try catch yung runtime
    // kya iniisip nya missing return statement
    return -1;
  }
*/