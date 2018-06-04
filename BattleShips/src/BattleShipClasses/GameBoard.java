package BattleShipClasses;

public class GameBoard {
	// The player Boards 
    private Tile[][] PlayerBoard;
    private Tile[][] CPUBoard;
    // constructor 
    public GameBoard() 
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
       this.PlayerBoard = playerboard;
    }
    public void SetCPUBoard(Tile[][] cpuboard)
    {
         this.CPUBoard = cpuboard;
    }
    
}
