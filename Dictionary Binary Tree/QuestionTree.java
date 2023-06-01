/*
Programmer: Abbigail Farr
Date: 5/24/2023
Class: CS& 145
Assignment: Lab 6 20 Questions
Purpose: create the game of 20 questions 
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class QuestionTree {
   
   UserInterface ui;
   String input;
   QuestionNode overallRoot;
   QuestionNode root;
   QuestionNode left;
   QuestionNode right;
   String nodeStr;
   int count;
   String inputFileStr;
   Scanner inputStr;
   Scanner inputExtra;
   boolean first;
   int totalGames;
   int gamesWon;
   boolean first2;
   

   
   
   // constrcuter initialize your new question tree
   public QuestionTree(UserInterface ui){
       
       // initializes variables
       this.first = true;
       this.first2 = true;
       this.count = 0;
       this.root = new QuestionNode("");
       this.overallRoot = this.root;
       this.left = new QuestionNode("computer");
       this.totalGames = 0;
       this.gamesWon = 0;


   }
   
   
   // takes the current tree and takes it to a string    
   public void nodeToString(QuestionNode node) {
         
         
         // if you reach the end return
         if (node == null) {
            //this.first2 = true;
            return;
         }
         
         
         // string of a single node input
         String nodeInput = node.input;

         
         // if it is a question add the Q
         if(nodeInput.contains("?")) {
            nodeInput = "Q:" + nodeInput;

         }
         
         // if it is an answer add the A
         else {
            nodeInput = "A:" + nodeInput;

         }
         
         // if it is the first time it only adds the node input (no line)
         if(this.first2 == true) {
         
            this.first2 = false;
            this.nodeStr = nodeInput;
            
         }
         
         // after first time keeping adding new line and input
         else {
         
            this.nodeStr = this.nodeStr + "\n" + nodeInput;
            
         }
         
         // recurs and creates the new string until the end
         nodeToString(node.left); // node to the left
         nodeToString(node.right);// node to the right

   } // end of nodeToString method
    
      
   // returns the binary tree as a string 
   public String returnNodeStr() {
      
      return this.nodeStr;
   }

   
   // play one complete guessing game with the user
   public void play(){
      
      Scanner input = new Scanner(System.in);
      this.totalGames++; // adds up total games
      
      // variables
      String userAnswer = ""; // holds user input
      String object = ""; // holds the object name user is adding
      String question = ""; // holds question to object user adds
      String answer = ""; // holds answer to question to obejct user adds
      String playAgain = ""; // holds if player wants to play again
      String reachA = "Is your object a "; // for asking about the object when it reaches
      String ifLose = "I lost. What was the object you were thinking of?";// when loosing
      //boolean empty = false;

      // this happens ONLY if we are not importing a file
      // only happens the first time around
      if(this.root.input.equals("")) {

         // the first time the obly object is a computer so it asks
         System.out.print(reachA + this.left.input + "? ");
         
         // takes in the user input and makes it a substring
         userAnswer = input.nextLine();
         userAnswer = userAnswer.substring(0,1);
         userAnswer = userAnswer.toLowerCase();
         
         // if lost asks for information about the object
         if(userAnswer.equals("n")){
            
            this.gamesWon++; // adds to games won
            
            // print loose and asks for users object
            System.out.print(ifLose + " ");
            object = input.nextLine();
            
            
            // gets question of object they are thinking of
            System.out.print("Enter a yes or no question related to your object? ");
            question = input.nextLine();
            
            
            // gets a yes or no question to the object
            System.out.print("Is the answer (yes) or (no) to your question? ");
            // takes in the user input and makes it a substring
            answer = input.nextLine();
            answer = answer.substring(0,1);
            answer = answer.toLowerCase();
    
            // creates new node for root (being the question
            this.root = new QuestionNode(question); // root is a new node
            this.overallRoot = this.root;  // this never changes
            this.root.right = new QuestionNode(this.left.input); // right is no
            this.root.left = new QuestionNode(object); // left is yes

            
         } // end of if the computer lost
         
         // if the computer wins
         else {
            
            System.out.println("I Win!");
         
         }
         
         // creates the strin gof the tree
         this.nodeToString(this.root);
         String str = this.returnNodeStr();
         return; // exits
         
      } // end of the first game 

      
      /******** game starts ***********/
      // occurs when not starting from scratch
      
      // variables
      boolean left = true; // holds which side node was last taken from
      boolean reachedAnswer = false; // goes true when answer is reached
      this.root = this.overallRoot; // declares root to loop through
      
      // will loop until it reaches an answer
      while(reachedAnswer == false){

         // prints the current question
         System.out.print(this.root.input + " ");
         // takes in the user input and makes it a substring
         userAnswer = input.nextLine();
         userAnswer = userAnswer.substring(0,1);
         userAnswer = userAnswer.toLowerCase();
         
         
         // if yes goes to the left
         if(userAnswer.equals("y")) {
            left = true; // last was fromthe left
            
            // checks if there is a question mark
            if(!this.root.left.input.contains("?")) {
               reachedAnswer = true; // will exit loop
            }
            
            // continues to the next
            else {
               this.root = this.root.left; // redeclares the root
            }

         } // end of if eyes
         
         // if no goes to the right
         else if(userAnswer.equals("n")) {
            left = false; // last from the right
            
            // if the next one is an answer exit the loop
            if(!this.root.right.input.contains("?")) {
               reachedAnswer = true; // reached answer
            }
            
            // still a quuestion continues to the next
            else {
               this.root = this.root.right; // redeclares the root
            }

         }// end of yes no if else statement
         
         

      } // end of while

      
      // will print the answer
      // if next was to the left print left
      if(left == true) {
      
         System.out.print(reachA + this.root.left.input + "? ");
         
      }
      
      // print the next to the right 
      else {
      
          System.out.print(reachA + this.root.right.input + "? ");

          
      }
      
      // takes in the user input and makes it a substring
      userAnswer = input.nextLine();
      userAnswer = userAnswer.substring(0,1);
      userAnswer = userAnswer.toLowerCase();
      
      // if lost asks for information about the object
      if(userAnswer.equals("n")){
         
         this.gamesWon++; // adds to games won
         
         //System.out.println(this.root.input);
         System.out.print(ifLose + " ");
         object = input.nextLine();
         
         // gets the object they were thinking of
         System.out.print("Enter a yes or no question related to your object? ");
         question = input.nextLine();
         
         // gets a yes or no question to the object
         System.out.print("Is the answer (yes) or (no) to your question? ");
         // takes in the user input and makes it a substring
         answer = input.nextLine();
         answer = answer.substring(0,1);
         answer = answer.toLowerCase();
         
         // creates new part
         QuestionNode newQuestion = new QuestionNode(question);
         QuestionNode newAnswer = new QuestionNode(object);
         QuestionNode oldAnswer;

         // last answer stemmed to the left add new to the left
         if(left == true) {
            
            // will swithc the old answer and add new quedstion
            oldAnswer = this.root.left;
            this.root.left = newQuestion;
            
            // if the answer to the new question is yes add to left
            if(answer.equals("y")) {
               this.root.left.left = newAnswer; // declares to right and left
               this.root.left.right = oldAnswer;
               
            }
            
            // if answer to new is no add to right
            else {
            
               this.root.left.right = newAnswer; // declares to right then left
               this.root.left.left = oldAnswer;
            
            }
         
            
          } // end of if left
          
          
          // if last answer stemmed to the right add new to the right
          else {
            //this.root = this.overallRoot;
            oldAnswer = this.root.right;
            this.root.right = newQuestion;
            
            // if answer to new is yes
            if(answer.equals("y")) {
               this.root.right.left = newAnswer; // declares left then right
               this.root.right.right = oldAnswer;
            }
            
            // if answer to new is no
            else{
               this.root.right.right = newAnswer; // declares right then left
               this.root.right.left = oldAnswer;
            }
          
          } // end of left if else statements

         
      } // end of if the computer lost
      
      
      // if computer wins
      else {
      
         System.out.println("I Win!");
        
         
      }
     
     // creates a new string
     this.nodeStr = null;
     this.nodeToString(this.overallRoot);
     String str = this.returnNodeStr();
   
   } // end of play method
   
   // store the current tree state to an outputfile 
   // allows the tree to keep growing
   public void save(PrintStream output) {
   
      PrintStream out = new PrintStream(output); // prints to file
         out.print(this.nodeStr); // prints the tree to the file
      
   }
   
   
   // replace the current tree by reading another tree from a file
   public void load(Scanner input) 
      throws FileNotFoundException, IOException {
      
      // variables
      String thisLine = ""; // current l;ine
      this.inputExtra = input; // extrra scanner for checking
      String inputExtraStr; // extra string for checking

      // only runs the first time
      if(this.count == 0) {
      
         
         // if there is no line
         if(!input.hasNextLine()) { 
            return;
         }

         // creates the root as a substring of the first line
         //input.nextLine();
         thisLine = input.nextLine();
         thisLine = thisLine.substring(2);
         
         // declares overall root (doesn't change)
         this.overallRoot = new QuestionNode(thisLine);
         this.root = this.overallRoot; // declares root ans overall for looping
         
         this.count++; // now will not repeat this
      }
      
      
      // checks if there is a line
      if(!input.hasNextLine()) {
 
         return;
      }
      
      // this line is the next
      thisLine = input.nextLine();
      
      // if a question
      if(thisLine.contains("?")) {
         
         // creates substring of the line and makes a new 
         // question node from it
         thisLine = thisLine.substring(2);
         this.root.left = new QuestionNode(thisLine);
         this.root = this.root.left; // re-declares root
         load(input); // recurs
      }
      
      // if an answer 
      else {
         
         // creates a substring and adds new node
         thisLine = thisLine.substring(2);
         this.root.left = new QuestionNode(thisLine);
         
         // if two answers (including the one just added)
         // are connected to the current root(?) 
         // then you will start building from the overall root
         if(this.root.right != null) {
            
            // checks if right side is also an answer
            if(!this.root.right.input.contains("?")) {
               this.root = this.overallRoot;
            }
         }

      }
      
      // checks if there is next line
      if(!input.hasNextLine()) {
    
            return;
      }
      
      // next line on scanner
      thisLine = input.nextLine();     
      
      // if a question
      if(thisLine.contains("?")) {
         
         // creates substring of line and adds new node
         thisLine = thisLine.substring(2);
         this.root.right = new QuestionNode(thisLine);
         this.root = this.root.right; // redeclares
         load(input); // recurs
      }
      
      // if an answer
      else {
         
         // substring of line and add new node
         thisLine = thisLine.substring(2);
         this.root.right = new QuestionNode(thisLine);
         
         // checks if both nodes off a root
         // are answers
         if(this.root.left != null) {
            
            // checks if other node is an answer too
            if(!this.root.left.input.contains("?")) {
               
               this.root = this.overallRoot; // redeclares the root
            }
         }
      } // end of if else

      
            
   } // end of load method

   // return number of games
   public int totalGames(){
      return this.totalGames;
   }
   
   // return games won
   public int gamesWon() {
      return this.gamesWon;
   }
   
      
}









