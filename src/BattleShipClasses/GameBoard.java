package BattleShipClasses;

public class GameBoard {
    private Tile[][] PlayerBoard = new Tile[10][10];
    private Tile[][] CPUBoard = new Tile[10][10];
    
    public GameBoard() 
    {
        
    }
    
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
