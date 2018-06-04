package BattleShipClasses;


import java.util.ArrayList;

public class Player {
	// variables
	private String Name;
	private int RemainingShips;
	public Ship[] Ships;
	public GameBoard Game = new GameBoard();

	//creates a new player and populates the ship array with 1 of each ShipType
	public Player() {
		Ships = new Ship[5];
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
		if (totalShipsDestroyed == totalShipCount) {
			// YOU LOSE
			return true;
		} else {
			return false;

		}

	}


	//Method for placing ship on game board(gets ship )
	public boolean placeShip(Ship ship, int x, int y) {
		try {
			// variables
			int length = ship.getLength();
			String direction = ship.Direction;
			ArrayList<Position> positionArrayList = new ArrayList<>();
			ArrayList<Ship> shipArrayList = new ArrayList<>();

			// Get the tile
			Tile tile = Game.getPlayerBoard()[x][y];

			// if tile is not null and has a ship
			if (tile == null) return false;
			if (tile.getShipId() != 0) return false;

			// We have an empty tile, let's see if we can place the ship starting from here.
			// If the direction is up, check that we have enough room above it
			if (direction == "Up") {
				if (y - (length) >= 0) { // check if ship can go up
					for (int i = y; i > (y - length); i--) {
						if (Game.getPlayerBoard()[x][i].getShipId() != 0) return false;
					}
					for (int i = y; i > (y - length); i--) {
						Game.getPlayerBoard()[x][i].setShipId(ship.id);
						positionArrayList.add(new Position(x, i, false));
					}

				} else {                            //There’s no room upwards, so put it downwards

					for (int i = y; i < (y + length); i++) {
						if (Game.getPlayerBoard()[x][i].getShipId() != 0) {
							return false;
						}
					}
					for (int i = y; i < (y + length); i++) {
						Game.getPlayerBoard()[x][i].setShipId(ship.id);
						positionArrayList.add(new Position(x, i, false));
					}
				}
			} else { // the direction is right
				if (x - length <= 9) { // check if ship can go right
					for (int a = x; a > x - length; a--) {
						if (Game.getPlayerBoard()[a][y].getShipId() != 0) return false;
					}
					for (int a = x; a > x - length; a--) {
						Game.getPlayerBoard()[a][y].setShipId(ship.id);
						positionArrayList.add(new Position(a, y, false));
					}
				} else { // there's no room right, so put it left
					for (int a = x; a < x + length; a++) {
						if (Game.getPlayerBoard()[a][y].getShipId() != 0) return false;
					}
					for (int a = x; a < x + length; a++) {
						Game.getPlayerBoard()[a][y].setShipId(ship.id);
						positionArrayList.add(new Position(a, y, false));
					}
				}
			}
			// set ships positions array to positions
			ship.setPositions(positionArrayList.toArray(new Position[]{}));

			// add existing ships to arraylist ships
			for (Ship s : Ships) {
				shipArrayList.add(s);
			}
			// add current ship
			shipArrayList.add(ship);
			// set ship array to ship arraylist
			Ships = shipArrayList.toArray(Ships);
			return true;
		} catch (ArrayIndexOutOfBoundsException ex){
			return false;
		}
	}
}
