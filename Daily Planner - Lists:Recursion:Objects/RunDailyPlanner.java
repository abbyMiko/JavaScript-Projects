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

public class RunDailyPlanner {

   
   public static void main(String[] args){
      
      // variables
      DailyPlanner planner = new DailyPlanner(); // creates planner object
      int hour = 1;
      int userChoice = 0;
      boolean exit = false;
      
      // instructions
      instructions();
      
      // loops until user wants to exit
      while(exit == false) {
      
         userChoice = menu(); // display menu
         
         // add a new day
         if(userChoice == 1) {

            createDayNode(planner);
         
         }
         
         // delete a day
         else if(userChoice == 2) {

            deleteDay(planner);
         
         }
         
         // edit existing day
         else if(userChoice == 3) {
         
            editDay(planner);
            
         }
         
         // view full planner
         else if(userChoice == 4) {
         
            viewPlanner(planner);
            
         }
         
         // search for day
         else if(userChoice == 5) {
         
            searchDay(planner);
            
         }
         
         // filter through days
         else if(userChoice == 6) {
            keyWord(planner);
         }
         
         // exit
         else {
            exit = true;
            System.out.println("Exiting Planner...");
         }
      
      } // end of exit while loop
   
   } // end of main method
   
   // displays menu
   public static int menu() {
   
      Scanner input = new Scanner(System.in);
      
      // variables
      int userChoice = 0;
      boolean repeat = true;
      
      // loops until choice is made
      while(repeat == true) {
         
         userChoice = 0;
         
         // display menu
         System.out.println();
         System.out.println("Choose an option from below (1-7): ");
         System.out.println("(1) Add new day to planner");
         System.out.println("(2) Delete day from planner");
         System.out.println("(3) Edit an existing day");
         System.out.println("(4) View full list of days in planner");
         System.out.println("(5) View a day");
         System.out.println("(6) Filter Days (Ex: days with 'workout')");
         System.out.println("(7) Exit");
         System.out.println();
         
         // gets user choice
         System.out.print("Enter: ");
         userChoice = input.nextInt();
         
         // if choice is out of bounds repeat
         if(userChoice < 1 || userChoice > 7) {
            System.out.println("Error: Please enter a number 1-7");
            System.out.println();
            repeat = true;
         }
         
         else {
            repeat = false; //exit
         }
      
      } // end of repeat while loop
      
      return userChoice;
      
   } // end of meny method
   
   // displays instructions
   public static void instructions() {
   
      System.out.println("Welcome to your Daily Planner!");
      System.out.println("You can enter any date and add your schedule");
      System.out.println("by hour.");
      System.out.println("This information will be stored and you");
      System.out.println("can search the day to pull up what you entered.");
      System.out.println();
      
   } // end of instructions method
   
   // searches for dates that contain a key word
   public static void keyWord(DailyPlanner planner) {
      
      Scanner input = new Scanner(System.in);
      
      // variables
      String keyWord = ""; // key word
      String datesWith = ""; // returns dates with key word
      boolean again = true; // for repeating
      String answer = ""; // answer of user
      
      // instructions
      System.out.println();
      System.out.println("Here you can search for days by a key word.");
      System.out.println("For example, you could search 'work'");
      System.out.println("and the days that you worked will be printed below.");
      System.out.println();
      
      // loops until done
      while(again == true) {
      
         // gets user input
         System.out.print("Enter key word: ");
         keyWord = input.next();
         keyWord = keyWord.toLowerCase();
         System.out.println();
         
         datesWith = planner.searchKeyWord(keyWord); // returns dates with keyword
         
         // if no dates then display
         if(datesWith == null || datesWith.equals("")) {
         
            // asks if user wants to enter again
            System.out.print("Key word not in planner, would you like to enter another? ");
            answer = input.next();
            answer = answer.toLowerCase();
            answer = answer.substring(0,1);
            
            // if yes repeat
            if(answer.equals("y")) {
               System.out.println();
               again = true;
            }
            
            // if no exit
            else {
               again = false;
               System.out.println();
               System.out.println("Exiting... ");
            } // end of ifelse
            
         }
         
         // if there are dates with key word
         else {
            
            // prints dates with key word
            System.out.println("Dates with Key Word '" + keyWord + "'");
            System.out.println(datesWith);
            System.out.println();
            
            // asks if the user wants to enter another key word
            System.out.print("Would you like to enter another key word? ");
            answer = input.next();
            answer = answer.toLowerCase();
            answer = answer.substring(0,1);
            
            // if yes repeat
            if(answer.equals("y")) {
               System.out.println();
               again = true;
            }
            
            // if no exit
            else {
               again = false;
               System.out.println();
               System.out.println("Exiting... ");
            } // end of if else
            
         } // end of if else
      
     } // end of again 
   
   } // end of key word method
   
   
   // shows all dates in the planner
   public static void viewPlanner(DailyPlanner planner) {
      
      
      System.out.println();
      

      String allDays = planner.viewAllDays(); // string of all dates
      
      // if null say it is empty
      if(allDays == null) {
         System.out.println("Planner is Empty");
      }
      
      // display days in planner
      else {
         System.out.println("Days in Planner: ");
         System.out.println(allDays);
         System.out.println();
      }
      
   } // end of view planner
   
