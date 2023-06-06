/*
Programmer: Abbigail Farr
DateL: 4/24/2023
Class: CS& 145
Assignment: Phone Book
Purpose: creates person contact as a node object, creates a single linked list of nodes of the contacts as object
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.awt.*;
import java.util.Arrays;

public class ListNode {
   
   // variables
   String date;
   String[] hourly;

   ListNode data; // holds data
   ListNode next; // holds next node 

   
   // creates empty list node object 
   public ListNode() {

   }
   
   // creates new contact listnode
  public ListNode(String date, String[] hourly) {
      
      // initializing
      this.date = date;
      this.hourly = hourly;
      
  } // end of list node method
   
  // creates list first list node if next is null
  public ListNode(ListNode data) {
      this.data = data;
      this.next = null;
   }
   
   // creates new node building off of the last node
   public ListNode(ListNode data, ListNode next) {
      this.next = next;
      this.data = data;
   }
   


} // end of list node