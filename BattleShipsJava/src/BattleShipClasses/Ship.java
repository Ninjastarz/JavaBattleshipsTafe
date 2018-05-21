package BattleShipClasses;

import sun.awt.image.IntegerInterleavedRaster;
import sun.net.www.content.text.plain;

public class Ship {

	private int[] postion = new int[2];
	
	private int length;
	
	private ShiptType type;
	
	private boolean sunk;
	
	private String Direction;
	
	private int startingPoint;
	
	
	private int[] getPostion() 
	{
		return this.postion;
	} 
	private int getlength() 
	{
		return this.length;
	}
	
	private ShiptType getShipType() 
	{
		return type;
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
