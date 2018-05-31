package BattleShipClasses;

public class GameBoard {
	// The player Boards 
    private Tile[][] PlayerBoard = new Tile[10][10];
    private Tile[][] CPUBoard = new Tile[10][10];
    // constructor 
    public GameBoard() 
    {
        
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
