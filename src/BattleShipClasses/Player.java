package BattleShipClasses;


public class Player {
	// variables
	protected String Name;
	protected int RemainingShips;
	protected Ship[] Ships;
	protected Tile[][] Board = new Tile[10][10];
	protected boolean isCom;
	//creates a new player and populates the ship array with 1 of each ShipType
	public Player() {
		Ships = new Ship[5];
		for (int i = 0; i < Ships.length; i++) {
			Ships[i] = new Ship(ShipType.byIndex(i));
		}
		isCom = false;
	}
	
	public boolean isCom() {
		return isCom;
	}

	public String getName() {
		return Name;
	}
	public int getRemainingShips() {
		return RemainingShips;
	}
	public Ship[] getShips() {
		return Ships;
	}
	public Tile[][] getBoard() {
		return Board;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setRemainingShips(int remainingShips) {
		RemainingShips = remainingShips;
	}
	public void setShips(Ship[] ships) {
		Ships = ships;
	}
	public void setBoard(Tile[][] board) {
		Board = board;
	}
	
	public void setCom(boolean isCom) {
		this.isCom = isCom;
	}
	
	// The method for guessing where a ship is (feed in the coordinates)
	
	// method for checking if a player has lost 
	public boolean Checkloss () 
	{
		// this int will increases every time all the positions in the ship was hit  
		int AllShips = 0;

		//	 loop thought the array of ships 
		for (int i = 0; i < Ships.length; i++) 
		{	
			// increases every time a position in the ship was hit 
			int ShipsPostions = 0;
			// loop thought the array 
			for (int j = 0; j < Ships[i].getPostions().length; j++ ) 
			{	
				//if the position has been hit 
				if (Ships[i].getPostions()[j].getHit() == true) 
				{
					ShipsPostions++;
				}

			}
			//if every position in the ship has been hit 
			if (ShipsPostions == Ships[i].getPostions().length) 
			{
				AllShips++;
			}


		}
		// if all the ship have had all positions have been hit 
		if (AllShips == Ships.length) 
		{
			// YOU LOSE
			return true;
		}
		else 
		{
			return false;

		}

	}
	//Method for placing ship on game board(gets ship )

}
