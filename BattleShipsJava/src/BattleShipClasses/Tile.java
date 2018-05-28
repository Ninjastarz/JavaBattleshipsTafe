package BattleShipClasses;

public class Tile {
	
	 // Variables
	 private boolean Guessed;
	 private ShipType ShipId ;
	 // Constructors
	 public Tile() 
	 {
		
	 }
	 public Tile(boolean guessed, ShipType shipid) 
	 {
			this.Guessed = guessed;
	        this.ShipId = shipid;
	 }
	 
	 //getters and setters
	 public boolean getGuessed () 
	 {
		 return this.Guessed;
	 }
	 
	 public void setGuessed(boolean guessed) 
	 {
		 this.Guessed = guessed;
		 
	 }
	  public ShipType getShipId() 
	 {
		 return this.ShipId;
	 }
	 
	 public void setShipId(ShipType shipid) 
	 {
		 this.ShipId = shipid;
		 
	 }
 
}
