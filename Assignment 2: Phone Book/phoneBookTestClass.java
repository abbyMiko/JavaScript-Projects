/*
Programmer: Abbigail Farr
DateL: 4/24/2023
Class: CS& 145
Assignment: Phone Book
Purpose: obtains information from user, displays information that is stored 
Extra credit: under update and view, different search options
*/

import java.io.*;    // for File
import java.util.*;  // for Scanner
import java.util.Scanner;
import java.util.Random;

public class phoneBookTestClass {
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
         
       // variables
       String command = "";         // holds command input
       String firstName = "";       // contact info
       String lastName = "";        // contact info
       String address = "";         // contact info
       String cityState = "";       // contact info
       String city = "";            // contact info
       String state = "";           // contact info
       String phoneNumber = "";     // contact info
       int contactOrder = 1;        // hold info on order contacts were added(changes)
       boolean commandInput = false;// repeats if selection for command is wrong
       String enterView = "";       // to remove or view first
       String fullList = "";        // to view full list of contacts
       String again = "";           // holds whether user wants to Y repeat or N
       boolean inCommandInput;      // repeats to main menu (the beginning)
       boolean exit = false;        // loops for the entire main method

       phoneBookManager contactList = new phoneBookManager(); // creates a contactList object
       
       // repeats all the way to the user menu options
       while(exit == false) {
          
          inCommandInput = false; // defines in command within the exit loop
          
          // repeats while theinput is false
          while(commandInput == false) {
               System.out.println();
               System.out.println();
               
                //displays menu options
                System.out.println("Please choose from the following options: ");
                System.out.println("(A)dd new contact");
                System.out.println("(R)emove contact");
                System.out.println("(U)pdate contact");
                System.out.println("(V)iew contacts");
                System.out.println("(E)xit contacts");
                System.out.println();
                System.out.print("Enter here: ");
                command = input.next();
                command = command.substring(0,1); // first letter
                command = command.toLowerCase(); // to lowercase
                
                // adds a new contact 
                if(command.equals("a")) {
                     inCommandInput = false; //keep looping
                     exit = false;  // keep loop entire
                     contactOrder = contactList.returnContactOrder();
                     addIt(contactList, contactOrder);   // add
                     
                     // repeats when input is not Y or N to add another
                     while(inCommandInput == false) {
                        System.out.println();
                        System.out.print("Would you like to add another contact? (Y)es or (N)o "); // repeat?
                        again = input.next();
                        again = again.substring(0,1);
                        again = again.toLowerCase();
                        
                        // if they want to repeat, repeat
                        if(again.equals("y")) {
                           inCommandInput = false; // don't exit yet
                           contactOrder = contactList.returnContactOrder();
                           addIt(contactList, contactOrder); // add

                        }
                        
                        //exit
                        else if(again.equals("n")){
                           inCommandInput = true;  // don't repeat
                           System.out.println();
                           System.out.println("Exiting add contacts... ");
                        }
                        
                        // wrong input
                        else {
                           inCommandInput = false; // repeat
                           System.out.println("Error: enter (Y)es or (N)o");
                        
                        } // end of if else input loop
                        
                     } // end of command input while loop
                     
   
                }
                
                // to remove a contact
                else if(command.equals("r")) {
  
                    exit = false;   // don't exit loop
                    inCommandInput = false;
                    removeIt(contactList); // remove the contact with method
                    
                    // wrong input
                    while(inCommandInput == false) {
                        System.out.println();
                        // asks user what they want to do
                        System.out.print("Would you like to remove another contact? (Y)es or (N)o ");
                        again = input.next();
                        again = again.substring(0,1);
                        again = again.toLowerCase();
                        
                        // remove
                        if(again.equals("y")) {
                           inCommandInput = false; // repeat
                           removeIt(contactList);  // remove again
                        }
                        
                        // not remove exit
                        else if(again.equals("n")){
                           inCommandInput = true;  // exit
                           System.out.println();
                           System.out.println("Exiting remove contacts... ");
                        }
                        
                        // wrong input
                        else {
                           inCommandInput = false;
                           System.out.println("Error: enter (Y)es or (N)o");
                        
                        } // end of if else input loop
                        
                     } // end of command input while loop
   
                }
                
                // updates contacts
                else if(command.equals("u")) {
                     
                     exit = false;  // loops
                     inCommandInput = false;
                     System.out.println();
                     updateIt(contactList);  // update method
                     
                     // checking if the user wants to repeat the action from this command
                     while(inCommandInput == false) {
                        System.out.println();
                        System.out.print("Would you like to change another contacts information? (Y)es or (N)o ");
                        again = input.next();
                        again = again.substring(0,1);
                        again = again.toLowerCase();
                        
                        // if the want to change repeat
                        if(again.equals("y")) {
                           inCommandInput = false; // repeats
                           updateIt(contactList);
                        }
                        
                        // exits if they don't
                        else if(again.equals("n")){
                           inCommandInput = true;  // exits
                           System.out.println();
                           System.out.println("Exiting update contacts... ");
                        }
                        
                        // if what was entered by the user was not an option
                        else {
                           inCommandInput = false; // repeats
                           System.out.println("Error: enter (Y)es or (N)o");
                        
                        } // end of if else input loop
                        
                     } // end of command input while loop
                } // end of update
                
                // views contacts 
                else if(command.equals("v")) {

                     exit = false;  // repeat loop
                     inCommandInput = false;
                     System.out.println();
                     viewIt(contactList); // displaying contacts
                     
                     // while wrong input Y or N
                     while(inCommandInput == false) {
                        System.out.println();
                        // users choice of what to do now
                        System.out.print("Would you like to view contacts again? (Y)es or (N)o ");
                        again = input.next();
                        again = again.substring(0,1);
                        again = again.toLowerCase();
                        
                        // repeats
                        if(again.equals("y")) {
                           inCommandInput = false; // repeat
                           viewIt(contactList); // views again
                        }
                        
                        // exits
                        else if(again.equals("n")){
                           inCommandInput = true;  // exit
                           System.out.println();
                           System.out.println("Exiting view contacts... ");
                        }
                        
                        // wrong input
                        else {
                           inCommandInput = false; //repeat
                           System.out.println("Error: enter (Y)es or (N)o");
                        
                        } // end of if else input loop
                        
                     } // end of command input while loop
                }
                
                // exits contacts
                else if(command.equals("e")) {
                  commandInput = true; // exit loop
                  exit = true;   //exit loop
                  System.out.println();
                  System.out.println("Exiting contacts... ");
                
                }
                
                // wrong input
                else {
                   commandInput = false;  // repeats
                   exit = false;    // repeats
                   System.out.println("Error: input incorrect please try again... ");
                } // end of if else statement for user menu
                
            } // end of commandInput while loop
         } // exit while loop
      } // end of main method 
      
      // updates the contact list
      public static void updateIt(phoneBookManager contactList) {
         Scanner input = new Scanner(System.in);
         
         // variables
         int viewEnter = 0;               // holds user input for what contact they will view
         boolean fullRepeat = true;       // loops for entire method
         boolean viewOver = true;         // continues from viewing the lisdt to entering
         String fullList = "";            // holds string of entire list of contacts
         String contactExist = "";        // holds if the contact is null or has been created and filled
         int change = 0;                  // holds what the user wants to change
         boolean enterNum = false;        // when the choice entered for change loops
         
         // below is the information that is entered to update the contacts
         String firstName = "";  
         String lastName = "";
         String address = "";
         String cityState = "";
         String city = "";
         String state = "";
         String phoneNumber = "";
         
         // repeats for the entire loop
         while(fullRepeat == true) {
         
            // instructions, warning and has user enter what they want todo
            System.out.println("Enter the contact number assigned to the contact you would like to change");
            System.out.println();
            System.out.print("WARNING: Contact number is the number assigned to the contact (in the order it was added). ");
            System.out.println("It is NOT the phone number");
            System.out.println("It is labeled on the top of the contact in the format 'Contact # Information' (#)");
            System.out.println();
            System.out.println("If you do not know the contact number, type 0 to view the full list of contacts");
            System.out.print("Enter here: ");
            viewEnter = input.nextInt();
            System.out.println();
            
            
            // if they want to view the list
            if(viewEnter == 0) {
               
               fullList = contactList.getContacts(); // creates string of full list of contacts
               System.out.println(fullList); // prints string of contacts
               System.out.println();
               System.out.print("Enter the contact number assigned to the contact you would like to change: ");
               viewEnter = input.nextInt();
               viewOver = true;  // will continue to search by contact num
               
            }
            
            // if entered correctly (or if the list was just displayed)
            if(viewEnter != 0 && viewOver == true) {
               
               // search by contact num and returns the contact
               contactExist = contactList.contactByContactNum(viewEnter);  
               
               // if there were no entries
               if(contactExist == null) {
                  fullRepeat = true; // repeat again
                  System.out.println();
               }
               
               //when contact list exists with entries
               else {
                  fullRepeat = false; // exit after this
                  System.out.println();
                  System.out.println(contactExist); // prints the contact you are changing 
                  System.out.println();
                  
                  // while the enter numbered is not in the rant keep repeating 
                  while(enterNum == false) {
                  
                     // displays an option screen for what the user would like to change
                     System.out.println("Choose one of the following options that you would like to change: (1-5)");
                     System.out.println("(1) Change full name");
                     System.out.println("(2) Change address");
                     System.out.println("(3) Change location");
                     System.out.println("(4) Change phone number");
                     System.out.println("(5) Change entire contact information");
                     System.out.println();
                     System.out.print("Select the number associated with the change you would like to make: ");
                     change = input.nextInt();
                     
                     // if the number is out of range
                     if(change > 5 || change < 1) {
                        System.out.println("Error: select a number 1-5");
                        enterNum = false; // number entered does not exist
                     }
                     
                     // if the number was in the 1-5 range
                     else {
                        enterNum = true; // number exists
                        
                        // change full name
                        if(change == 1) {
                        
                           // takes in new information for the contact
                           System.out.println();
                           System.out.println("Enter new contact information below");
                           System.out.print("First name: ");
                           firstName = input.next();
                           System.out.print("Last name: ");
                           lastName = input.next();
                           
                           contactList.updateName(firstName, lastName, viewEnter); // updates the contact name
                           System.out.println("Contact Information updated");
                                                  
                        } // end of 1
                        
                        // change address
                        if(change == 2) {
                        
                           // takes in new information for the contact
                           System.out.println();
                           System.out.println("Enter new contact information below");
                           System.out.print("Address: ");
                           input.nextLine();
                           address = input.nextLine();
                           
                           contactList.updateAddress(address, viewEnter); // updates the contact address
                           System.out.println("Contact Information updated");
                           
                        } // end of 2
                        
                        // change location
                        if(change == 3) {
                        
                           // takes in new information for the contact
                           System.out.println();
                           System.out.println("Enter new contact information below");
                           System.out.print("City: ");
                           city = input.next();
                           System.out.print("State: ");
                           state = input.next();
                           cityState = city + ", " + state;
                           
                           contactList.updateLocation(cityState, viewEnter); // updates the contact location
                           System.out.println("Contact Information updated");
                        
                        } // end of 3
                        
                        // change phone number
                        if(change == 4) {
                        
                         // takes in new information for the contact
                           System.out.println();
                           System.out.println("Enter new contact information below");
                           System.out.print("Phone Number: ");
                           phoneNumber = input.next();
                           System.out.println();
                           
                           contactList.updatePhone(phoneNumber, viewEnter); // updates contact phone number
                           System.out.println("Contact Information updated");
                        
                        } // end of 4
                        
                        // change entire information
                        if(change == 5) {
                           
                           // takes in new information for the contact
                           System.out.println();
                           System.out.println("Enter new contact information below");
                           System.out.print("First name: ");
                           firstName = input.next();
                           System.out.print("Last name: ");
                           lastName = input.next();
                           System.out.print("Address: ");
                           input.nextLine();
                           address = input.nextLine();
                           System.out.print("City: ");
                           city = input.next();
                           System.out.print("State: ");
                           state = input.next();
                           cityState = city + ", " + state;
                           System.out.print("Phone Number: ");
                           phoneNumber = input.next();
                           System.out.println();
                           
                           contactList.updateFull(firstName, lastName, phoneNumber, viewEnter, address, cityState); // updates the contact
                           System.out.println("Contact Information updated");
                           
                        } // end of 5
                        
                        
                     } // end of else
                     
                  } // enterNum end
                  
               } // end of else
               
             } // end of if else view Enter  
          
          } // end full repeat while loop
     
      } // end of updateIt method
      
      
      // adds a new contact to the contact list
      public static void addIt(phoneBookManager contactList, int contactOrder) {
         Scanner input = new Scanner(System.in);
         
          // variables
         String firstName = "";
         String lastName = "";
         String address = "";
         String cityState = "";
         String city = "";
         String state = "";
         String phoneNumber = "";
         
         // enter information for the new contact
         System.out.println();
         System.out.println();
         System.out.println("Enter new contact information below");
         System.out.print("First name: ");
         firstName = input.nextLine();
         System.out.print("Last name: ");
         lastName = input.nextLine();
         System.out.print("Address: ");
         address = input.nextLine();
         System.out.print("City: ");
         city = input.next();
         System.out.print("State: ");
         input.nextLine();
         state = input.next();
         cityState = city + ", " + state;
         System.out.print("Phone Number: ");
         input.nextLine();
         phoneNumber = input.nextLine();
         System.out.println();
         System.out.println("New contact added successfully");
         System.out.println();
         
         // creates a new object node for the contact then adds
         ListNode newContact = new ListNode(contactOrder,firstName,lastName,address,cityState,phoneNumber); 
         contactList.add(newContact);
                  
      } // end of add it method
      
      
      // method to view the contacts 
      public static void viewIt(phoneBookManager contactList) {
         Scanner input = new Scanner(System.in);
         
         //variables
         String viewType = "";            // hold answer for whether they want to look up or view full list
         String fullList = "";            // displays string of entire contact list
         int lookUp = 0;                  // look up style
         boolean entered = false;         // for looping under look up style
         String fullContact = "";         // holds entire contact if looking up one
         String tryAgain = "";            // if entered wrong holds if they want to try again
         boolean tryInput = false;        // loop if they want to try again
         boolean enterAgain = false;      // loop to enter look up value again
         boolean fullRestart = false;     // restarts entire program
         
         // below are the contact variables
         String firstName = "";
         String lastName = "";
         String phoneNumber = "";
         String city = "";
         String state = "";
         String location = "";
         int contactNum = 0;
         
         // loops if the person needs to start from the first options
         while(fullRestart == false) {
            
             
            entered = false; // will re enter the loop for change
            
            // determining how they want to view the contacts
            System.out.println();
            System.out.print("Would you like to view the full list of contacts or look up one? (F)ull or (L)ook: ");
            viewType = input.next();
            System.out.println();
            System.out.println();
            viewType = viewType.substring(0,1); // first letter
            viewType = viewType.toLowerCase(); // to lowercase
            
            // view full list
            if(viewType.equals("f")) {
               
               fullRestart = true; // exits since the input existed
               fullList = contactList.getContacts(); // creates string of full list of contacts
               System.out.println(fullList); // prints string of contacts
               
            }
            
            // if the user wants to look up a value 
            else if(viewType.equals("l")) {
               
               fullRestart = true; // will automatically exit since they typed in an existing value
               
               // repeates while the entered style value is wrong
               while(entered == false) {
               
                  enterAgain = false;// will re enter the loops for looking up a value
                  
                  // displays options of how to look up a person in the contacts
                  System.out.println();
                  System.out.println();
                  System.out.println("Choose your look up style below: ");
                  System.out.println("(1) - Look up by first name");
                  System.out.println("(2) - Look up by last name");
                  System.out.println("(3) - Look up by phone number");
                  System.out.println("(4) - Look up by location (City, State)");
                  System.out.println("(5) - Look up by contact number (not phone number)");
                  System.out.println();
                  
                  // prompts the user to choose from one of the styles listed
                  System.out.print("Enter the number associated with your desired look up style (1-5): ");
                  lookUp = input.nextInt();
                  System.out.println();
                  
                  // if the value is not one of the options
                  if(lookUp < 1 || lookUp > 5) {
                  
                     System.out.println("Error: select a number 1-5");
                     entered = false; // repeat because out of bounds
                     
                  }
                  
                  // if value is correctly selected
                  else {
                  
                     entered = true; // values entered exists no need to repeat
                     
                     // look up by first name 
                     if(lookUp == 1) {
                        
                        // if they do not want to enter another name when wrong
                        while(enterAgain == false) {  
                           System.out.println(); 
                           System.out.print("Please enter the first name of the contact you would like to view: ");
                           firstName = input.next();
                           fullContact = contactList.contactByFName(firstName); // calls method to search for the name in the contacts
                           System.out.println();
                           
                           // if the contact exists
                           if(fullContact != null) {
                                 enterAgain = true; // exit loop
                                 System.out.print(fullContact); // print contact
                           } // end of if else
                           
                           // contact does not exist  
                           else {
                              System.out.println("Error: name entered does not exist");
                              
                              // while try again input is false
                              while(tryInput == false){
                                 System.out.println();
                                 System.out.print("Would you like to try again? (Y)es or (N)o: ");
                                 
                                 // prompts user to decide whether they want to enter the name again or exit
                                 tryAgain = input.next();
                                 tryAgain = tryAgain.substring(0,1); // first letter
                                 tryAgain = tryAgain.toLowerCase(); // to lowercase
                                 
                                 // repeat typing in the name again
                                 if(tryAgain.equals("y")) {
                                    tryInput = true; // entered y or n
                                    enterAgain = false; // can enter the name again from that loop
                                    
                                 }
                                 
                                 // leaves the look up method
                                 else if(tryAgain.equals("n")) {
                                     tryInput = true; // entered y or n
                                     enterAgain = true; // will not enter name again exits loop
                                 }
                                 
                                 // error
                                 else {
                                    tryInput = false; // do not exit inner loop
                                    System.out.println("Error: select (Y)es or (N)o");
                                 } // end of tryInput if else
                                 
                               } // end of tryInput while loop
                               
                             } // end of full contact is null if else

                           } // end of enter again while loop
                           
                        } // end of if look up 1
                        
                        
                        // look up by last name
                        else if(lookUp == 2) {
                        
                           // while they want to try and enter again when wrong
                           while(enterAgain == false) {  
                           
                              // asks for the last name to search 
                              System.out.println();
                              System.out.print("Please enter the last name of the contact you would like to view: ");
                              lastName = input.next();
                              
                              fullContact = contactList.contactByLName(lastName); // calls method to search for the name int he contacts
                              System.out.println();
                              
                              // if list is empty
                              if(fullContact == null) {
                                 System.out.println("Error: name entered does not exist");
                                 
                                 // while try again input is false
                                 while(tryInput == false){
                                    System.out.println();
                                    System.out.print("Would you like to try again? (Y)es or (N)o: ");
                                    
                                    tryAgain = input.next();
                                    tryAgain = tryAgain.substring(0,1); // first letter
                                    tryAgain = tryAgain.toLowerCase(); // to lowercase
                                    
                                    // repeat typing in the name again
                                    if(tryAgain.equals("y")) {
                                       tryInput = true; // correct input
                                       enterAgain = false;  // loops
                                       
                                    }
                                    
                                    // leaves the look up method
                                    else if(tryAgain.equals("n")) {
                                        tryInput = true; // correct input
                                        enterAgain = true;  // does not loop
                                    }
                                    
                                    // error
                                    else {
                                       tryInput = false; // loops, wrong input
                                       System.out.println("Error: select (Y)es or (N)o");
                                    }  // end of yes no if else 
                                    
                                  } // end of tryInput while loop
                                  
                                } // end of full contact is null
                                
                                // if contact exists
                                else {
                                    enterAgain = true; // exit loop
                                    System.out.print(fullContact); // print contact
                                } // end of if else
      
                             } // end of enter again while loop
                             
                        } // end of look up 2
                        
                        // look up by phone number
                        else if(lookUp == 3) {
                        
                           // while user is inputing info still
                           while(enterAgain == false) {  
                           
                              // gathers contact phone info
                              System.out.println(); 
                              System.out.print("Please enter the phone number of the contact you would like to view: ");
                              phoneNumber = input.next();
                              
                              // gets contact
                              fullContact = contactList.contactByPhone(phoneNumber); // calls method to search for the name int he contacts
                              System.out.println();
                              
                              // if empty
                              if(fullContact == null) {
                                 System.out.println();
                                 System.out.println("Error: phone number entered does not exist");
                                 
                                 // while try again input is false
                                 while(tryInput == false){
                                    System.out.println();
                                    System.out.print("Would you like to try again? (Y)es or (N)o: ");
                                    
                                    tryAgain = input.next();
                                    tryAgain = tryAgain.substring(0,1); // first letter
                                    tryAgain = tryAgain.toLowerCase(); // to lowercase
                                    
                                    // repeat typing in the name again
                                    if(tryAgain.equals("y")) {
                                       tryInput = true;  // correct input
                                       enterAgain = false;  // loops
                                       
                                    }
                                    
                                    // leaves the look up method
                                    else if(tryAgain.equals("n")) {
                                        tryInput = true; // correct input
                                        enterAgain = true;  // does not loop
                                    }
                                    
                                    // error
                                    else {
                                       tryInput = false; // inner loop, wrong input
                                       System.out.println("Error: select (Y)es or (N)o");
                                    } // end of y or n if/else
                                    
                                  } // end of tryInput while loop
                                  
                                } // end of full contact is null
                                
                                // if exists
                                else {
                                    enterAgain = true; // exit loop
                                    System.out.print(fullContact); // print contact
                                } // end of if else
      
                             } // end of enter again while loop
   
                        } // end of look up 3
                        
                        // look up by location
                        else if(lookUp == 4) {
                           
                           // while user is still entering info loop
                           while(enterAgain == false) { 
                           
                                 // gets user location information 
                                 System.out.println(); 
                                 System.out.println("Please enter the city and state of the contact you would like to view: ");
                                 System.out.print("City: ");
                                 city = input.next();
                                 System.out.print("State: ");
                                 state = input.next();
                                 location = city + ", " + state;
                                 
                                 // searches
                                 fullContact = contactList.contactByLocation(location); // calls method to search for the name int he contacts
                                 System.out.println();
                                 
                                 // if list is empty
                                 if(fullContact == null) {
                                    System.out.println("Error: location entered does not exist");
                                    
                                    // while try again input is false
                                    while(tryInput == false){
                                       System.out.println();
                                       System.out.print("Would you like to try again? (Y)es or (N)o: ");
                                       
                                       tryAgain = input.next();
                                       tryAgain = tryAgain.substring(0,1); // first letter
                                       tryAgain = tryAgain.toLowerCase(); // to lowercase
                                       
                                       // repeat typing in the name again
                                       if(tryAgain.equals("y")) {
                                          tryInput = true;  // correct input
                                          enterAgain = false;  // loops
                                          
                                       }
                                       
                                       // leaves the look up method
                                       else if(tryAgain.equals("n")) {
                                           tryInput = true; // correct input
                                           enterAgain = true; // exits loop
                                       }
                                       
                                       // error
                                       else {
                                          tryInput = false; // inner loop, wrong input
                                          System.out.println("Error: select (Y)es or (N)o");
                                       }  // end of Y or N if else statements
                                       
                                     } // end of tryInput while loop
                                     
                                   } // end of full contact is null
                                   
                                   // if contact is filled and exists
                                   else {
                                       enterAgain = true; // exit loop
                                       System.out.print(fullContact); // print contact
                                   } // end of if else
         
                             } // end of enter again while loop
                        
                        } // end of look up 4
                        
                        // look up by contact number
                        else if(lookUp == 5) {
                           
                           // loops while user is still inputing information
                           while(enterAgain == false) { 
                           
                                 // gathers user information contact number or asks if they want to view list
                                 System.out.println();  
                                 System.out.print("Please enter the contact number (not phone number) of the contact you would like to view: ");
                                 contactNum = input.nextInt();
                                 
                                 fullContact = contactList.contactByContactNum(contactNum); // calls method to search for the name int he contacts
                                 System.out.println();
                                 
                                 // if contact is empty
                                 if(fullContact == null) {
                                    System.out.println("Error: contact number entered does not exist");
                                    
                                    // while try again input is false
                                    while(tryInput == false){
                                       System.out.println();
                                       System.out.print("Would you like to try again? (Y)es or (N)o: ");
                                       
                                       tryAgain = input.next();
                                       tryAgain = tryAgain.substring(0,1); // first letter
                                       tryAgain = tryAgain.toLowerCase(); // to lowercase
                                       
                                       // repeat typing in the name again
                                       if(tryAgain.equals("y")) {
                                          tryInput = true;  // correct input
                                          enterAgain = false;  // loops
                                          
                                       }
                                       
                                       // leaves the look up method
                                       else if(tryAgain.equals("n")) {
                                           tryInput = true; // correct input
                                           enterAgain = true;  // exits loop
                                       }
                                       
                                       // error
                                       else {
                                          tryInput = false;
                                          System.out.println("Error: select (Y)es or (N)o");
                                       }  // end of y or n if else statements
                                       
                                     } // end of tryInput while loop
                                     
                                   } // end of full contact is null
                                   
                                   else {
                                       enterAgain = true; // exit loop
                                       System.out.print(fullContact); // print contact
                                   } // end of if else
         
                             } // end of enter again while loop
                        
                        } // end of look up 5 and all look up if else statements
                        
                      } // end of if else
                     
                 } // end entered while loo
                     
              } // view type l
              
              // if neither l or f was entered in the beginning
              else {
                  System.out.println("Error: enter (L)ook up or (F)ull list");
                  fullRestart = false; // wrong L or F input
              }   // end of l or f if statements
              
           }// end of full restart
               
     } // end of view it

     // removes a contact from the list   
     public static int removeIt(phoneBookManager contactList) {
           Scanner input = new Scanner(System.in);
           
           // variables
           String enterView = "";         // view or enter contact list
           int removeNum = 0;             // holds user input for what contact number 
           String contact = "";           // holds string of full contact
           String toRemove = "";          // holds input if htey want to delete the contact displayed
           String toRepeat = "";          // holds input if they want to repeat
           String fullList = "";          // creates string of all contacts
           boolean enter = false;         // enters from displaying contacts to entering the contact number
           boolean exit2 = false;         // loop for if the contact number entered does not exist
           boolean exit = false;          // repeats for contact information
           boolean exit3 = false;         // checks input is correct for if the contact is correct
           boolean removeExists = false;  // if the one you want to remove exists
           boolean mainExit = false;      // main while loop
           int newConNum = 0;             // represents the new number of contacts post removal
           boolean correct;
           
           // loops for the whol part
           while(mainExit == false) {
              
              enter = false;
              correct = false;
              
              // asks user if they would like to remove or needs to see the contact list first
              System.out.println();
              System.out.print("Do you know the contact number you would like to remove or would you like to view the full contact list? ");
              System.out.print("Enter here (V)iew or (E)nter number: ");
              
              // prompts uer to input choice
              enterView = input.next();
              enterView = enterView.substring(0,1); // first letter
              enterView = enterView.toLowerCase(); // to lowercase
              
              // view or enter
              if(enterView.equals("v")) {
                  fullList = contactList.getContacts(); // string of contacts
                  correct = true;
                  
                  // if list is empty
                  if(fullList == null) {
                     enter = false;
                     System.out.println("Error: contact list is empty please add contacts first");
                     System.out.println();
                     mainExit = true;
                  }
                  
                  // if list exists
                  else {
                  
                     System.out.println(fullList);
                     System.out.println();
                     enter = true;
                  
                  }
              } 
              
              // for entering
              if(enterView.equals("e") || enter == true) {
                  exit = false;
                  correct = true;
                  
                  // while the number entered is not correct repeat
                  while(exit == false) {
                     
                     // prompts user to enter contact number
                     System.out.println();
                     System.out.print("Please enter the contact number associated with the one you would like to remove: ");
                     removeNum = input.nextInt();
                     System.out.println();
                     contact = contactList.contactByContactNum(removeNum); // creates a string of the contact
                     
                     // if they are the same then it exists
                     if(contact == null) {
                        
                        exit2 = false;
                        
                        // if the user does not enter Y or N for repeat question
                        while(exit2 == false) {
                           
                           // asks user if they want to try and enter the number again
                           System.out.print("Error: would you like to enter again? (Y)es or (N)o: ");
                           toRepeat = input.next();
                           toRepeat = toRepeat.substring(0,1); // first letter
                           toRepeat = toRepeat.toLowerCase(); // to lowercase
                           System.out.println();
                           
                           // if the user wants to repeat
                           if(toRepeat.equals("y")) {
                              exit2 = true; // entered accuratly
                              exit = false; // repeat full method
                           }
                           
                           // does not want to try again
                           else if(toRepeat.equals("n")) {
                              exit2 = true; // entered accuratly
                              exit = true; // exit removing method
                           }
                           
                           // did not enter a y or n
                           else{
                              exit2 = false; // entered incorrectly asks question again
                              System.out.println("Error: select (Y)es or (N)o");
                              System.out.println();
                           } // end of toRepeat if else statements
                           
                         } // end of exit2
                        
                      } 
                     
                     // contact does exist
                     else {
                        
                        mainExit = true; // will exit the method after since it exists
                        System.out.println(contact); // prints contact
                        System.out.println();
                        
                        exit3 = false;
                        
                        // checks that question below is answered with y or n
                        while(exit3 == false) {
                           
                           // asks user if they want to delete the contact above
                           System.out.print("Is the contact above the one you would like to delete? (Y)es or (N)o: ");
                           toRemove = input.next();
                           toRemove = toRemove.substring(0,1); // first letter
                           toRemove = toRemove.toLowerCase(); // to lowercase
                           
                           // wants to delete it 
                           if(toRemove.equals("y")) {
                              exit3 = true; // entered accurately
                              exit = true; // exits full method
                              
                              contactList.updateContactOrder(removeNum); 
                              removeExists = contactList.remove(removeNum); // removes the contact
                              System.out.println("Contact removed successfully");
   
                           }
                           
                           // does not want to remove
                           else if(toRemove.equals("n")) {
                              exit3 = true; // entered accurately
                              exit = true; // exit removing method does not delete anything
                           }
                           
                           // if entere incorrectly
                           else{
                              exit2 = false; // entered wrong repeats inner loop
                              System.out.println("Error: select (Y)es or (N)o");
                              System.out.println();
                            } // end of toRemove if else statements
   
                          } // end of exit3
                     
                       } // end of if else contact exists statements
                     
                  } // end of while
              }
              
              // if entry for view or enter is wrong
             else if(correct == false) {
                  System.out.println("cow");
                  mainExit = false;
                  System.out.println("Error: select (V)iew or (E)nter number");
             } // end of if else statements for view and enter
              
           } // end of main exit while loop
           
           newConNum = contactList.returnContactOrder();
           
           return newConNum;
   
      } // end of remove it method

} // end of test class
