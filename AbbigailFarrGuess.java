/*Programmer: Abbigail Farr
DateL: 4/4/2023
Class: CS& 145
Assignment: Lab1 Guessing Game
Purpose: create guessing game of an arbitrary number, set to 1-100 
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;

public class AbbigailFarrGuess {
   public static void main(String[] args) {
      
      // define variables
      int guessingRange;                              // you change the guessing range but right now it is set at 100
      String playAgain = "n";                         // whether or not you want to play again input
      boolean rounds = true;
      boolean againInput = false;
      int realRound = 1;                              // counts up the games played
      int totalTries = 0;                             // will add up all rounds of tries
      int lowestRound = 10000;                        // determines the round with the least amount of tries
      int tries = 0;                                  // will determine total amount of tries
      int bestRound = 0;                              // round with lowest amount of tries
      int thisRound = 0;                              // tells which round you are in right now
      String playAgain1 = "n";                        // whether or not you want to play Again substring
      
      // introduction
      Scanner input = new Scanner(System.in);
      instructions(); // give user instructions
      totalTries = playGame(100); // play game, determine total tries to start
      tries = totalTries; // because this the first round, tries will equal the total amount of tries from this round 
      thisRound += 1; // now round 1
      
      if (totalTries < lowestRound) { // decides if the totalTries for this round is the least amount
         lowestRound = totalTries;    // changes lowestRound to this round of total tries
         bestRound = thisRound;       // also makes this the best round
      } 
      
      
      while (rounds == true) { // repeats game as many timnes as user wants

         while (againInput == false) { // checking input for repeat is y or n
            System.out.print("Would you like to play again? ");
            playAgain = input.next();
            playAgain1 = playAgain.substring(0,1); // pulls out the first letter of the input
            playAgain1 = playAgain1.toLowerCase(); // makes substring lowercase =
            System.out.println();
            
            if (playAgain1.equals("y") || playAgain1.equals("n")) { // ensures the first letter is either 'y' or 'n'
               againInput = true;
            }
            else {
               System.out.printf("Error: Inaccurate input. Please enter 'y' or 'n'%n%n"); // loops to re-enter choice
               againInput = false;
            }
         } // end of againInput while loop
         
         if (playAgain1.equals("y")) {
            tries = playGame(100);           // this will repeat the game and start to count tries for ONLY this round
            thisRound += 1;                  // new round add to last amount since you want the total
            totalTries = totalTries + tries; // adds up tries from last game and this game
            
               if (tries < lowestRound) {    // deciding if this round had the least amount of tries compared to the last lowestRound
                   lowestRound = tries;      // makes the lowest round the amount of tries taken here
                   bestRound = thisRound;    // makes the bestRound the current round
               } 
            
            realRound++;                     // this is counting the TOTAl amount of rounds (adds because you repeated)
            againInput = false;              // will loop
         }
         else if (playAgain1.equals("n")) {  // not playing again
            rounds = false;                  // exit

         }

      } // end of playing the Game

      report(realRound, totalTries, lowestRound, bestRound);
   
   } // end of main method
   
   // displays instructions for game, asks for user level choice 
   public static void instructions() {

      // display instructions, prompts user for level choice
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.printf("than your guess.%n%n");

   } // end of instructions method
      
   
   // plays game based on user level choice
   public static int playGame(int guessingRange) {
      Scanner input = new Scanner(System.in);
      
      // define variables
      boolean chances = false;
      int guess = 0;
      
      // generate random number
      Random rand = new Random();
      int randNumber = rand.nextInt(guessingRange) + 1;
      int tries = 1; 

      
      // get player to guess number within range
      System.out.println("I am thinking of a number between 1 and 100...");
      
      while (chances == false) { // repeats until answer is correct, used to display output depending on if you ran out of tries
         
            while (tries < 9999 && guess != randNumber){ // limits to 9999 tries, and repeats within the game when guessed wrong
               System.out.printf("Your guess? ");
               guess = input.nextInt();

               if (guess == randNumber){ // if correct
                  guess = randNumber;            
               }
               else if (guess > 100 || guess < 1){ // if out of range
                  System.out.println("The number you selected is out of the range!");
               }
               else if (guess > randNumber) { // for lower guess within range
                  System.out.println("it's lower.");
                  tries++; // adds a try
               }
               else if (guess < randNumber) { // for higher guess within range
                  System.out.println("it's higher.");
                  tries++;
               }
               
            } // end of nested while loop
            if (tries < 9999){
               System.out.printf("You got it right in %d guesses%n", tries);     
            }
            else if (tries == 3){
               System.out.printf("%nOh No! You ran out of tries :(");
               System.out.printf("%nThe answer was: %d%n%n", randNumber);
               
            }
            
            chances = true; // exit the game round

         }

      return tries; // this will show amount of tries per game
   
   } // end of playGame method
   
   // creates report of overall data from the game and displays it to the user
   public static void report(int realRound, int totalTries, int tries, int bestRound){
      
      // define variables
      int totalGames = realRound;
      int totalGuesses = totalTries;
      double averageGuesses = totalTries/realRound;
      int lowestTries = tries;
      
      // display final results
      System.out.printf("Overall Results: %n");
      System.out.printf("  total games   = %d%n", totalGames);
      System.out.printf("  total guesses = %d%n", totalGuesses);
      System.out.printf("  guesses/game  = %.01f%n", averageGuesses);
      System.out.printf("  best game     = %d%n", lowestTries);

   
   }  // end of report method
} // end of GuessingGameLab1