//Wyatt Chrisman CS110
//Create Driver to display game propperly

import java.util.Random;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Driver
{
   //create static array list that contains moves taken to validate user, size 100 for all cells possible
   public static ArrayList<String> alreadyTaken = new ArrayList<String>(100);
   
   public static void main(String[] args) throws IOException
   {
      System.out.println("Welcome to battleship!\n");
      
      //create random
      Random rand = new Random();
      
      //get random number 0 or 1 for whoever goes first
      int whoFirst = rand.nextInt(2);
      
            
      //Create scanner and get users head or tails
      System.out.println("Flipping a coin to decide who goes first. ");
      Scanner keyboard = new Scanner(System.in);
           
      //set if user is first to true or false depensing on the random number
      boolean userFirst;
      if(whoFirst == 0)
      {
         userFirst = true;
         System.out.println();
         System.out.println("Congrats! You won the coin toss.  You will move first.\n");
      }   
      else
      {
         System.out.println("Computer has won coin toss. You will move second.");
         userFirst = false;
      }  
         
      //create the game
      Game game = new Game();
      
      //while loop that continues until computer or player is defeated
      while(!game.computerDefeated() || !game.userDefeated())
      {
         //if statement that allows the user to go first
         if(userFirst == true)
         {
            //print blank boards
            System.out.println(game);
            System.out.print("Your move: ");
            
            //take in user cell and set to uppercase
            String userMove = keyboard.nextLine();
            userMove = userMove.toUpperCase();
            
            //blank line for spacing
            System.out.println();
            
            //arraylist of all possible moves for validation purposes
            ArrayList<String> possibleMoves = new ArrayList<String>(Arrays.asList("A1","A2","A3","A4","A5","A6","A7","A8","A9","A10",
                                                                                  "B1","B2","B3","B4","B5","B6","B7","B8","B9","B10",
                                                                                  "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10",
                                                                                  "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10",
                                                                                  "E1","E2","E3","E4","E5","E6","E7","E8","E9","E10",
                                                                                  "F1","F2","F3","F4","F5","F6","F7","F8","F9","F10",
                                                                                  "G1","G2","G3","G4","G5","G6","G7","G8","G9","G10",
                                                                                  "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10",
                                                                                  "I1","I2","I3","I4","I5","I6","I7","I8","I9","I10",
                                                                                  "J1","J2","J3","J4","J5","J6","J7","J8","J9","J10"));
            
            //while loop that validates users input to be in the possible moves array
            while(!possibleMoves.contains(userMove))
            {
               System.out.println("This move is not valid, please enter a valid cell: ");
               userMove = keyboard.nextLine();
               userMove = userMove.toUpperCase();
            }
            
            //while loop to validate if user move has already been made
            while(alreadyTaken.contains(userMove))
            {
               System.out.println("This move has already been made.  Make another move.");
               userMove =  keyboard.nextLine();
               userMove = userMove.toUpperCase();
            }
            //add move to the list of moves made
            alreadyTaken.add(userMove);
            
            //create the move with the validated string and make move
            Move m = new Move(userMove);
            game.makePlayerMove(userMove);
            
            //print out updated board
            System.out.println(game);
            
            //checks if user has won the game and displays winning sentence if they have won and exits program
            if(game.computerDefeated())
            {
               System.out.println(game);
               System.out.println("CONGRATS!! You have won!!");
               System.exit(1);
            }
            
            //Tells user that it is the computers turn and has them input anything to pass
            System.out.println("Computer's turn. Press any key to continue.");
            String pass = keyboard.nextLine();
            
            //list that takes in result of computer move
            String[] computerMove = game.makeComputerMove();
            
            //prints computer's move
            System.out.println(computerMove[0]);
            
            //if a ship is sunk, it is printed
            if(computerMove[1] != null)
               System.out.println(computerMove[1]);
               
            //checks if user has been defeated, prints statement, and exits program
            if(game.userDefeated())
            {
               System.out.println(game);
               System.out.println("OH NO!! Computer has won!");
               System.exit(1);
            }
            
            
         }
         
         //if statement for if the computer is first
         if(userFirst == false)
         {
            //prints game in current state
            System.out.println(game);
            
            //prints that it is the computers move and to enter any key
            System.out.println("Computer's turn. Press any key to continue.");
            String pass = keyboard.nextLine();
            
            //takes in computers move and result of move if a ship is sunk and prints
            String[] computerMove = game.makeComputerMove();
            System.out.println(computerMove[0]);
            if(computerMove[1] != null)
               System.out.println(computerMove[1]);
               
            //validates if user has lost
            if(game.userDefeated())
            {
               System.out.println(game);
               System.out.println("OH NO!! Computer has won!");
               System.exit(1);
            }

   
            //prints game after user move
            System.out.println(game);
            
            //takes in players move
            System.out.print("Your move: ");
            String userMove = keyboard.nextLine();
            userMove = userMove.toUpperCase();
            System.out.println();
            
            //validates if the move has already been made
            while(alreadyTaken.contains(userMove))
            {
               System.out.println("This move has already been made.  Make another move.");
               userMove =  keyboard.nextLine();
               userMove = userMove.toUpperCase();
            }
            alreadyTaken.add(userMove);
            
            //same array list for validating cell
            ArrayList<String> possibleMoves = new ArrayList<String>(Arrays.asList("A1","A2","A3","A4","A5","A6","A7","A8","A9","A10",
                                                                                  "B1","B2","B3","B4","B5","B6","B7","B8","B9","B10",
                                                                                  "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10",
                                                                                  "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10",
                                                                                  "E1","E2","E3","E4","E5","E6","E7","E8","E9","E10",
                                                                                  "F1","F2","F3","F4","F5","F6","F7","F8","F9","F10",
                                                                                  "G1","G2","G3","G4","G5","G6","G7","G8","G9","G10",
                                                                                  "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10",
                                                                                  "I1","I2","I3","I4","I5","I6","I7","I8","I9","I10",
                                                                                  "J1","J2","J3","J4","J5","J6","J7","J8","J9","J10"));
            
            //validates that cell exists
            while(!possibleMoves.contains(userMove))
            {
               System.out.println("This move is not valid, please enter a valid cell: ");
               userMove = keyboard.nextLine();
               userMove = userMove.toUpperCase();
            }
            
            //makes new move
            Move m = new Move(userMove);
            
            //makes move
            game.makePlayerMove(userMove);
            
            //validates if computer has lost
            if(game.computerDefeated())
            {
               System.out.println(game);
               System.out.println("CONGRATS!! You have won!!");
               System.exit(1);
            }
         }
      }     
   }
}