   // edit a day in the planner
   public static void editDay(DailyPlanner planner) {
      
      Scanner input = new Scanner(System.in);
      
      // variables
      String[] dayArray = null; // array of a single day
      boolean exists = false; // if day exists
      String another = ""; // again
      int choice = 0; // for choice
      boolean selected = false; // if selected is possible
      int hour = 0; // hour of day to edit
      String date = ""; // date
      boolean go = true; // if go
      int print = 0; // for printing
      
      // repeats until done
      while(go == true) {

         // asks for date
         System.out.println();
         System.out.print("Enter the date here(##/##/###): ");
         date = input.next();   
         
         // checks if this date exists
         exists = planner.dayExist(date);
         
         // if it does not exist
         if(exists == false) {
            System.out.println("Date entered does not exist");
            System.out.println();
            System.out.print("Would you like to enter another date? ");
            another = input.next();
            another = another.toLowerCase();
            another = another.substring(0,1);
            
            // if yes repeat
            if(another.equals("y")) {
               System.out.println();
            }
            // exit
            else {
               System.out.println();
               go = false;
            } // end of if else
            
            
         }
         
         // if it exists
         else {

            // gets the hours array
            dayArray = planner.returnDay(date);
            
            // prints date
            System.out.println("Date: " + date);
            System.out.println();
            
            // prints each hour in array
            for(hour = 0; hour < 24; hour++ ) {
               System.out.println(dayArray[hour]);
            }
            
            System.out.println();
            
            // repeats for user menu
            while(selected == false) {
            
               // options for how to edit
               System.out.println("Choose an option from below(1-3): ");
               System.out.println("(1) Edit a specific hour");
               System.out.println("(2) Edit entire day");
               System.out.println("(3) Exit");
               System.out.println();
               
               // gets user choice
               System.out.print("Enter: ");
               choice = input.nextInt();
               
               // if wrong number
               if(choice > 4 || choice < 1) {
                  selected = false;
                  System.out.println("Error: enter a number choice 1-3");
                  System.out.println();
               }
               
               // else follow through
               else {

                  boolean again2 = true;
                  String changeTo = "";
                  
                  //edit a specific hour
                  if(choice == 1) {
                     
                     // for entering right hour
                     while(again2 == true) {
                     
                        System.out.print("Enter the hour you would like to edit (1-24): ");
                        hour = input.nextInt();
                        
                        // wrong our so repeat
                        if(hour < 1 || hour > 24) {
                           again2 = true;
                           System.out.println("Error: enter an hour 1-24");
                        }
                        
                        // right hour
                        else {
                           again2 = false;
                           
                           // shows the hour changed
                           System.out.print("Hour Changing: ");
                           System.out.println(dayArray[hour - 1]);
                           System.out.println();
                           
                           // gets change
                           input.nextLine();
                           System.out.print("What would you like to change it to? ");
                           changeTo = input.nextLine();
                           changeTo = changeTo.toLowerCase();
                           
                           // gets time
                           String time = dayArray[hour - 1];
                           time = time.substring(0, time.indexOf(" "));
                           
                           // shows change
                           dayArray[hour - 1] = time + " " + changeTo;
                           System.out.println();
                           System.out.println("Hour successfully changed!");
                           System.out.print("New Input: ");
                           String newInput = dayArray[hour - 1]; // pulls input
                           newInput = newInput.substring(0,newInput.indexOf(" "));
                           
                           System.out.println(dayArray[hour - 1]); // prints the input
                           
                           // changes to new array in node
                           planner.changeHourly(date, dayArray);
                           System.out.println();
                           
                        } // end of if else
                        
                     } // end of again2
                     
                  } // end of if 1
                  
                  // edit entire day
                  else if(choice == 2) {
                     
                     String hourStr = "";
                     String newSchedule = "";
                     System.out.println("Enter your schedule by hour below: ");
                     
                     // goes through each hour
                     for(hour = 0; hour < 24; hour++) {
                        
                        // gets hour and removes the hour
                        hourStr = dayArray[hour];
                        hourStr = hourStr.substring(0,hourStr.indexOf(" "));
                        
                        // displays hour and gets user schedule for the hour
                        System.out.print(hourStr + " ");
                        newSchedule = input.nextLine();
                        
                        // updating array
                        dayArray[hour] = hourStr + " " + newSchedule; // create new array
                        planner.changeHourly(date, dayArray);
                        System.out.println();
                        System.out.println("New schedule added!");
                        
                     } // end of for loop
                  
                  } // end of if 2
                  
                  // exit
                  else if(choice == 3) {
                     System.out.println("Exiting... ");
                     go = false;
                     selected = true;
                  } // end of if else
               
                } // end of if else

              } // end of selected
               
           } // if else
           
        } // end of while go 
         
   } // end of editDay
   
   
   // searches for a day and returns the array schedule
   public static void searchDay(DailyPlanner planner) {
   
      Scanner input = new Scanner(System.in);
      
      // variables
      String date = "";
      boolean exists = false;
      boolean repeat = true;
      String another = "";
      String[] dayArray = null;
      int print = 0;
      
      // repeats until want to exit
      while(repeat == true) {
         
         // asks for date
         System.out.println();
         System.out.print("Enter the date here(##/##/###): ");
         date = input.next();   
         
         // checks if this date exists
         exists = planner.dayExist(date);
         
         // if it does not exist
         if(exists == false) {
            
            // asks if the user wants ot enter another date
            System.out.println("Date entered does not exist.");
            System.out.print("Would you like to enter another date?"); 
            another = input.next();
            another = another.toLowerCase();
            another = another.substring(0,1);
            
            // if yes repeat
            if(another.equals("y")) {
               repeat = true;
               System.out.println();
            }
            // exit
            else {
               System.out.println();
               repeat = false;
               print = 1;
            } // end of if else
         }
         
         // pulls the schedule from the node
        else {
            
            // returns the arreay of the date chosen
            dayArray = planner.returnDay(date);
            repeat = false;
            
         } // end of if else

      }
      
      // if it exists then print the date
      if(print == 0) {
      
         // prints date
         System.out.println();
         System.out.println("Date: " + date);
         System.out.println();
         
         // for each hour loop and print
         for(int a = 0; a < 24; a++) {
            System.out.println(dayArray[a]);
         }
         
      } // end of if
      
      System.out.println();
   
   } // end of search day method
   
