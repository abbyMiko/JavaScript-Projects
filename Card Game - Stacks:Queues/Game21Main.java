/*Programmer: Abbigail Farr
DateL: 4/17/2023
Class: CS& 145
Assignment: Lab 4 CardGame
Purpose: main method for 21 card game, plays game for user against computer
Extra credit: Switch/case
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.util.Random;

public class Game21Main extends initializeGame {
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      Random rand = new Random();
      boolean playAgain = true; // variable for main full game while loop
      
      String userName = ""; // initializes user Name
      
      System.out.print("Welcome to 21 Card Game! Please enter a user name of your choice... ");
      userName = input.next();
      System.out.println("Welcome " + userName);
      System.out.println();
      
      // loops for entire game until user chooses to exi
      while(playAgain == true) {
         //variables
         boolean again = true;                        // asking if you woul like to play the game again
         boolean inputSH = false;                     // is the user input for hit os sit correct
         boolean ready1 = false;                      // ready to put cards down for player
         boolean ready2 = false;                      // ready to put cards down for computer
         boolean exit = false;                        // to exit loop for a game
         String againString = "";                     // for whether or not you want to play again
         int userAce = 0;                             // user choice of ace value
         int comAce = 0;                              // computer ace value (random)
         boolean ace = false;                         // is the ace value correct
         int totalAmountUser = 0;                     // how much each player has in their hand
         int totalAmountCom = 0;                      // how much each computer player has in the hand
         boolean busted = false;                      // records if person out of bounds
         boolean bustedC = false;                     // records if computer out of bounds
         String toStringU = "";                       // to print the hand for the user to see
         String toStringCom = "";                     // to print the hand for the computer
         String draw = "";                            // holds input that checks if user wants to draw another card (hit)
         Stack<String> empty = new Stack<String>();   // used to reserve cards, should always be empty.
         String[] computerHand = new String[52];      // will hold each card from the computers stack 
         
         
         instructions(); // displays instructions
         
         // ensures that the number entered for the ace is 1 or 11
         while(ace == false) {
            System.out.print("Would you like Ace to be worth (1) or (11)?: " );
            userAce = input.nextInt();
            System.out.println();
            
            // if accurate exit
            if(userAce == 1 || userAce == 11) {
               ace = true;
            }
            
            // if inaccurate loop
            else {
               System.out.println("Error: please type (1) or (11)... ");
               ace = false;
            }
         } // end of ace while loop 
         
         // produces random nmber 0-1
         comAce = rand.nextInt(2);
         
         if(comAce == 0) { // 0 means value 1
            comAce = 1;
         }
         else { // 1 means value 2
            comAce = 11;
         }
         
         initializeGame newGame = new initializeGame();                       // creates a new game 
         newGame.firstDeal();                                                 // deals 2 cards to each player for the new game
         Stack<String> playerStack = newGame.playerStack();                   // creates a stack for the player
         Stack<String> computerStack = newGame.computerStack();               // creates stack maintained by a computer
         
         totalAmountUser = newGame.totalAmount(playerStack, empty, userAce);  // users points
         totalAmountCom = newGame.totalAmount(computerStack, empty, comAce);  // computers points
         toStringCom = newGame.toString(computerStack, empty);                // computer stack string
         toStringU = newGame.toString(playerStack, empty);                    // user stack string      
         
         // while one or both players are not ready
         while(exit == false) {  
          
            // if player isn't ready
            if(ready1 == false) {  
               System.out.println("Your Hand: ");
               System.out.println(toStringU);
               System.out.println("Total: " + totalAmountUser);
               System.out.println();
               
               inputSH = false; // resets inputSH for input checking
               
               // checks that user enter s or h 
               while(inputSH == false) {
                  System.out.print("Would you like (h)it or (s)it? ");
                  draw = input.next(); // prompts user
                  draw = draw.substring(0,1); // first letter
                  draw = draw.toLowerCase(); // to lowercase

                  // if h hit
                  if(draw.equals("h")){
                        inputSH = true; // input is correct
                        System.out.println("You Hit");
                        newGame.hit(playerStack); // hit method from other class
                        System.out.println();
                        
                        toStringU = newGame.toString(playerStack, empty); // creates a string with the users stack
                        totalAmountUser = newGame.totalAmount(playerStack, empty, userAce); // says how much the user has right now
                        
                        // check if busted or not
                        if(totalAmountUser > 21) {
                           ready1 = true; // done hitting because bust
                           ready2 = true;
                           busted = true;
                           System.out.println("!BUSTED!");
                           System.out.println();
                           System.out.println("Your Hand: ");
                           System.out.println(toStringU);
                           System.out.println("Total: " + totalAmountUser);

                        }
                     }
                    
                     // if s do nothing player is ready
                     else if(draw.equals("s")) {
                        System.out.println("Waiting for other player to be ready... ");
                        System.out.println();
                        ready1 = true; // done hitting because sitting
                        inputSH = true; // input was correct

                     }
                     
                     // wrong input
                     else {
                        System.out.println("Error: invalid input please try again... ");
                        inputSH = false; // input is false
                     }
                  } // end of inputSH while loop

               } // end of ready1 if else statement
               
               // if computer isn't ready yet
               if(ready2 == false) {
                  
                  // for computer hit or sit based off strategies online
                 if(totalAmountCom <= 16 && totalAmountCom != 11) {
                     System.out.println("Other player Hit");
                     newGame.hit(computerStack); // hit computerStack

                     totalAmountCom = newGame.totalAmount(computerStack, empty, comAce); // how much the computer has right now
                     
                     // if computer is out of bounds
                     if(totalAmountCom > 21) {
                        ready2 = true; // ready because bust
                        ready1 = true; // means the other player one so exit
                        bustedC = true; // lost
                        System.out.println("Other Player !BUSTED!");
                        System.out.println();
                        System.out.println("CONGRAGULATIONS You Won!");
                     } // end of if bust
                     
                     System.out.println();
   
                  } // end of if statement for hit 
                  
                  // computer is ready
                  else {
                     ready2 = true; // ready
                     System.out.println("Other Player Ready!!");
                     System.out.println();
                  } // end of if else
               } 
               
               // when both are ready, exit
               else if(ready1 == true && ready2 == true){
                  exit = true;
               } // end of ready if else statement
           } // end of hit while loop
         
         // determines who wins and will display if neither of the bust
         if(busted == false && bustedC == false) {
               
               // if user got the highest points
               if(totalAmountUser > totalAmountCom) {
                  System.out.println("CONGRAGULATIONS You Won!");
               }    
               
               // if computer go highest points
               else if(totalAmountCom > totalAmountUser) {
                  System.out.println("Oh No! You Lost");
               }
               
               // if user and computer got the same amount of points
               else {
                  System.out.println("It's a Tie");
               }
               
               System.out.println();
         }
           
        // will desplay the final scores of the players 
        System.out.println();
        System.out.println("Final Results: ");
        System.out.println("You: " + totalAmountUser);
        System.out.println("Other: " + totalAmountCom);
        System.out.println();
           
        // asks user if they would like to play another round
        while(again == true) {
           System.out.print("Would you like to play again? (y)es or (n)o?: ");
           againString = input.next();
           System.out.println();
           againString = againString.toLowerCase(); // to lowercase
           againString = againString.substring(0,1); // pull just the first letter of input
           
           // if the user wants to play again repeats
           if(againString.equals("y")) {
               System.out.println("Starting another game... ");
               System.out.println();
               playAgain = true; // repeats full game loop
               again = false; // exits again loop, input was accurate
           }
           
           // if the user is done
           else if(againString.equals("n")){
               System.out.println("Thank you for playing!");
               playAgain = false; // exits full game loop
               again = false; // exits again loop, input was accurate
           }
           
           // input didn't start with an n or y
           else {
               System.out.println("Error: inaccurate input, please try again... ");
               again = true; // repeats again loop, inpute was incorrect
           } // end of if else statement for string 
               
         } // end of again while loop
           
       } // end of playAgain while loop
      
     } // end of main method
     
      // displays instructions for game, link for instructions
      public static void instructions(){
         
         System.out.println("Instructions: ");
         System.out.println("The goal of the game is to reach 21 points without going over.");
         System.out.print("You and the opponent will draw 2 cards each, ");
         System.out.println("if you would like to pull another card you will type 'hit'.");
         System.out.print("BUT, if the next cards puts you over"); 
         System.out.println("21 you must type 'busted' and you loose the game.");
         System.out.println("When both players are ready, you will turn your cards over.");
         System.out.println("The player with the number closes to 21 wins");
         System.out.println("More information under this link: https://bargames101.com/21-card-game-rule/");
         System.out.println();
      
     } // end of instructions method

} // end of Game21

