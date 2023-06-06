/*Programmer: Abbigail Farr
DateL: 4/17/2023
Class: CS& 145
Assignment: Lab 4 Deck of Cards
Purpose: Creates the deck of cards object called to play the game
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.awt.*;

public class Decks {
   
   Stack<String> deck = new Stack<String>(); // creates deck
   
   // adds each card to deck
   public Decks() {
      deck.add("Ace of hearts");
      deck.add("2 of hearts");
      deck.add("3 of hearts");
      deck.add("4 of hearts");
      deck.add("5 of hearts");
      deck.add("6 of hearts");
      deck.add("7 of hearts");
      deck.add("8 of hearts");
      deck.add("9 of hearts");
      deck.add("10 of hearts");
      deck.add("Jack of hearts");
      deck.add("Queen of hearts");
      deck.add("King of hearts");
      deck.add("Ace of clubs");
      deck.add("2 of clubs");
      deck.add("3 of clubs");
      deck.add("4 of clubs");
      deck.add("5 of clubs");
      deck.add("6 of clubs");
      deck.add("7 of clubs");
      deck.add("8 of clubs");
      deck.add("9 of clubs");
      deck.add("10 of clubs");
      deck.add("Jack of clubs");
      deck.add("Queen of clubs");
      deck.add("King of clubs");
      deck.add("Ace of spades");
      deck.add("2 of spades");
      deck.add("3 of spades");
      deck.add("4 of spades");
      deck.add("5 of spades");
      deck.add("6 of spades");
      deck.add("7 of spades");
      deck.add("8 of spades");
      deck.add("9 of spades");
      deck.add("10 of spades");
      deck.add("Jack of spades");
      deck.add("Queen of spades");
      deck.add("King of spades");
      deck.add("Ace of diamonds");
      deck.add("2 of diamonds");
      deck.add("3 of diamonds");
      deck.add("4 of diamonds");
      deck.add("5 of diamonds");
      deck.add("6 of diamonds");
      deck.add("7 of diamonds");
      deck.add("8 of diamonds");
      deck.add("9 of diamonds");
      deck.add("10 of diamonds");
      deck.add("Jack of diamonds");
      deck.add("Queen of diamonds");
      deck.add("King of diamonds");
    }
    
    // will take deck and shuffle it randomly returning a new deck
    public Stack shuffleStack() {
      Collections.shuffle(deck);
      return deck;
    }
    
    // makes a string out of the deck and prints
    public String toString() {
      String stringDeck = deck.toString();
      System.out.print(stringDeck);
      return stringDeck;
    }
    

} // end of deck class

