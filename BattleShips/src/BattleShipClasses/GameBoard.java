package BattleShipClasses;

import java.util.ArrayList;

public class GameBoard {
	// The player Boards
    public Player Human, Current, Opponent;
    private ComPlayer CPU;
    private Tile[][] PlayerBoard;
    private Tile[][] CPUBoard;
    // constructor 
    public GameBoard(boolean isCom)
    {
        PlayerBoard = new Tile[10][10];
        CPUBoard = new Tile[10][10];

        //Initialise the tile array
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                PlayerBoard[x][y] = new Tile();
                CPUBoard[x][y] = new Tile();
            }
        }



        CPU = new ComPlayer();
        Human = new Player(isCom);
        Current = Human;
        Opponent = CPU;

        CPUBoard = Opponent.Board;
        PlayerBoard = Current.Board;
    }
    // getters and setters 
    public Tile[][] getPlayerBoard () 
    {
        return this.PlayerBoard;
    }
    public Tile[][] getCPUBoard () 
    {
        return this.CPUBoard;
    }
    
    public void SetPlayerBoard(Tile[][] playerboard)
    {
        Current.Board = playerboard;
        this.PlayerBoard = playerboard;
    }
    public void SetCPUBoard(Tile[][] cpuboard)
    {
        Opponent.Board = cpuboard;
        this.CPUBoard = cpuboard;
    }

    //Method for placing ship on game board(gets ship )
    public boolean placeShip(Ship ship, int x, int y, Player current) {
        try {
            // variables
            int length = ship.getLength();
            String direction = ship.Direction;
            ArrayList<Position> positionArrayList = new ArrayList<>();
            ArrayList<Ship> shipArrayList = new ArrayList<>();

            // Get the tile
            Tile tile = current.Board[x][y];

            // if tile is not null and has a ship
            if (tile == null) return false;
            if (tile.getShipId() != 0) return false;

            // We have an empty tile, let's see if we can place the ship starting from here.
            // If the direction is up, check that we have enough room above it
            if (direction == "Up") {
                if (y - (length) >= 0) { // check if ship can go up
                    for (int i = y; i > (y - length); i--) {
                        if (current.Board[x][i].getShipId() != 0) return false;
                    }
                    for (int i = y; i > (y - length); i--) {
                        current.Board[x][i].setShipId(ship.id);
                        positionArrayList.add(new Position(x, i, false));
                    }

                } else {                            //There’s no room upwards, so put it downwards

                    for (int i = y; i < (y + length); i++) {
                        if (current.Board[x][i].getShipId() != 0) {
                            return false;
                        }
                    }
                    for (int i = y; i < (y + length); i++) {
                        current.Board[x][i].setShipId(ship.id);
                        positionArrayList.add(new Position(x, i, false));
                    }
                }
            } else { // the direction is right
                if (x - length <= 9) { // check if ship can go right
                    for (int a = x; a > x - length; a--) {
                        if (current.Board[a][y].getShipId() != 0) return false;
                    }
                    for (int a = x; a > x - length; a--) {
                        current.Board[a][y].setShipId(ship.id);
                        positionArrayList.add(new Position(a, y, false));
                    }
                } else { // there's no room right, so put it left
                    for (int a = x; a < x + length; a++) {
                        if (current.Board[a][y].getShipId() != 0) return false;
                    }
                    for (int a = x; a < x + length; a++) {
                        current.Board[a][y].setShipId(ship.id);
                        positionArrayList.add(new Position(a, y, false));
                    }
                }
            }
            // set ships positions array to positions
            ship.setPositions(positionArrayList.toArray(new Position[]{}));

            // add existing ships to arraylist ships
            for (Ship s : current.Ships) {
                shipArrayList.add(s);
            }
            // add current ship
            shipArrayList.add(ship);
            // set ship array to ship arraylist
            current.Ships = shipArrayList.toArray(current.Ships);
            return true;
        } catch (ArrayIndexOutOfBoundsException ex){
            return false;
        }
    }

    //Method for taking a shot at the opponent
    public int Guess(int x, int y, Player reciever, Tile tile){
        // Loop through the reciever's ships
        for (Ship ship: reciever.Ships) {
            // if there is a ship there
            if (ship != null){
                // loop through it's positions
                for (Position pos: ship.getPositions()) {
                    // if the positions x and y are the same as the passed in x and y.
                    if (pos.getGridX() == x && pos.getGridY() == y) {
                        // set hit to true
                        pos.setHit(true);
                    }
                }
            }
        }

        // set the tile's guessed value to true and return ship id;
        tile.setGuessed(true);
        return tile.getShipId();
    }

}
