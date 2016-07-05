package com.test.basics;
import com.test.basics.util.RandomUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class App {
  private Scanner scanner;
  private String[][] table;
  public App (){
    scanner = new Scanner(System.in);
  }
  public static void main(String[] args){
    new App().run();
  }
  public void run(){
    setTable();
    initTable();
    printTable();
    menu();

  }
  public void menu(){
    boolean cont = true;
    do {
      System.out.println("MENU: 1) Search 2) Edit 3) Print 4) Reset 5) Exit");
      int opt = scanner.nextInt();
      scanner.nextLine();
      switch (opt) {
        case 1:
          searchTable();
          break;
        case 2:
          editTable();
          break;
        case 3:
          printTable();
          break;
        case 4:
          setTable();
          initTable();
          break;
        case 5:
          cont = false;
          break;
        default:
          System.out.println("Invalid option!");
          break;
      }
    } while (cont);
  }
  public void searchTable(){
    System.out.println("Enter keyword: ");
    String keyword = scanner.nextLine();
    List<Integer[]> indeces = new ArrayList<>();
    boolean found = false;
    for (int x = 0; x < table.length; x++){
    	for (int y = 0; y < table[x].length; y++){
        	if (table[x][y].contains(keyword)){
      			Integer[] index = new Integer[2];
      			index[0] = y;
      			index[1] = x;
      			found = true;
      			indeces.add(index);
        }
    	}
    }
    if (found){
      System.out.println("Number of occurences: " + indeces.size());
      System.out.print("Indeces: ");
      for (Integer[] index : indeces){
        System.out.print("[" + index[0] + "," + index[1] + "]\t");
      }
      System.out.println("");
    } else {
      System.out.println("No data found.");
    }
  }
  public void printTable(){
    for (int x = 0; x < table.length; x++){
      for (int y = 0; y < table[x].length; y++){
        System.out.print(table[x][y] + "\t");
      }
      System.out.println("");
    }
  }
  public void initTable(){
    for (int x = 0; x < table.length; x++){
      for (int y = 0; y < table[x].length; y++){
        table[x][y] = RandomUtil.generate(3);
      }
    }
  }
  public void setTable(){
    System.out.println("Specify table dimension.");
    System.out.println("Row: ");
    int xDim = scanner.nextInt();
    System.out.println("Column: ");
    int yDim = scanner.nextInt();
    table = new String[xDim][yDim];
  }
  public void editTable(){
      int fInd;
      int sInd;
      System.out.println("First index: ");
      fInd = getValidInd(table.length);
      scanner.nextLine();
      System.out.println("Second index: ");
      sInd = getValidInd(table[fInd].length);
      scanner.nextLine();
      System.out.println("Current value: " + table[fInd][sInd]);
      System.out.println("Enter new value: ");
      table[fInd][sInd] = scanner.nextLine();
  }
  public int getValidInd(int validInd){
    int validatedInd;
    do {
      validatedInd = scanner.nextInt();
      if (validatedInd >= validInd){
        System.out.println("Invalid index!");
      }
    } while (validatedInd >= validInd);
    return validatedInd;
  }
}
