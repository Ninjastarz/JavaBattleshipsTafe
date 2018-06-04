package BattleShipClasses;

public class Tile {
	
	 // Variables
	 private boolean Guessed;
	 private int ShipId ;
	 // Constructors
	 public Tile(){
		
	 }
	 public Tile(boolean guessed, int shipid){
			this.Guessed = guessed;
	        this.ShipId = shipid;
	 }
	 
	 //getters and setters
	 public boolean getGuessed () {
		 return this.Guessed;
	 }
	 public void setGuessed(boolean guessed) {
		 this.Guessed = guessed;
	 }

	 public int getShipId()
	 {
		 return this.ShipId;
	 }
	 public void setShipId(int shipid){
		 this.ShipId = shipid;
		 
	 }
 
}
