//Wyatt Chrisman CS110
//Create a class that allows user to enter the 
//coordinate of a space which is classified as their 'move'


public class Move
{
   //create private instance variables
   private int row;
   private int col;
   private String stringRow;
   int[][] list = new int[10][10];
   private final int ASCII = 65;
   private final int NOT_START_ZERO = 1;
   
   /**
   * @param two ints that correspond to row and column
   * Creates a Move object from two integers representing the indices in a two- dimensional array.
   */
   public Move(int r, int c)
   {
      row = r+ASCII;
      col = c+NOT_START_ZERO;
      
      //turn the int into a String
      stringRow = Character.toString(row);
   }
   
   /**
   * @param String that has a letter and number
   * Splits the string into an integer and a character and then turns that character back into a corresponding int
   */
   public Move(String s)
   {
      //make sure string is uppercase
      s = s.toUpperCase();
      
      //take in letter and subtract the ASCII constant
      row = (s.charAt(0) - ASCII);
      
      //remove letter from string
      s = s.substring(NOT_START_ZERO,s.length());
      
      //find the int in the string and set to collums
      col = Integer.parseInt(s);
      
      //turn the int into a String
      stringRow = Character.toString(row+ASCII);
   }
   
   
   /**
   * @return the row
   */
   public int row()
   {
      return row;
   }
   
   /**
   * @return the column
   */
   public int col()
   {
      return col;
   }
   
   @Override
   public String toString()
   {
      //return the two values combines in a row then column  
      return stringRow + col;
   }
}