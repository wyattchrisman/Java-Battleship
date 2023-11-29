//Wyatt Chrisman CS110
//Create the computers board

import java.io.*;

//class that creates the computer's board as well as the corresponding methods
public class ComputerBoard extends Board 
{
   //instance variable
   private final int ASCII = 65;
   
   /**
   * Constructor that gives the file name to the board class
   * @param the given file name
   */
   public ComputerBoard(String fileName) throws IOException
   {
      super(fileName);
   }
   
   /**
   * @param the cell that is being hit
   * @return statement that returns null if ship is missed or a statement saying it is sunk of hit
   */
   public String makePlayerMove(Move userMove)
   {
      
      String move = userMove.toString();
      int row = (move.charAt(0) - ASCII);
      move = move.substring(1,2);
      int col = Integer.parseInt(move);
      
      
      
      //apply user move
      CellStatus result = applyMoveToLayout(userMove);
      
      //nested loops to change the state of the cells with the new move being made as well as the corresponding sentence
      if(result == CellStatus.NOTHING)
         return null;
      if(result == CellStatus.AIRCRAFT_CARRIER)
      {
         if(getFleet().updateFleet(ShipType.ST_AIRCRAFT_CARRIER))
         {
            sinkShip(CellStatus.AIRCRAFT_CARRIER_HIT, CellStatus.AIRCRAFT_CARRIER_SUNK);
            System.out.println("Computer Says: You sank my Aircraft Carrier!\n");
            return "Computer Says: You sank my Aircraft Carrier!";
         }  
      }
      if(result == CellStatus.BATTLESHIP)
      {
         if(getFleet().updateFleet(ShipType.ST_BATTLESHIP))
         {
            sinkShip(CellStatus.BATTLESHIP_HIT, CellStatus.BATTLESHIP_SUNK);
            System.out.println("Computer Says: You sank my Battleship!\n");
            return "Computer Says: You sank my Battleship!";
         }
      }
      if(result == CellStatus.CRUISER)
      {
         if(getFleet().updateFleet(ShipType.ST_CRUISER))
         {
            sinkShip(CellStatus.CRUISER_HIT, CellStatus.CRUISER_SUNK);
            System.out.println("Computer Says: You sank my Cruiser!\n");
            return "Computer Says: You sank my Cruiser!";
         }
      }
      if(result == CellStatus.SUB)
      {
         if(getFleet().updateFleet(ShipType.ST_SUB))
         {
            sinkShip(CellStatus.SUB_HIT, CellStatus.SUB_SUNK);
            System.out.println("Computer Says: You sank my Submarine!\n");
            return "Computer Says: You sank my Submarine!";
         }
      }
      if(result == CellStatus.DESTROYER)
      {
         if(getFleet().updateFleet(ShipType.ST_DESTROYER))
         {
            sinkShip(CellStatus.DESTROYER_HIT, CellStatus.DESTROYER_SUNK);
            System.out.println("Computer Says: You sank my Destroyer!\n");
            return "Computer Says: You sank my Destroyer!";
         }
      } 
      
         return null; 
   }
   
   /**
   * @return the computer's board in grid form
   */
   public String toString()
   {
      //create blank board to return later
      String board = "  1 2 3 4 5 6 7 8 9 10\n";
      
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
            state = state.substring(0,1);
         
            //add to the board
            board += " " + state;
         }
         
         board += "\n";
        
      }  
      
      //return the board
      return board; 
   }
}