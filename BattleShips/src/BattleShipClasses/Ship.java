package BattleShipClasses;


public class Ship {

	public int id;
	private int length;
	private ShipType type;
	private boolean sunk;
    public String Direction;
    private Position[] positions;
	public Ship(){ }
	
	//creates a new ship as a set type and automatically assigns it a length
	public Ship(ShipType type, int id)
	{
		this.id = id;
		this.type = type;
		this.length = type.getIndex() + 1;
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

	public Position[] getPositions() {
		return positions;
	}

	public void setPositions(Position[] positions) {
		this.positions = positions;
	}
	// sets the positions with its values rather than a array of position
	public void setPostionsValues(Position position, int arrayPotion)
	{
		positions[arrayPotion] = position;
	}
	
	
	

       
}
