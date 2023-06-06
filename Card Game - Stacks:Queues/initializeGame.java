/*Programmer: Abbigail Farr
Date: 4/17/2023
Class: CS& 145
Assignment: Lab 4 Deck of Cards
Purpose: initializes 21 card game, holds methods for storing and reading stacks 
Extra credit: Switch/case
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.awt.*;
import java.util.Arrays;

public class initializeGame extends Decks {
   
    Stack<String> newStack;
    Stack<String> playerStack = new Stack<String>(); // creates empty stack for player
    Stack<String> computerStack = new Stack<String>(); // creates empty stack for the computer to use 
    Stack<String> empty = new Stack<String>(); // used to reserve, should always be empty.
    
    
   // initializes the first deal of a new game
   public void firstDeal() {
      Decks newDeck = new Decks(); // creates new deck object
      newStack = newDeck.shuffleStack(); // creates a new stack from the deck, shuffles original

      playerStack.add(newStack.pop());
      computerStack.add(newStack.pop());
      playerStack.add(newStack.pop());
      computerStack.add(newStack.pop());

   } // end of firstDeal 
   
   // returns the stack contained for the player/user
   public Stack playerStack() {
      return playerStack;
   } // end of playerStack
   
   // returns the stack being played by the computer
   public Stack computerStack() {
      return computerStack;
   } // end of computer stack
   
   public String pop(Stack<String> stack) {
      return stack.pop();
   }
   
   // if the player or computer chooses to 'hit' 
   //a card will be popped from the stack and added to their pile
   public void hit(Stack<String> stack) {
   
      stack.add(newStack.pop());
   
   } // end of hit
   
   // returns cardValue
   public int cardValue(String card, int userAce) {
     
            String card1 = card;
            int cardNum = 0;
            
            if(card1.length() > 2) {
               
               // switch case for face cards
               switch (card1){
                  case "Jack":
                     cardNum = 10;
                     break;
                  case "Queen":
                     cardNum = 10;
                     break;
                  case "King":
                     cardNum = 10;
                     break;
                  case "Ace":
                     cardNum = userAce;
                     break;
               } // end of switch case
             } // end of face if statement

             // parse to number
             else {   
               cardNum = Integer.parseInt(card1);
             }
             //System.out.println(cardNum);
         return cardNum;
     } // end of cardvalue method
     
     // adds up total value of a stack and returns the total
     public int totalAmount(Stack<String> stack, Stack<String> extra, int userAce) {
         
         String card; // full card
         String card1; // first part
         int totalAmount = 0;
         int cardNum = 0;
         
         while(!stack.empty()) {
            card = stack.pop(); // full card
            extra.add(card);
            //System.out.println(card);
            card1 = card.substring(0,card.indexOf(" ")); // the number part
            cardNum = cardValue(card1, userAce); // returns the number value of the card
            
            totalAmount += cardNum;
            
         }
         
         // returns values back to original stack
         while(!extra.empty()) {
            stack.add(extra.pop());
         }
         return totalAmount;
     }
     
     // creates string out of stack
     public String toString(Stack<String> stack, Stack<String> extra) {
         
         String stringHand = ""; // initializes return string
         String card; // creates string of single card
         while(!stack.empty()) {
            card = stack.pop(); // pops card and creates into string
            extra.add(card); // add card to extra pile to hold
            
            stringHand = stringHand + "[" + card + "] "; // creates whole string of hand
         }
         
         // returns values back to original stack
         while(!extra.empty()) {
            stack.add(extra.pop());
         }
         
         return stringHand;
     } // end of toString method

}