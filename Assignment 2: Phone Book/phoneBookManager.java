/*
Programmer: Abbigail Farr
DateL: 4/24/2023
Class: CS& 145
Assignment: Phone Book
Purpose: takes information from user and generates contact objects and adds to the list node
Extra credit: 
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.awt.*;
import java.util.Arrays;

public class phoneBookManager {

  ListNode next;     // shows the values of node you are reading
  ListNode front;    // holds value of first element for looping
  ListNode current;  // as you loop, holds the node you are at now

  // default variables creates empty phone book object
  public phoneBookManager() {
  
  } // end of phonBookManager
  
  // add a new contact to end of the contact list
  public void add(ListNode newContact) {
      
      // if there are no contacts in the list yet
      if(this.front == null) {
         this.front = newContact; // starts new list
      }
      
      // if contacts exists
      else {
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current.next != null) {
            this.current = current.next; 
         }
         
         this.current.next = newContact; // adds new contact to the end of the list
         
      }// end of does list exist if else statement
      
  } // end of add method
  
  // will remove a contact from the list based on the contact number
  public boolean remove(int contactNumber) {
    
      boolean exists = false; // returns whether or not the contact exists

         // if the list is empty
         if(this.front == null) {
            System.out.println("Error: you must enter a contact first.");  
            return exists = false;
         }
         
         // if list exists
         else {
         
            this.current = this.front; // defines current as first data entry of the list node
            
            // if the removed contact is the first one;
            if (contactNumber == this.front.contactOrder) {
               this.front = this.front.next; // re orders the first node as the second node
               return exists = true;
            } 
            
            // if the removed contact is after the first
            else {
               // while the order number is not the one for the removed contact
               while(this.current.next != null && this.current.next.contactOrder != contactNumber) {
                  this.current = this.current.next; // to the next node
               }
               
               
               // if you get to the end
               if(this.current.next == null) {
                  System.out.println("Error: the contact number you entered does not exist.");
                  return exists = false;
               }
               
               // if removable remove
               else {
                  this.current.next = this.current.next.next;
                  return exists = true;
               } // end of does contact exists if else statement
   
             } // end of contact removal lcoation if else statement
             
          } // end of is there a contact if else statement
          
  } // end of remove method
  
  // returns the number of contacts there is (highest contactOrder)
  public int returnContactOrder() {
         
         int countOrder = 1;  // initializes contact order to start
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null) {
            this.current = current.next;  // next node
            countOrder++; // adds up
         }
         
         return countOrder;   // returns contact amount
  }   // end of return Contact order method
  
  // updates all parts of an existing contact
  public void updateFull(String firstName, String lastName, String phoneNumber, int contactOrder, String address, String location) {
      
      // if there are no contacts in the list yet
      if(this.front == null) {
        System.out.println("Error: first add contacts to edit");
      }
      
      // if contacts exists
      else {
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next;  // next node
         }
         
         // changes the information
         this.current.firstName = firstName;
         this.current.lastName = lastName;
         this.current.phoneNumber = phoneNumber;
         this.current.address = address;
         this.current.cityState = location;
         
      }// end of does list exist if else statement
      
  } // end of update method
  
  // updates the contact order as contacts are added and removed throughout the process
  public int updateContactOrder(int contactOrder) {
         
         int returnNum = 1; // returns the number of contacts in the list 
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the the contact number that will be deleted
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next; 
         }
         
         // keeps this number the same so the other program knows what to delete
         this.current = current.next; 
         
         // loops through each node until it reaches the end re-assigning contact numbers
         while(this.current != null) {
            this.current.contactOrder = this.current.contactOrder - 1; // goes back since deleting
            this.current = current.next; // next node
         }
         
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end to return number of contacts
         while(this.current != null) {
            this.current = current.next; 
            returnNum++; // counts
         }
         
      return returnNum - 1;
      
  } // end of update contact order method
  
  
  // updates the name of an existing contact
  public void updateName(String firstName, String lastName, int contactOrder) {
  
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next; 
         }
         
         this.current.firstName = firstName; // changes the name
         this.current.lastName = lastName;

      
  } // end of update name method
  
  // updates address of an existing contact
  public void updateAddress(String address, int contactOrder) {
      
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next; 
         }
         
         this.current.address = address; //changes the address
      
  } // end of update address method
  
  // updates location of an existing contact
  public void updateLocation(String cityState, int contactOrder) {
  
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next; 
         }
         
         this.current.cityState = cityState; // changes lcoation
      
  } // end of update location method
  
  // changes the phone number of an existing contact
  public void updatePhone(String phoneNumber, int contactOrder) {
      
      // if there are no contacts in the list yet
      if(this.front == null) {
        System.out.println("Error: first add contacts to edit");
      }
      
      // if contacts exists
      else {
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current != null && this.current.contactOrder != contactOrder) {
            this.current = current.next; 
         }
         
         this.current.phoneNumber = phoneNumber;
         
      }// end of does list exist if else statement
      
  } // end of update name method
  
  // displays full list of contacts 
  public String getContacts() {
      
      // contact variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list is empty there will be no name
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while there are still contacts left
         while(this.current != null) {
      
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact and adding the contacts onto each other
            fullContact = fullContact + "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n\n";
            
            this.current = this.current.next; // next node
            
         }
         
         return fullContact; // return name
      }
      
  } // end of contactByName
  
  // search by firstName 
  public String contactByFName(String fName) {
      
      // variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list is empty there will be no name
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while the name isn't found
         while(this.current != null && !this.current.firstName.equals(fName)) {
            this.current = this.current.next; // next node
         }
         
         // if there is nothing return nothing
         if(this.current == null) {
            return null;
         }
         
         else {
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact
            fullContact = "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n";
            
            return fullContact; // return name
            
         }
      }
      
  } // end of contactByName
  
   // search by lastName 
  public String contactByLName(String lName) {
      
      // variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list is empty there will be no name
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while the name isn't found
         while(this.current != null && !this.current.lastName.equals(lName)) {
            this.current = this.current.next; // next node
         }
         
         // if there is nothing return nothing
         if(this.current == null) {
            return null;
         }
         
         else {
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact
            fullContact = "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n";
            
            return fullContact; // return name
            
         }
      }
      
  } // end of contactBylastName

  
  // search by phone number
  public String contactByPhone(String phoneNum) {
      
      // variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list is empty there will be no name
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while the phone number isn't found
         while(this.current != null && !this.current.phoneNumber.equals(phoneNum)) {
            this.current = this.current.next; // next node
         }
      
         // if there is nothing return nothing
         if(this.current == null) {
            return null;
         }
         
         else {
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact
            fullContact = "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n";
            
            return fullContact; // return name
          
          } 
       }
      
  } // end of contactByPhoneNumber
  
  // search by firstName 
  public String contactByLocation(String loca) {
      
      // variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list is empty there will be no name
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while the name isn't found
         while(this.current != null && !this.current.cityState.equals(loca)) {
            this.current = this.current.next; // next node
         }
      
         // if there is nothing return nothing
         if(this.current == null) {
            return null;
         }
         
         else {
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact
            fullContact = "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n";
            
            return fullContact; // return name
            
         }
       
       }
      
  } // end of contactByLocation
  
  // returns contact number (not phone number the digit)
  public String contactByContactNum(int contactNum) {
      
      // variables
      String firstName = "";
      String lastName = "";
      String cityState = "";
      String address = "";
      String phoneNumber = "";
      int contactNumberInt = 0; // num of contact order 
      String contactNumber = ""; // string of contact oder
      String fullContact = "";   // entire contact
      
      
      // brings current node back to the beginning 
      this.current = front;
      
      // if the list has nothing
      if (this.current == null) {
         return null;
      }
      
      // if there is entries
      else {
         // while the number isn't found
         while(this.current != null && this.current.contactOrder != contactNum) {
            
            this.current = this.current.next; // next node
            
         }
         
         // if you get to the end 
         if(this.current == null) {
            System.out.println("Error: the contact number you entered does not exist.");
            return null; // does not exist
         }
         
         // if exists
         else {
                     
            // define contact details
            firstName = this.current.firstName;
            lastName = this.current.lastName;
            cityState = this.current.cityState;
            address = this.current.address;
            phoneNumber = this.current.phoneNumber;
            contactNumberInt = this.current.contactOrder;
            contactNumber = String.valueOf(contactNumberInt);
            
            // defining the full contact and adding the contacts onto each other
            fullContact = fullContact + "Contact " + contactNumber + " Information" + "\n";
            fullContact = fullContact + "Full Name: " + firstName + " " + lastName + "\n";
            fullContact = fullContact + "Phone Number: " + phoneNumber + "\n";
            fullContact = fullContact + "Location (City, State): " + cityState + "\n";
            fullContact = fullContact + "Address: " + address + "\n\n";
            
            return fullContact;
            
         } // end of does contact exists if else statement

      } // end of if else exists statements
      
  } // end of contact by contact num

}  // end of phoneBookManager


