   // deletes a day
   public static void deleteDay(DailyPlanner planner) {
      
      Scanner input = new Scanner(System.in);
      
      // variables
      String deleteDate = "";
      boolean exists = false;
      String tryAgain = "";
      boolean enterAgain = true;
      
      // repeats
      while(enterAgain == true) {
         
         // asks for the user date they want deleted
         System.out.println();
         System.out.print("Enter the date you would like to delete (##/##/###): ");
         deleteDate = input.next();
         
         // checks if the planner exists
         exists = planner.dayExist(deleteDate);
         
         // if it does not exist
         if(exists == false) {
            System.out.println();
            System.out.println("Error: date does not exists");
            boolean repeat = true;
            
            // checks if they want to enter antoher day
            while(repeat == true) {
            
               System.out.print("Would you like to enter another date? ");
               
               tryAgain = input.next();
               tryAgain = tryAgain.toLowerCase();
               tryAgain = tryAgain.substring(0,1);
               System.out.println();
               
               // if yes then repeat
               if(tryAgain.equals("y")) {
                  repeat = false;
                  enterAgain = true;
                  
               }
               
               // exits
               else if (tryAgain.equals("n")) {
                  
                  System.out.println("Exiting delete contact, no contact deleted");
                  enterAgain = false;
                  repeat = false;
                  return;
               }
               
               // error
               else {
                  System.out.println("Error: enter (y)es or (n)o");
                  repeat = true;
               } // end of if else
               
            } // end of while loop
         }
         
         else {
            enterAgain = false;
         } // end of if else

      } // end of enter again while loop
      
      // deletes date in planner
      planner.delete(deleteDate);
      System.out.println("Date and it's information deleted...");
      System.out.println();
      
   } // end of delete method
   
   
   // creates the array of the hours
   public static String[] createHourlyArray(int hour, String[] hourly) {
      
      // ends after it reaches end of array
      if(hour == 25) {
         
         return hourly;
      }
      
      // creates array input
      hourly[hour-1] = hour + ":" + "00";
      hour++;
      
      // recurs
      createHourlyArray(hour, hourly);
      return hourly; // returns array
      
   } // end of create hourly array
   
