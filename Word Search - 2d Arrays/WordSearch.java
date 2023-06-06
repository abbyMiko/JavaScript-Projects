/*
Programmer: Abbigail Farr
Date: 5/16/2023
Class: CS& 145
Assignment: Assignment 1 Word Search

Purpose: creates a word search using the users
choice of words
gives the option to display, create, and show the
solutions 

Extra credit: incorporated maps,
broke down into more methods
allowed for crossover between 
words on the word search
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class WordSearch{

   public static void main(String[] args) {
   
       Scanner input = new Scanner(System.in);
       Random rand = new Random();
       
       // variables;
       String[][] wordSearch = new String[0][0]; // holds the word search
       int matrixSize = 0; // holds the size of the matrix
       boolean again = true; // loops until user wants to exit
       int count = 0; // makes sure there is an existing matrix
       int userChoice = 0; // what the user wants to do
       
       // prints the introduction to the game
       printIntro();
       
       // loops until the user wants to exit
       while(again == true) {
          
          // asks the user what they want to do
          userChoice = userMenu();
          
          // create a new word search
          if(userChoice == 1) {
          
               String[] userWords = userWords(); // gets the words from the user
               matrixSize = matrixSize(userWords); // deterimes the size
               wordSearch = generate(userWords, matrixSize); // generates
               count++; // says that there exists a word search
               
          }
          
          // print the current word search
          else if(userChoice == 2){
               
               System.out.println();
               
               // returns if there is no word search to print
               if(count == 0) {
               
                  System.out.println("Error: please create a word search first");
               
               }
               
               // prints the word search if exists
               else {
                  
                  print(matrixSize, wordSearch);
                  
               } // end of if else
               
               System.out.println();
          }
          
          // show the solution to the word search
          else if(userChoice == 3){
          
               System.out.println();
               
               // returns if there is no word search to print
               if(count == 0) {
                  System.out.println("Error: please create a word search first");
               }
               
               // shows solution to the word search if exists
               else {
               
                  showSolution(matrixSize, wordSearch);
                  
               } // end of if else
               
               System.out.println();
          
          }
          
          // exit the program
          else if(userChoice == 4){
            
            System.out.println("Thank You for Playing!");
            System.out.println("Exiting now... ");
            again = false; // exits loop
          
          } // end of user choice if else statements
          
       }// end of while loop
           
   } // end of main method

   // print the intro the the program
   public static void printIntro(){
   
      System.out.println("Welcome to the Word Search Game!");
      System.out.println();
      System.out.println("Instructions:");
      System.out.println("Word search is game where you are displayed a matrix");
      System.out.println("of letters. But within the matrix are actual words");
      System.out.println("that you need to find! For this game you will be able");
      System.out.println("to choose a few words that will be hidden in the matrix.");
      System.out.println("Once you think you have found all the words you can");
      System.out.println("you can then check your answers!");
      System.out.println();
   
   } // end of intro method
   
   // displays uer menu and returns the choice of the user
   public static int userMenu() {
   
      Scanner input = new Scanner(System.in);
      
      // variables
      int userChoice = 0; // returns choice of user
      boolean error = true; // loops if out of range
      
      // while the chocie of the user is out of bounds repeat
      while(error == true) {
      
         // display options
         System.out.println();
         System.out.println("Please choose one of the options below: (1-4)");
         System.out.println("(1) Create a new word search");
         System.out.println("(2) Print the current word search");
         System.out.println("(3) Show the solution to the word search");
         System.out.println("(4) Exit program");
         System.out.println();
         System.out.print("Enter 1-4: ");
         userChoice = input.nextInt();
         
         // if out of bounds error and repeat
         if(userChoice < 1 || userChoice > 4) {
            System.out.println();
            System.out.println("Error: enter a number 1-4");
            System.out.println();
            error = true; // loops
         }
         
         // continues
         else {
            error = false;
         }
         
      } // end of error while loop
      
      return userChoice;
   
   } // end of userMenu method
   
   // holds the map and key to the alphabet for randomizing
   public static Map<Integer, String> alphabetMap() {
      
      // creates a connection between a number and the alphabet
      Map<Integer, String> alphabet = new TreeMap<Integer, String>();
          alphabet.put(0,"A");
          alphabet.put(1,"B");
          alphabet.put(2,"C");
          alphabet.put(3,"D");
          alphabet.put(4,"E");
          alphabet.put(5,"F");
          alphabet.put(6,"G");
          alphabet.put(7,"H");
          alphabet.put(8,"I");
          alphabet.put(9,"J");
          alphabet.put(10,"K");
          alphabet.put(11,"L");
          alphabet.put(12,"M");
          alphabet.put(13,"N");
          alphabet.put(14,"O");
          alphabet.put(15,"P");
          alphabet.put(16,"Q");
          alphabet.put(17,"R");
          alphabet.put(18,"S");
          alphabet.put(19,"T");
          alphabet.put(20,"U");
          alphabet.put(21,"V");
          alphabet.put(22,"W");
          alphabet.put(23,"X");
          alphabet.put(24,"Y");
          alphabet.put(25,"Z");
          
       return alphabet; // returns the map

   
   } // end of alphabet map method
   
   // returns an array of the words chosen by the user
   public static String[] userWords() {
      
      Scanner input = new Scanner(System.in);
      
      // variables
      String wordInput = ""; // user input
      boolean exit = false; // loops until done entering strings
      List<String> userWords = new ArrayList<String>(); // holds all words
      
      System.out.println("Enter the words you would like to add");
      System.out.println("Type 'done' when you are done");
      System.out.println();
      
      // loops until 'done' is typed
      while(exit == false) {
  
         System.out.print("Enter: ");
         
         wordInput = input.next();
         wordInput = wordInput.toUpperCase();
         
         // if done exit
         if(wordInput.equals("DONE")) {
            System.out.println();
            System.out.println("Adding words to generator");
            exit = true;
         }
         
         // add word to the array
         else{
            userWords.add(wordInput);
            exit = false;
         } // end of if else 
         
      } // end of exit while loop
      
      // creates an array from the array lsit
      String[] stringArray = new String[userWords.size()];
      stringArray = userWords.toArray(stringArray);
      
      return stringArray;
   
   } // end of user words method
   
   // returns the size of the matrix
   public static int matrixSize(String[] userWords) {
      
      // variables
      int holdWordLength = 0; // will be the matrix size
      int wordLength = 0; // holds individual words length
      int arrayLength = userWords.length; // amount of words in the array
      
      // checking for the longest word in the array to determine the size of the matrix
     for(int size = 0; size < arrayLength; size++) {
         
         wordLength = userWords[size].length();
         
         // if this word length is longer than the last re-assign
         if(wordLength > holdWordLength) {
             
             holdWordLength = wordLength;
             
         }
      
      } // end of size forloop
      
      // returns the longest word length * 2 for matrix size
      return holdWordLength * 2; 
      
   } // end of matrixSize method
   
   // gets the words and generates a word search for these words
   public static String[][] generate(String[] userWords, int matrixSize) {
      
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      
      // variables
      Map<Integer, String> alphabet = alphabetMap();  // alphabet map
      String[] userWordsExtra = userWords;            // extra for checking
      int arrayLength = userWords.length;             // size of the array
      int index = 0;                                  // index of the letter
      int indexExtra = index;                         // extra for checking
      char letterChar = ' ';                          // one char in a word
      char letterCharExtra = letterChar;              // extra for checking
      String letterStr = "";                          // char into a String
      String letterStrExtra = letterStr;              // extra for checking 
      String inputWord = "";                          // holds one word from the array
      String inputWordExtra = inputWord;              // extra for checking
      int wordsLength = 0;                            // length of a word
      int wordDirection = 0;                          // determines direction word will pring
      int startRow = 0;                               // initial start row
      int startCol = 0;                               // initial start column
      boolean randAgain = true;                       // keeps randomizing until it can print
      int row;                                        // row
      int col;                                        // col
      int rowCheck;                                   // for checking
      int colCheck;                                   // for checking
      
      // creates the matrix (empty)
      String[][] wordSearch = new String[matrixSize][matrixSize];
      String[][] wordSearchExtra = wordSearch;

   
      // this will add words to the array
      for(int words = 0; words < arrayLength; words++) {
         
         boolean reRandom = true; // redeclares each time
         
         // loops until position is possible
         while(reRandom == true) {
               
               // variables
               inputWord = userWords[words];             // word from array
               inputWordExtra = inputWord;               // extra
               wordsLength = inputWord.length();         // length of word
               wordDirection = rand.nextInt(3);          // randomize the direction
               startRow = rand.nextInt(matrixSize - 1);  // start is rand
               startCol = rand.nextInt(matrixSize - 1);  // start is rand
               row = startRow;                           // row
               col = startCol;                           // col
               String isEmpty = "";                      // checks each box in the random direction

               
               // add a word diagonally
               if(wordDirection == 0) {
                  
                  // goes through each letter in the word and places it
                  for(int lettersMain = 0; lettersMain < wordsLength; lettersMain++) {
                     
                     // variables for checking the random direction is possible 
                     rowCheck = row;
                     colCheck = col;
                     inputWordExtra = inputWord;
                     
                     // moves down each letter of a word
                     index = inputWord.indexOf(inputWord.substring(lettersMain, lettersMain + 1));
                     
                     // takes the char and makes it a string
                     letterChar = inputWord.charAt(index);
                     letterStr = String.valueOf(letterChar);
  
                     
                     // below the middle and to the right
                     if(startRow >= matrixSize/2 && startCol >= matrixSize/2) {
                            
                            // if this is the first time through check this direction
                            if(reRandom == true) {  
                              
                              // loops through each letter and space
                              // checks that this direction is possible
                              for(int letters2 = 0; letters2 < wordsLength; letters2++) {
                                    
                                    // extra is for checking without re-declaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters2, letters2 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space in the array
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    // moves in the direction
                                    rowCheck--;
                                    colCheck--;
                                   
                                    // if the space is not empty and doesn't equal the needed letter
                                    
                                    
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters2 = wordsLength; // exits for loop
                                          
                                    }
                                                                         
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declare the word search
                                 wordSearch[row][col] = letterStr;
                                 
                                 // moves up and to the left
                                 row--;
                                 col--;
                              } // end of if reRandom
    
                     }
                     
                     // below the middle and to the left
                     else if(startRow >= matrixSize/2 && startCol <= matrixSize/2) {
                              
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // loops each letter to check direction
                              for(int letters3 = 0; letters3 < wordsLength; letters3++) {
                                    
                                    // extra to check without redeclaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters3, letters3 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks if the spaces in this direction work
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    // moves in the direction
                                    rowCheck--;
                                    colCheck++;
                                    
                                    // if the space is not empty and doesn't equal the needed letter
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters3 = wordsLength; // exits for loop
                                          
                                    }
                                                                         
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declare in the word search
                                 wordSearch[row][col] = letterStr; 
                                 
                                 // moves up and the right
                                 row--;
                                 col++;
                                 
                              } // end of if else re-random 
                              
                     }
                     
                     // above the middle and to the right
                     else if(startRow <= matrixSize/2 && startCol >= matrixSize/2) {
                              
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // loops each letter checking the direction works
                              for(int letters4 = 0; letters4 < wordsLength; letters4++) {
                                    
                                    // extra is for checking without redeclaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters4, letters4 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each box in the direction
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    // moves
                                    rowCheck++;
                                    colCheck--;
                                    
                                    // if the space is not empty and doesn't equal the needed letter
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters4 = wordsLength; // exits for loop
                                          
                                    }

                                     
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declare spaces in the word search
                                 wordSearch[row][col] = letterStr;
                                 
                                 // moves down and to the left
                                 row++;
                                 col--;
                                 
                              } // end of rerandom if else statements
             
   
                     }
                     
                     // above the middle and to the left
                     else if(startRow <= matrixSize/2 && startCol <= matrixSize/2) {
                              
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // loops for each letter to check if direction works
                              for(int letters5 = 0; letters5 < wordsLength; letters5++) {
                                    
                                    // extra is to check without redeclaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters5, letters5 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space in the direction
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    //moves
                                    rowCheck++;
                                    colCheck++;
                                    
                                    // if the space is not empty and doesn't equal the needed letter
                                    
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters5 = wordsLength; // exits for loop
                                          
                                    }

                                     
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declares spaces in this area
                                 wordSearch[row][col] = letterStr;
                                 
                                 // moves down and to the right
                                 row++;
                                 col++;
                                 
                              } // end of rerandom if else statements

   
                     } // end of if else
                     
                  } // end of for loop
                  
               } // end of if direction is 0
               
               // add a word horizontally
               else if(wordDirection == 1) {
                  
                  // loops for each letter in the word
                  for(int letters2 = 0; letters2 < wordsLength; letters2++) {
                     
                     // for checking the rows and col
                     rowCheck = row;
                     colCheck = col;
                     inputWordExtra = inputWord;
                     
                     // index of each char in the word
                     index = inputWord.indexOf(inputWord.substring(letters2, letters2 + 1));
                     
                     // turns a char to a string
                     letterChar = inputWord.charAt(index);
                     letterStr = String.valueOf(letterChar);
 
                     
                     // to the right
                     if(startCol >= matrixSize/2) {
                           
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // loops for each character to check if direction works
                              for(int letters6 = 0; letters6 < wordsLength; letters6++) {
                                    
                                    // extra is to check without re-declaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters6, letters6 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space in this direction
                                    isEmpty = wordSearch[rowCheck][colCheck];

                                    // moves
                                    colCheck--;
                                    
                                    
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters6 = wordsLength; // exits for loop
                                          
                                    }

                                                                         
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declares spaces in the word search
                                 wordSearch[row][col] = letterStr;
            
                                 
                                 // moves to the left
                                 col--;
                                 
                              } // end of reRandom if else statements

                     
                     }
                     
                     // to the left
                     else if(startCol <= matrixSize/2) {
                           
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // checks each letter to see if the direction works
                              for(int letters7 = 0; letters7 < wordsLength; letters7++) {
                                    
                                    // extra is to check without redeclaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters7, letters7 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space 
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    // moves
                                    colCheck++;
                                    
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters7 = wordsLength; // exits for loop
                                          
                                    }
                                     
                                 }  // end of for loop
                                 
                              } // if of if re random is true
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declares spaces in the word search
                                 wordSearch[row][col] = letterStr;
                       
                                 // moves to the right
                                 col++;
                                 
                              } // end of reRandom if else statements
                        
                     } // end of if else
                    
                  } // end of for loop
                  
               } // end of if direction is 1
               
               // add a word vertically if 2
               else {
                  
                  // goes through each letter of the word
                  for(int letters3 = 0; letters3 < wordsLength; letters3++) {
                     
                     // for checking
                     rowCheck = row;
                     colCheck = col;
                     inputWordExtra = inputWord;
                     
                     // index of a letter in a word
                     index = inputWord.indexOf(inputWord.substring(letters3, letters3 + 1));
                     
                     // turns the char into a string
                     letterChar = inputWord.charAt(index);
                     letterStr = String.valueOf(letterChar);
                     
                     // below the middle
                     if(startRow >= matrixSize/2) {
                           
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // checks each letter to see if the direction works
                              for(int letters8 = 0; letters8 < wordsLength; letters8++) {
                                    
                                    // extra to check without declaring
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters8, letters8 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space in this direction
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                   
                                    // moves
                                    rowCheck--;
                                    
                                    // is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters8 = wordsLength; // exits for loop
                                          
                                    }
                                     
                                 }  // end of for loop
                                 
                              } 
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declares spaces in the word search
                                 wordSearch[row][col] = letterStr;  
                                 
                                 // moves up
                                 row--;
                                 
                              } // end of reRandom if else

                           
                     
                     }
                     
                     // above the middle
                     else if(startRow <= matrixSize/2) {
                           
                           // if this is the first time through check this direction
                           if(reRandom == true) { 
                              
                              // checks each letter to see if direction is right
                              for(int letters9 = 0; letters9 < wordsLength; letters9++) {
                                    
                                    // extra to check without redeclaring 
                                    indexExtra = inputWordExtra.indexOf(inputWordExtra.substring(letters9, letters9 + 1));
                                    letterCharExtra = inputWordExtra.charAt(indexExtra);
                                    letterStrExtra = String.valueOf(letterCharExtra);
                                    
                                    // checks each space in the direction
                                    isEmpty = wordSearch[rowCheck][colCheck];
                                    
                                    // moves
                                    rowCheck++;
                                    
                                    /// is empty or equals the letter so continue
                                    if(isEmpty == null || isEmpty.equals(letterStrExtra)) {
                                    
                                       reRandom = false;
                                       
                                    } // end of if else is empty loop
                                    
                                    // exit for loop and re-randomize
                                    else {
                                       
                                       reRandom = true; // loops
                                       letters9 = wordsLength; // exits for loop
                                          
                                    }
                                                                         
                                 }  // end of for loop
                                 
                              } 
                                 
                              // if everything is ok
                              if(reRandom == false) { 
                                 
                                 // declare in the word search
                                 wordSearch[row][col] = letterStr;
                                 
                                 // move down
                                 row++;
                                 
                              } // end of reRandom if else

                     } // end of if else
    
                  } // end of letters for loop
                  
                } // end of direction if else 
            
         } // rerandom while loop end
         
      } // end of words for loop
   
       return wordSearch;

   } // end of generate method
   
   // prints the words search that was generated
   public static void print(int matrixSize, String[][] wordSearchComplete) {
      
      Random rand = new Random();
      
      // variables
      Map<Integer, String> alphabet = alphabetMap(); // alphabet
      int randomKey = 0; // for randomizing
      String randomLetter = ""; // for randomizing
      
      
      // printing the matrix going down each column
      for(int i = 0; i < matrixSize; i++) {
         
         // second loop going down the row
         for(int a = 0; a < matrixSize; a++) {
            
            // if there is nothing assigned
            if(wordSearchComplete[i][a] == null) {
               
               // randomize a key and pull the letter associated with it
               randomKey = rand.nextInt(26);
               randomLetter = alphabet.get(randomKey);
               
               // print the random letter in place of the null
               System.out.print(randomLetter + " ");
               //wordSearchComplete[i][a] = randomLetter;
 
            }
            
            // if there is already a letter print it
            else {
            
               System.out.print(wordSearchComplete[i][a] + " ");
               
            } // end of if else

         } // end of inner for loop
         
         System.out.println();
         
       } // end of outer for loop
       
   
   } // end of print metho
   
   // show the solution the generated word search
   public static void showSolution(int matrixSize, String[][] wordSearchKey) {
      
      Random rand = new Random();
      
      // variables
      int randomKey = 0; // for a random key
      String randomLetter = ""; // for randomizing
      
      // outer loop for each column
      for(int i = 0; i < matrixSize; i++) {
         
         // inner loop for each row
         for(int a = 0; a < matrixSize; a++) {
            
            // if there is letter
            if(wordSearchKey[i][a] == null) {
               
               // print this in place of the null
               System.out.print("# ");
               //wordSearchKey[i][a] = "#";
 
            }
            
            // if there is a letter print it
            else {
            
               System.out.print(wordSearchKey[i][a] + " ");
               
            } // end of if else

         } // end of inner for loop
         
         System.out.println();
         
       } // end of outer for loop

   
   } // end of show solution method
        
} // end of word search