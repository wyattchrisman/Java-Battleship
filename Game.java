//Wyatt Chrisman CS110
//Create the game class that will facilitate the game

import java.io.*;
import java.util.Scanner;

public class Game 
{
   //create instance variables for boards
   private ComputerBoard computer;
   private UserBoard player;
   
   
   /**
   * Create constructor for game
   */
   public Game() throws IOException
   {
      //read files to the created boards
      computer = new ComputerBoard("compFleet.txt");
      player = new UserBoard("userFleet.txt");
   }
   
   /**
   * method that makes a computer move
   * @return String taken in from userBoard of move made by computer and result of the move
   */
   public String[] makeComputerMove()
   {
      String[] moveResult = player.makeComputerMove();
      return moveResult;
   }
   
   /**
   * Method that makes the move from a given string
   * @param string of move by user
   * @return the reaction of the ship
   */
   public String makePlayerMove(String s)
   {
      //create move object and apply to computer board
      Move move = new Move(s);
      String shipReaction = computer.makePlayerMove(move);
      
      //return ship reaction
      return shipReaction;
   }
   
   /**
   * @return the result of if the user was defeated
   */
   public boolean userDefeated()
   {
      return player.gameOver();
   }
   
   /**
   * @return the result of if the computer was defeated
   */
   public boolean computerDefeated()
   {
      return computer.gameOver();
   }
   
   /**
   * @reurn a string of both boards printed with the owner of each board placed above
   */
   public String toString()
   {
      return String.format("Computer Board:\n%s\nUser Board:\n%s", computer, player);
   }
   
}