package BattleShipClasses;


public class Ship {
	//
	private int length;
	
	private ShipType type;
	
	private boolean sunk;
        
    private String Direction;
	
    private Postion[] Postions;
	
	public Ship() 
    {
            
    }
	
	//creates a new ship as a set type and automatically assigns it a length
	public Ship(ShipType type) 
	{
		this.type = type;
		this.length = type.getIndex() + 2;
	}
	// getters and setters 
	public int getLength() {
	return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public ShipType getType() {
		return type;
	}
	
	public void setType(ShipType type) {
		this.type = type;
	}
	
	public boolean isSunk() {
		return sunk;
	}
	
	public void setSunk(boolean sunk) {
		this.sunk = sunk;
	}
	
	public String getDirection() {
		return Direction;
	}
	
	public void setDirection(String direction) {
		Direction = direction;
	}

	public Postion[] getPostions() {
		return Postions;
	}

	public void setPostions(Postion[] postions) {
		Postions = postions;
	}
	// sets the positions with its values rather than a array of position
	public void setPostionsValues(int gridX, int gridY, boolean hit, int arrayPotion) 
	{	Postions[arrayPotion].setHit(hit);
		Postions[arrayPotion].setGridY(gridY);
		Postions[arrayPotion].setGridX(gridX);
	}
	
	
	

       
}
