package BattleShipClasses;

import sun.security.action.GetBooleanAction;

public class ShipType {

	private enum shiptype
	{ 
		MotherShip,
		Tom_Carrier,
		Nuke_Sub,
		SOS_George,
		Ninja_Dingy
	}
	
	public ShiptType  getShipType(int type ) 
	{
		return shiptype[type]
	}
}
