package com.test.basics;
import com.test.basics.util.RandomUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class App {
  private Scanner scanner;
  private String[][] table;
  private int xDim;
  private int yDim;
  public App (){
    scanner = new Scanner(System.in);
  }
  public static void main(String[] args){
    new App().run();
  }
  public void run(){
    setTable();
    printTable();
    menu();

  }
  public void menu(){
    boolean cont;
    do {
      int opt = 0;
      cont = true;
      try {
        System.out.println("MENU: [1 Search] [2 Edit] [3 Print] [4 Reset] [5 Exit]");
        opt = scanner.nextInt();
      } catch (InputMismatchException ex){
        cont = true;
      }
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
          break;
        case 5:
          cont = false;
          break;
        default:
          System.out.println("[Invalid option]");
          break;
      }
    } while (cont);
  }
  public void searchTable(){
    String keyword;
    System.out.println("[Enter keyword]");
    keyword = scanner.nextLine();
    if (keyword.equals("")){
      System.out.println("No data found.");
    } else {
      List<Integer[]> indeces = new ArrayList<>();
      boolean found = false;
      for (int x = 0; x < table.length; x++){
      	for (int y = 0; y < table[x].length; y++){
          	if (table[x][y].contains(keyword)){
        			Integer[] index = new Integer[2];
        			index[0] = x;
        			index[1] = y;
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
    boolean validRow;
    boolean validColumn;
    System.out.println("[Specify table dimension]");
    do {
      try {
        validRow = true;
        System.out.println("Row: ");
        xDim = scanner.nextInt();
        if (xDim < 1){
          validRow = false;
          System.out.println("[Row value should be atleast 1]");
        }
      } catch (InputMismatchException ex){
        System.out.println("[Invalid row value]");
        validRow = false;
        scanner.nextLine();
      }
    } while (!validRow);
    do {
      try {
        validColumn = true;
        System.out.println("Column: ");
        yDim = scanner.nextInt();
        if (yDim < 1){
          validColumn = false;
          System.out.println("[Column value should be atleast 1]");
        }
      } catch (InputMismatchException ex){
        System.out.println("[Invalid column value]");
        validColumn = false;
        scanner.nextLine();
      }
    } while (!validColumn);
    table = new String[xDim][yDim];
    initTable();
  }
  public void editTable(){
      int row = 0;
      int column = 0;
      boolean validRow;
      boolean validColumn;
      System.out.println("[Specify the index you want to Edit]");
      do {
        try {
          validRow = true;
          System.out.println("Row: ");
          row = scanner.nextInt();
          scanner.nextLine();
          if (row >= table.length){
            validRow = false;
            System.out.println("[Invalid index]");
          }
        } catch (InputMismatchException ex){
          validRow = false;
          System.out.println("[Invalid index]");
          scanner.nextLine();
        }
      } while (!validRow);
      do {
        try {
          validColumn = true;
          System.out.println("Column: ");
          column = scanner.nextInt();
          scanner.nextLine();
          if (column >= table[xDim-1].length){
            validColumn = false;
            System.out.println("[Invalid index]");
          }
        } catch (InputMismatchException ex){
          validColumn = false;
          System.out.println("[Invalid index]");
          scanner.nextLine();
        }
      } while (!validColumn);
      System.out.println("Current value: " + table[row][column]);
      System.out.println("Enter new value: ");
      table[row][column] = scanner.nextLine();
  }
}