   // creates a new node
   public static void createDayNode(DailyPlanner planner) {
   
      Scanner input = new Scanner(System.in);
      
      // variables
      String date = "";
      String day = "";
      String year = "";
      String month = "";
      boolean entered = false;
      boolean wrongDate = true;
      String answer = "";
      int delete;
      
      // repeats 
      while(wrongDate == true) {
         
         // repeats if date entered is in wrong format
         while(entered == false) {
            System.out.println("Enter the date you want to add below(##/##/####): ");
            System.out.print("Day(##): ");
            day = input.next();
            System.out.print("Month(##): ");
            month = input.next();
            System.out.print("Year(####): ");
            year = input.next();
            System.out.println();
            
            // checks the day month and year are in the right format
            if(day.length() > 2 || day.length() < 1 || month.length() < 1 || month.length() > 2 || year.length() != 4){
            
               System.out.println("Error: Enter date in the format as (##/##/####) ");
               System.out.println();
               
            }
            
            else {
               entered = true;
            } // end of if else
            
         } // end of input while loop
         
         // creates the date
         date = day + "/" + month + "/" + year; 
         
         // checks if this is the date they want
         System.out.println("Date: " + date);
         System.out.print("Is this date correct? (y)es or (n)o: ");
         answer = input.next();
         answer = answer.toLowerCase();
         answer = answer.substring(0,1);
         
         // if right then continue
         if(answer.equals("y")) {
            wrongDate = false;
         }
         
         // wrong then repeat
         else {
            wrongDate = true;
            entered = false;
            System.out.println("Deleted date, enter again");
            System.out.println();
         
         } // end of if else
         
      } // end of wrong date looop
      
      // checks if this date exists as a listnode
      boolean doesExist = planner.dayExist(date);
      
      // if it exists already ask if they want to replace it
      if(doesExist == true) {
         System.out.println();
         System.out.println("The date entered already exists");
         System.out.println("would you like to replace the old one?");
         System.out.print("Enter (1) to delete and replace, Enter (0) to exit: ");
         delete = input.nextInt();
         
         // if delete then delete old day and continues
         if(delete == 1) {
            planner.delete(date);
            System.out.println("Deleting old day");
         }
         
         // if not exit
         else {
            System.out.println("Exiting... ");
            return;
         } // end of if else
         
      } // end of does exist = true
      
      System.out.println();
      
      // creates new array
      String[] hourly = new String[24]; // empty array
      String[] array = createHourlyArray(1, hourly); // new hourly array
      hourly = takeHourlySchedule(1, array, date); // takes schedule
      ListNode newDay = new ListNode(date, hourly); // creates new day node
      
      planner.addDay(newDay); // adds a new day
      System.out.println();
      System.out.println("New day added successfuly!");
      System.out.println();
   
   } // end of create new day node
   
   // takes the hourly schedules
   public static String[] takeHourlySchedule(int hour, String[] hourly, String date) {
      
      Scanner input = new Scanner(System.in);
      
      // variables
      String newInput = "";
      String note = "";
      
      // if hour is 0 print the instructions
      if(hour == 0) {
         System.out.println("Enter Plans you have in each hour");
         System.out.println("If you have no plans at this hour, leave it empty");
         System.out.println("You will be able to go back and change");
         System.out.println("if you wish.");
         System.out.println();
         System.out.println();
         System.out.println("Day: " + date);
         System.out.println();
         hour++;
      }
      
      // at the end return
      if(hour == 25) {
         return hourly;
      }
      
      // prints the hour and gets the users schedule for that hour
      System.out.print("[" + hourly[hour-1] + "] ");
      note = input.nextLine(); 
      note = note.toLowerCase();
      
      // if empty add nothing
      if(note.equals("")) {
         newInput = hourly[hour-1];
      }
      
      // else add the note
      else {
         newInput = hourly[hour-1] + "  " + note;
      }
      
      // applies new input
      hourly[hour-1] = newInput;
      
      hour++;
      
      // recurs for each hour
      takeHourlySchedule(hour, hourly, date);
      
      return hourly;
   } // end of take hourly schedule method
   
   /*public static boolean exists(String date, DailyPlanner planner) {
   
      boolean exists = planner.dayExist(date);
      return exists;
   
   }*/


} // end of list node

