//Wyatt Chrisman CS110
//Create the board for the game

//import arraylist
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class Board
{
   //create instance variables
   public final int SIZE = 10;
   private final int MAX_SIZE = 15;
   private Fleet fleet = new Fleet();
   
   //bring in ascii value to edit chars
   private final int ASCII = 65;
   
   //create arraylist of cell status
   private ArrayList<ArrayList<CellStatus>> layout = new ArrayList<ArrayList<CellStatus>>(SIZE);
   
   
   public Board(String s) throws IOException 
   {
      //create all rows with size 10 and set all values to nothing
      //use letter of row as name for counter for simplicity sake
      ArrayList<CellStatus> rowA = new ArrayList<CellStatus>(SIZE);
      for(int a = 0; a < SIZE; a++)
         rowA.add(CellStatus.NOTHING);
      layout.add(rowA);  
      
      ArrayList<CellStatus> rowB = new ArrayList<CellStatus>(SIZE);
      for(int b = 0; b < SIZE; b++)
         rowB.add(CellStatus.NOTHING);
      layout.add(rowB);
      
      ArrayList<CellStatus> rowC = new ArrayList<CellStatus>(SIZE);
      for(int c = 0; c < SIZE; c++)
         rowC.add(CellStatus.NOTHING);
      layout.add(rowC);
      
      ArrayList<CellStatus> rowD = new ArrayList<CellStatus>(SIZE);
      for(int d = 0; d < SIZE; d++)
         rowD.add(CellStatus.NOTHING);
      layout.add(rowD);
      
      ArrayList<CellStatus> rowE = new ArrayList<CellStatus>(SIZE);
      for(int e = 0; e < SIZE; e++)
         rowE.add(CellStatus.NOTHING);
      layout.add(rowE);
      
      ArrayList<CellStatus> rowF = new ArrayList<CellStatus>(SIZE);
      for(int f = 0; f < SIZE; f++)
         rowF.add(CellStatus.NOTHING);
      layout.add(rowF);
      
      ArrayList<CellStatus> rowG = new ArrayList<CellStatus>(SIZE);
      for(int g = 0; g < SIZE; g++)
         rowG.add(CellStatus.NOTHING);
      layout.add(rowG);
      
      ArrayList<CellStatus> rowH = new ArrayList<CellStatus>(SIZE);
      for(int h = 0; h < SIZE; h++)
         rowH.add(CellStatus.NOTHING);
      layout.add(rowH);
      
      ArrayList<CellStatus> rowI = new ArrayList<CellStatus>(SIZE);
      for(int i = 0; i < SIZE; i++)
         rowI.add(CellStatus.NOTHING);
      layout.add(rowI);
      
      ArrayList<CellStatus> rowJ = new ArrayList<CellStatus>(SIZE);
      for(int j = 0; j < SIZE; j++)
         rowJ.add(CellStatus.NOTHING);
      layout.add(rowJ);
      
      //open file from user and add ships 
      File file = new File(s);
      Scanner sc = new Scanner(file);
      
      //create array for user moves read from file
      ArrayList<String> allMoves = new ArrayList<String>(MAX_SIZE);
      
      
      
      //read all lines from file and add to an array and then move to all text to an array list
      while(sc.hasNext())
      {
         String preSplit = sc.nextLine();
         String[] moves = preSplit.split(" ", 3);
         
         for(String z : moves)
            allMoves.add(z);
      }
      int r = 1;
      //for loop that will run 5 times (one for each ship) and p+=3 so the p in next move corresponds to the type of the ship in the array
      for(int p = 0; p < 15; p+=3)
      {
         //create all variables that are needed
         String nextMove = allMoves.get(p);
         String firstPlace;
         String lastPlace;
         String firstPlaceLetter;
         String lastPlaceLetter;
         int firstPlaceLetterASCII;
         int lastPlaceLetterASCII;
         int firstPlaceNumber;
         int lastPlaceNumber;
         int destroyerSize = 2;
         int cruiserSize = 3;
         int subSize = 3;
         int battleshipSize = 4;
         int aircraftCarrierSize = 5;
         
         
         
         //use if statements to check the first letter of the file line to determine ship type
         if(nextMove.equals("D"))
         {
            //get first and last place of the destroyer that is there
            firstPlace = allMoves.get(r);
            r++;
            lastPlace = allMoves.get(r);
            
            //add two so the next time it parses though firstPlace will be the actual first spot
            r+=2;
            
            //get the starting position of the ship into two seperate strings and ints corresponding to row and column
            firstPlace = firstPlace.toUpperCase();
            firstPlaceLetterASCII = (firstPlace.charAt(0) - ASCII);
            firstPlaceLetter = Character.toString(firstPlaceLetterASCII+ASCII);
            
            //create substring and get number
            firstPlace = firstPlace.substring(1,firstPlace.length());
            firstPlaceNumber = Integer.parseInt(firstPlace);
            
            //repeat step with ending point
            lastPlace = lastPlace.toUpperCase();
            lastPlaceLetterASCII = (lastPlace.charAt(0) - ASCII);
            lastPlaceLetter = Character.toString(lastPlaceLetterASCII+ASCII);
            
            //create substring and get last number
            lastPlace = lastPlace.substring(1,lastPlace.length());
            lastPlaceNumber = Integer.parseInt(lastPlace);
            
            //if statements to check is the ship is vertical or horizontal
            if(firstPlaceNumber == lastPlaceNumber)
            {
               //vertical ship
               for(int v = 0; v < destroyerSize; v++)
                  layout.get(firstPlaceLetterASCII + v).set(firstPlaceNumber-1, CellStatus.DESTROYER);
            }
            else
            {
               //horizontal ship
               for(int H = 0; H < destroyerSize; H++)
               {
                  layout.get(lastPlaceLetterASCII).set(firstPlaceNumber + H-1, CellStatus.DESTROYER);
               } 
            }
         }
         
         if(nextMove.equals("A"))
         {
            //get first and last place of the destroyer that is there
            firstPlace = allMoves.get(r);
            r++;
            lastPlace = allMoves.get(r);
            //add two so the next time it parses though firstPlace will be the actual first spot
            r += 2;
            
            //get the starting position of the ship into two seperate strings and ints corresponding to row and column
            firstPlace = firstPlace.toUpperCase();
            firstPlaceLetterASCII = (firstPlace.charAt(0) - ASCII);
            firstPlaceLetter = Character.toString(firstPlaceLetterASCII+ASCII);
            
            //create substring and get number
            firstPlace = firstPlace.substring(1,firstPlace.length());
            firstPlaceNumber = Integer.parseInt(firstPlace);
            
            //repeat step with ending point
            lastPlace = lastPlace.toUpperCase();
            lastPlaceLetterASCII = (lastPlace.charAt(0) - ASCII);
            lastPlaceLetter = Character.toString(lastPlaceLetterASCII+ASCII);
            
            //create substring and get last number
            lastPlace = lastPlace.substring(1,lastPlace.length());
            lastPlaceNumber = Integer.parseInt(lastPlace);
            
            //determine whether ship is vertical or horizontal and set values accordingly
            if(firstPlaceNumber == lastPlaceNumber)
            {
               //vertical ship
               for(int v = 0; v < aircraftCarrierSize; v++)
                  layout.get(firstPlaceLetterASCII + v).set(firstPlaceNumber-1, CellStatus.AIRCRAFT_CARRIER);
            }
            else
            {
               //horizontal ship
               for(int H = 0; H < aircraftCarrierSize; H++)
                  layout.get(lastPlaceLetterASCII).set(firstPlaceNumber + H-1, CellStatus.AIRCRAFT_CARRIER);
            }

            
         }
         
         if(nextMove.equals("B"))
         {
            //get first and last place of the destroyer that is there
            firstPlace = allMoves.get(r);
            r++;
            lastPlace = allMoves.get(r);
            //add two so the next time it parses though firstPlace will be the actual first spot
            r += 2;
            
            //get the starting position of the ship into two seperate strings and ints corresponding to row and column
            firstPlace = firstPlace.toUpperCase();
            firstPlaceLetterASCII = (firstPlace.charAt(0) - ASCII);
            firstPlaceLetter = Character.toString(firstPlaceLetterASCII+ASCII);
            
            //create substring and get number
            firstPlace = firstPlace.substring(1,firstPlace.length());
            firstPlaceNumber = Integer.parseInt(firstPlace);
            
            //repeat step with ending point
            lastPlace = lastPlace.toUpperCase();
            lastPlaceLetterASCII = (lastPlace.charAt(0) - ASCII);
            lastPlaceLetter = Character.toString(lastPlaceLetterASCII+ASCII);
            
            //create substring and get last number
            lastPlace = lastPlace.substring(1,lastPlace.length());
            lastPlaceNumber = Integer.parseInt(lastPlace);
            
            //determine whether ship is vertical or horizontal and set values accordingly
            if(firstPlaceNumber == lastPlaceNumber)
            {
               //vertical ship
               for(int v = 0; v < battleshipSize; v++)
                  layout.get(firstPlaceLetterASCII + v).set(firstPlaceNumber-1, CellStatus.BATTLESHIP);
            }
            else
            {
               //horizontal ship
               for(int H = 0; H < battleshipSize; H++)
                  layout.get(lastPlaceLetterASCII).set(firstPlaceNumber + H-1, CellStatus.BATTLESHIP);
            }

            
         }
         
         if(nextMove.equals("C"))
         {
            //get first and last place of the destroyer that is there
            firstPlace = allMoves.get(r);
            r++;
            lastPlace = allMoves.get(r);
            
            //add two so the next time it parses though firstPlace will be the actual first spot
            r += 2;
            
            //get the starting position of the ship into two seperate strings and ints corresponding to row and column
            firstPlace = firstPlace.toUpperCase();
            firstPlaceLetterASCII = (firstPlace.charAt(0) - ASCII);
            firstPlaceLetter = Character.toString(firstPlaceLetterASCII+ASCII);
            
            //create substring and get number
            firstPlace = firstPlace.substring(1,firstPlace.length());
            firstPlaceNumber = Integer.parseInt(firstPlace);
            
            //repeat step with ending point
            lastPlace = lastPlace.toUpperCase();
            lastPlaceLetterASCII = (lastPlace.charAt(0) - ASCII);
            lastPlaceLetter = Character.toString(lastPlaceLetterASCII+ASCII);
            
            //create substring and get last number
            lastPlace = lastPlace.substring(1,lastPlace.length());
            lastPlaceNumber = Integer.parseInt(lastPlace);
            
            //determine whether ship is vertical or horizontal and set values accordingly
            if(firstPlaceNumber == lastPlaceNumber)
            {
               //vertical ship
               for(int v = 0; v < cruiserSize; v++)
                  layout.get(firstPlaceLetterASCII + v).set(firstPlaceNumber-1, CellStatus.CRUISER);
            }
            else
            {
               //horizontal ship
               for(int H = 0; H < cruiserSize; H++)
                  layout.get(lastPlaceLetterASCII).set(firstPlaceNumber + H-1, CellStatus.CRUISER);
            }

         }
         
         if(nextMove.equals("S"))
         {
            //get first and last place of the destroyer that is there
            firstPlace = allMoves.get(r);
            r++;
            lastPlace = allMoves.get(r);
            //add two so the next time it parses though firstPlace will be the actual first spot
            r += 2;
            
            //get the starting position of the ship into two seperate strings and ints corresponding to row and column
            firstPlace = firstPlace.toUpperCase();
            firstPlaceLetterASCII = (firstPlace.charAt(0) - ASCII);
            firstPlaceLetter = Character.toString(firstPlaceLetterASCII+ASCII);
           
            //create substring and get number
            firstPlace = firstPlace.substring(1,firstPlace.length());
            firstPlaceNumber = Integer.parseInt(firstPlace);
            
            //repeat step with ending point
            lastPlace = lastPlace.toUpperCase();
            lastPlaceLetterASCII = (lastPlace.charAt(0) - ASCII);
            lastPlaceLetter = Character.toString(lastPlaceLetterASCII+ASCII); 
            
            //create substring and get last number
            lastPlace = lastPlace.substring(1,lastPlace.length());
            lastPlaceNumber = Integer.parseInt(lastPlace); 
            
            //determine whether ship is vertical or horizontal and set values accordingly
            if(firstPlaceNumber == lastPlaceNumber)
            {
               //vertical ship
               for(int v = 0; v < subSize; v++)
                  layout.get(firstPlaceLetterASCII + v).set(firstPlaceNumber-1, CellStatus.SUB);
            }
            else
            {
               //horizontal ship
               for(int H = 0; H < subSize; H++)
                  layout.get(lastPlaceLetterASCII).set(firstPlaceNumber + H -1, CellStatus.SUB);
            }
         }
      }
   }
   
   /**
   * @param the cell where the move is taking place
   * @return original status of the cell
   */
   public CellStatus applyMoveToLayout(Move m)
   {
      //get row and column of move object taken in
      int beforeMoveRow = m.row();
      int beforeMoveCol = m.col()-1;
      
      //create string to hold the actual letter of the row
      String beforeMoveStringRow;
      
      //create the variable to take in the status of the cell
      CellStatus beforeMove = layout.get(beforeMoveRow).get(beforeMoveCol);
      
      //create variable to put the new status of cell
      CellStatus afterMove = null;
      
      //list all cases of unhit cells and changing them to hit
      if(beforeMove == CellStatus.NOTHING)
      {
         afterMove = CellStatus.NOTHING_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      }  
      if(beforeMove == CellStatus.AIRCRAFT_CARRIER)
      {
         afterMove = CellStatus.AIRCRAFT_CARRIER_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      } 
      if(beforeMove == CellStatus.BATTLESHIP)
      {
         afterMove = CellStatus.BATTLESHIP_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      }
      if(beforeMove == CellStatus.CRUISER)
      {
         afterMove = CellStatus.CRUISER_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      } 
      if(beforeMove == CellStatus.DESTROYER)
      {
         afterMove = CellStatus.DESTROYER_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      }
      if(beforeMove == CellStatus.SUB)
      {
         afterMove = CellStatus.SUB_HIT;
         updateLayout(afterMove, beforeMoveRow, beforeMoveCol);
      }
      
      //return what the original cell was
      return beforeMove;
   }
   
   /**
   * @param the cell that is being checked if it is on the board
   * @return true if move is possible on cell and false if not
   */
   public boolean moveAvailable(Move m)
   {
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
      
      //check if the move is in the array of all possible moves
      for(String position : possibleMoves)
      {
         if(position.equals(m.toString()))
            return true;
      }
      
      //return false if validation above does not return true
      return false;
      
   }
   
   /**
   * @return if the entire fleet has been sunk or not
   */
   public boolean gameOver()
   {
      return fleet.gameOver();
   }
   
   /**
   * @return the nested arrayList of cells
   */
   public ArrayList<ArrayList<CellStatus>> getLayout()
   {
      return layout;
   }
   
   
   /**
   * @return the fleet
   */
   public Fleet getFleet()
   {
      return fleet;
   }
   
   
   /**
   * @param old value of as well as the new value that it will be updated to
   */
   public void updateLayout(CellStatus newStatus, int row, int col)
   {
      layout.get(row).set(col,newStatus);
   }
   
   /**
   * method that takes in the old state and new state of the ship and will update all cells that have the state of the old state and change the to the new state
   * @
   */
   public void sinkShip(CellStatus oldCell, CellStatus newCell)
   {
      //nested for loops to check all cells
      for(int i = 0; i < SIZE; i++)
      {
         for(int j = 0; j < SIZE; j++)
         {
            if(oldCell == layout.get(i).get(j))
               layout.get(i).set(j, newCell);
         }
      }
   }
}