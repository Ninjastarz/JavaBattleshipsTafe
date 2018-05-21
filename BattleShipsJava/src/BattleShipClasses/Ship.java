package BattleShipClasses;


public class Ship {

	private int[] postion = new int[2];
	
	private int length;
	
	private ShipType type;
	
	private boolean sunk;
	
	private String Direction;
	
	private int startPoint;
	
	public Ship() {}
	
	//creates a new ship as a set type and automatically assigns it a length
	public Ship(ShipType type) {
		this.type = type;
		this.length = type.getIndex() + 1;
	}
	
	private int[] getPostion() 
	{
		return this.postion;
	} 
	private int getlength() 
	{
		return this.length;
	}
	
	private String getShipType() 
	{
		return type.getName();
	}
	
	private boolean getSunk() 
	{
		return this.sunk;
	}
	private String getDirection()
	{
	  return this.Direction;
	}
}
