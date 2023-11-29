//Wyatt Chrisman CS110 
//Create the user's board

import java.util.Random;
import java.util.ArrayList;
import java.io.*;


//will create the board for the user and all methods that apply
//allows the computer to make moves on this board
public class UserBoard extends Board
{
   //create instance variables
   private ArrayList<Move> moves;
   private Random rand = new Random();
   private final int ASCII = 65;
   private final int upperbound = 99;
   private ArrayList<String> alreadyTaken = new ArrayList<String>(upperbound);
   
   /**
   * Constructor that gives the file name to the board class
   * @param the given file name
   */
   public UserBoard(String fileName) throws IOException
   {
      super(fileName);
   }
   
   
   /**
   * Creates array that will hold a string of the user's move and another string of the result of the move
   * Result will be null unles a ship is sunk
   * @return array of both strings
   */
   public String[] makeComputerMove()
   { 
      //create array
      String[] set = new String[2];
      
      //create random move
      Move m = pickRandomMove();
      
      //create the string that has the move
      String moveSentence = "The computer chose " + m + "\n";
      
      //get result of move
      CellStatus moveResult = applyMoveToLayout(m);
      
      //blank string to add the result to 
      String response = "";
      
      //if statements for all results and their corresponding sentence
      if(moveResult == CellStatus.NOTHING)
         response = null;
      if(moveResult == CellStatus.AIRCRAFT_CARRIER_SUNK)
      {
         response = "You sank my Aircraft Carrier!";
         System.out.println("User says: You sank my Aircraft Carrier!");
      }   
      if(moveResult == CellStatus.BATTLESHIP_SUNK)
      {
         response = "You sank my Battleship!";
         System.out.println("User says: You sank my Battleship!");
      }
      if(moveResult == CellStatus.CRUISER_SUNK)
      {
         response = "You sank my Cruiser!";
         System.out.println("User says: You sank my Cruiser!");
      }
      if(moveResult == CellStatus.DESTROYER_SUNK)
      {
         response = "You sank my Destroyer!";
         System.out.println("User says: You sank my Destroyer!");
      }
      if(moveResult == CellStatus.SUB_SUNK)
      {
         response = "You sank my Submarine!";
         System.out.println("User says: You sank my Submarine!");
      }
         
      //set the values to the corresponsing spots in array
      set[0] = moveSentence;
      set[1] = response;
      
      //return the array
      return set;                                 
   }
   
   /**
   * method that will pick a random move from array of all possible moves
   * @return the move that was chosen
   */
   public Move pickRandomMove()
   {
      //array of all possible moves
      String[] possibleMoves = new String[] {"A1","A2","A3","A4","A5","A6","A7","A8","A9","A10",
                                             "B1","B2","B3","B4","B5","B6","B7","B8","B9","B10",
                                             "C1","C2","C3","C4","C5","C6","C7","C8","C9","C10",
                                             "D1","D2","D3","D4","D5","D6","D7","D8","D9","D10",
                                             "E1","E2","E3","E4","E5","E6","E7","E8","E9","E10",
                                             "F1","F2","F3","F4","F5","F6","F7","F8","F9","F10",
                                             "G1","G2","G3","G4","G5","G6","G7","G8","G9","G10",
                                             "H1","H2","H3","H4","H5","H6","H7","H8","H9","H10",
                                             "I1","I2","I3","I4","I5","I6","I7","I8","I9","I10",
                                             "J1","J2","J3","J4","J5","J6","J7","J8","J9","J10"};
       
      //create random number to pick a value in the array                                      
      int randomMoveNumber = rand.nextInt(upperbound);
      
      //get the value form the array
      String moveMadeString =  possibleMoves[randomMoveNumber];  
       
      //validate that the move has not been taken
      while(alreadyTaken.contains(moveMadeString))
      {
         randomMoveNumber = rand.nextInt(upperbound);
         moveMadeString =  possibleMoves[randomMoveNumber];
      }
      alreadyTaken.add(moveMadeString);

      //create the move object with string of move
      Move move = new Move(moveMadeString);
      
      //return the move object
      return move;                              
   }
   
   /**
   * Create a string of the user board with all correct cells 
   * @return the users board
   */
   public String toString()
   {
      //create board with numbers at the top for coordinate
      String board = "  1 2 3 4 5 6 7 8 9 10\n";
      
      //for loop to get the letter for the coordinate system
      for(int i = 0; i < getLayout().size(); i++)
      {
         //create char to set 
         char rowChar;
         
         //check which letter and apply
         if(i == 0)
            rowChar = 'A';
         else if(i == 1)
            rowChar = 'B'; 
         else if(i == 2)
            rowChar = 'C';
         else if(i == 3)
            rowChar = 'D'; 
         else if(i == 4)
            rowChar = 'E';
         else if(i == 5)
            rowChar = 'F';
         else if(i == 6)
            rowChar = 'G';
         else if(i == 7)
            rowChar = 'H';
         else if(i == 8)
            rowChar = 'I';
         else 
            rowChar = 'J';


            
         //add letter to board   
         board += rowChar;
         
         //loop to get the currrent state of the board
         for(int k = 0; k < getLayout().get(i).size(); k++)
         {
            String state = getLayout().get(i).get(k).toString();
            state = state.substring(1,2);
         
            //add to the board
            board += " " + state;
         }
         
         //add a new line character to the board at the end of each line
         board += "\n";
        
      }  
      
      //return the board
      return board;
   }
}