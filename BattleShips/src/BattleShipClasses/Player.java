package BattleShipClasses;

public class Player {
	// variables
	protected String Name;
	protected int RemainingShips;
	public Ship[] Ships;
	public Tile[][] Board;
	//public GameBoard Game = new GameBoard();
	protected boolean isCom;

	//creates a new player and populates the ship array with 1 of each ShipType
	public Player(boolean isCom) {
		Ships = new Ship[5];

		if (isCom){
			for (int i = 0; i < Ships.length; i++) {
				Ships[i] = new Ship(ShipType.byIndex(i), i);
			}
		}

		setCom(isCom);

		Board = new Tile[10][10];

		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 10; y++) {
				Board[x][y] = new Tile();
			}
		}
	}

	public boolean isCom() {
		return isCom;
	}

	public void setCom(boolean com) {
		isCom = com;
	}

	// method for checking if a player has lost
	public boolean checkLoss() {
		// this int will increases every time all the positions in the ship was hit
		int totalShipsDestroyed = 0;

		//Get a count os the number of not null ships in the array
		int totalShipCount = 0;
		for (Ship ship: Ships) {
			if (ship != null) {
				totalShipCount++;
			}
		}

		//	 loop thought the array of ships
		for (Ship ship: Ships) {
			if (ship != null) {
				// get current position array
				Position[] positions = ship.getPositions();
				// get position length
				int length = positions.length;
				// increases every time a position in the ship was hit
				int ShipsPositions = 0;
				// loop thought the array
				for (int j = 0; j < length; j++) {
					//if the position has been hit
					if (positions[j].getHit()) {
						ShipsPositions++;
					}

				}

				//if every position in the ship has been hit
				if (ShipsPositions == length) {
					totalShipsDestroyed++;
				}

			}
		}
		// if all the ship have had all positions have been hit
		// YOU LOSE
		return totalShipsDestroyed == totalShipCount;

	}
}
