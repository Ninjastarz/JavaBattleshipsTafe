package BattleShipClasses;

public class Tile {
	
 // Variables
 private boolean Guessed;
 
 // Constructors
 public Tile() 
 {
	
 }
 
 public Tile(boolean guessed) 
 {
	this.Guessed = guessed;
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
 
}
