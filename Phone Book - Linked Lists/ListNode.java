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
   String firstName; // contact first name
   String lastName; // contact last name
   String address; // contact address
   String cityState; // contact location
   String phoneNumber; // contact phone number
   int contactOrder; // integer corresponding to order of contact
   String contactString = ""; // contact info

   ListNode data; // holds data
   ListNode next; // holds next node 
   
   // creates empty list node object 
   public ListNode() {

   }
   
   // creates new contact listnode
  public ListNode(int contactOrder, String firstName, String lastName, String address, String cityState, String phoneNumber) {
      
      // initializing
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.cityState = cityState;
      this.phoneNumber = phoneNumber;
      this.contactOrder = contactOrder;
      
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


