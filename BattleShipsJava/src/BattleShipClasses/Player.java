package BattleShipClasses;

public class Player {

	private String Name;
	private int RemainingShips;
	private Tile[][] GameBoard = new Tile[10][10];
	private Ship[] Ships;
	
	//creates a new player and populates the ship array with 1 of each ShipType
	public Player() {
		Ships = new Ship[5];
		for (int i = 0; i < Ships.length; i++) {
			Ships[i] = new Ship(ShipType.byIndex(i));
		}
	}
}
