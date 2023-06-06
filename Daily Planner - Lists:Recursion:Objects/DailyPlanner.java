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

public class DailyPlanner {
   
   ListNode data;
   ListNode next;
   ListNode front;
   ListNode current;
   
   // creates planner obje t
   public DailyPlanner() {

   }
   
   // add a new day 
   public void addDay(ListNode newDay) {
      
      // if front is null newDay is front
      if(this.front == null) {
         
         this.front = newDay;
      
      }
      
      // if exists
      else {
      
         this.current = front; // assigns current to front
         
         // loops through each node until it reaches the end
         while(this.current.next != null) {
            this.current = current.next; 
         }
         
         this.current.next = newDay; // adds new day
         
      }// end of does list exist if else statement
      
   }
   
   
   // returns if the day exists 
   public boolean dayExist(String date) {
      
      // if null return
      if(this.front == null) {
      
         return false;
         
      }
      
      // exists
      else{
      
         this.current = this.front;
         
         // loops until it reaches either the end or the date
         while(this.current.next != null && !this.current.date.equals(date)) {
            this.current = this.current.next;
         }
         
         // if it reached a date return true
         if(this.current.date.equals(date)){
            return true;
         }
         
         else {
            return false;
         } // end of if else
      
      } // end of if else
   
   } // end of dayExist method
   
   // deltes a date from the list
   public void delete(String date) {
   
      // if the list is empty
      if(this.front == null) {
         System.out.println("Error: no dates entered.");  
         //return exists = false;
      }
      
      // if list exists
      else {
      
         this.current = this.front; // defines current as first data entry of the list node
         
         // if the removed is the first one;
         if (this.current.date.equals(date)) {
            this.front = this.front.next; // re orders the first node as the second node
         } 
         
         // if the removed is after the first
         else {
         
            // while the order number is not the one for the removed 
            while(this.current.next != null && !this.current.next.date.equals(date)) {
               this.current = this.current.next; // to the next node
            }
            
            
            // if you get to the end
            if(this.current.next == null) {
               System.out.println("Error: date does not exist.");
            }
            
            // if removable remove
            else {
               this.current.next = this.current.next.next;
            } // end of if else statement

          } // end of if else statement
          
       } // end of if else statement

   } // end of delete method
   
   // changes the hourly array
   public void changeHourly(String date, String[] newHourly) {
   
      // if the list is empty
      if(this.front == null) {
         System.out.println("Error: no dates entered.");  
      }
      
      // if list exists
      else {
      
         this.current = this.front; // defines current as first data entry of the list node
         
         // if thethe first one;
         if (this.current.date.equals(date)) {
            this.current.hourly = newHourly; // assigns new hourly
         } 
         
         // if the removed is after the first
         else {
         
            // while the order number is not the one for the removed 
            while(this.current.next != null && !this.current.next.date.equals(date)) {
               this.current = this.current.next; // to the next node
            }
            
            
            // if you get to the end
            if(this.current.next == null) {
               System.out.println("Error: date does not exist.");
            }
            
            // if exists change
            else {
               this.current.hourly = newHourly;

            } // end of if else statement

          } // end of if else statement
          
       } // end of if else statement
   
   } // end of changeHourly
   
   // returns array of the day schedule
   public String[] returnDay(String date) {
   
      String[] returnDay = null;
      
      // if the list is empty
      if(this.front == null) {
         System.out.println("Error: no dates entered.");  
      }
      
      // if list exists
      else {
      
         this.current = this.front; // defines current as first data entry of the list node
         
         // if the first one;
         if (this.current.date.equals(date)) {
            returnDay = this.current.hourly;
         } 
         
         // if is after the first
         else {
         
            // while the order number is not the date entered
            while(this.current.next != null && !this.current.next.date.equals(date)) {
               this.current = this.current.next; // to the next node
            }
            
            
            // if you get to the end
            if(this.current.next == null) {
               System.out.println("Error: date does not exist.");
            }
            
            // if removable remove
            else {
               returnDay = this.current.next.hourly;

            } // end of if else statement

          } // end of if else statement
          
       } // end of if else statement
       
       return returnDay;
   } // end of returnDay
   
   // returns all dates in planner
   public String viewAllDays() {
      
      // variables
      String days = "";
      String here = "";

      this.current = this.front;
      
      // if front is null return
      if(this.front == null) {
         return null;
      }
      
      // if there are dates
      else {
         
         // loops through each date
         while(this.current.next != null) {
            
            // adds each date
            here = this.current.date;
            days = days + "\n" + here;
            this.current = this.current.next;
         }
         
         days = days + "\n" + this.current.date;
      
      }
      
      return days;
   } // end of view all days
   
   // searches for days with a key word
   public String searchKeyWord(String keyWord) {
   
      // variables
      String dates = "";
      String[] hourly2 = null;
      String input = "";
      
      // if front is null return
      if(this.front == null) {
         return null;
      }
      
      // if it exists
      else {
      
         this.current = this.front;
         
         // loops for each node
         while(this.current.next != null) {
         
            hourly2 = this.current.hourly;
            
            // loops through all 24 hours and checks for key word
            for(int i = 0; i < 24; i++) {
               input = hourly2[i];
               
               // checks if the input has the keyword
               if(input.contains(keyWord)) {
                  dates = dates + "\n" + this.current.date;
                  i = 24;
               }
            } // end of for loop
            
            this.current = this.current.next;   
         } // end of while loop
         
         hourly2 = this.current.hourly;
         
         // loops through hour  
         for(int i = 0; i < 24; i++) {
            input = hourly2[i];

            // checks if there is key word
            if(input.contains(keyWord)) {
               dates = dates + "\n" + this.current.date;
               i = 24;
            }
         } // end of for loop
         
         
      } // end of if else
      
      return dates;
      
   } // end of search key word

} // end of list node