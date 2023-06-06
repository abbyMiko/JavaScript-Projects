/*
Programmer: Abbigail Farr
Date: 5/24/2023
Class: CS& 145
Assignment: Lab 6 20 Questions
Purpose: create question node object for 20 questions
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class QuestionNode {
   
   String input; // answer and question
   QuestionNode overallRoot; // will hold first root
   QuestionNode root; // for passing through tree
   QuestionNode left; // direction
   QuestionNode right; // direction
   
   
   public QuestionNode(String input) {
   
      qNode(this.root, input); // takes root and input and creates node
      
   }
   
   // recuring method
   private void qNode(QuestionNode root, String input) {
      
      this.overallRoot = null;
      this.input = input;
      this.root = root;
      left = right = null;
      
            
   }
    
   
}