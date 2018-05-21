package BattleShipClasses;

public enum ShipType { 
	Ninja_Dingy(0, "Ninja Dingy"),
	SOS_George(1, "SOS George"),
	Nuke_Sub(2, "Nuke Sub"),
	Tom_Carrier(3, "Tom Carrier"),
	MotherShip(4, "The Mothership");
	
	private int Index;
	private String Name;
	
	private ShipType(int index, String name) {
		this.Index = index;
		this.Name = name;
	}

	public static ShipType byIndex(int index) {
		for(ShipType Type : ShipType.values()) {
			if (Type.Index == index) {
				return Type;
			}
		}
		return null;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public int getIndex() {
		return this.Index;
	}
}

