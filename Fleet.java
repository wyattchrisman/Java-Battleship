//Wyatt Chrisman CS110
//Create a fleet class that uses all ship types 

public class Fleet
{
   //create instance variables
   private Ship battleShip;
   private Ship aircraftCarrier;
   private Ship cruiser;
   private Ship sub;
   private Ship destroyer;
   
   //create fleet which applies ship type to each ship
   public Fleet()
   {
      battleShip = new Battleship();
      aircraftCarrier = new AircraftCarrier();
      cruiser = new Cruiser();
      sub = new Sub();
      destroyer = new Destroyer();
   }
   
   /**
   * @param ship type name
   * @return true if ship gets sank and false if not
   */
   public boolean updateFleet(ShipType st)
   {
      if(st == ShipType.ST_SUB)
         return sub.hit();
      if(st == ShipType.ST_DESTROYER)
         return destroyer.hit();
      if(st == ShipType.ST_BATTLESHIP)
         return battleShip.hit();
      if(st == ShipType.ST_CRUISER)
         return cruiser.hit();
      else
         return aircraftCarrier.hit();
   }
   
   /**
   * @return true if all ships are sunk and false if not
   */
   public boolean gameOver()
   {  
      return battleShip.getSunk() &&
             aircraftCarrier.getSunk() &&
             cruiser.getSunk() &&
             sub.getSunk() &&
             destroyer.getSunk();
   }
}