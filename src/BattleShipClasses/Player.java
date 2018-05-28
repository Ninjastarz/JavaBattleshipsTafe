package BattleShipClasses;


public class Player {
	//
	private String Name;
	private int RemainingShips;
	private Ship[] Ships;
	private GameBoard Game = new GameBoard();
	//creates a new player and populates the ship array with 1 of each ShipType
	public Player() {
		Ships = new Ship[5];
		for (int i = 0; i < Ships.length; i++) {
			Ships[i] = new Ship(ShipType.byIndex(i));
		}
	}
		//
        public int Guess(int PosA, int PosB) 
        {
        	int ToBeReturned = 0;
            if (Game.getCPUBoard()[PosA][PosB].getGuessed() == true)
            {
            	ToBeReturned = -1;  
            }
            else
            {
              if (Game.getCPUBoard()[PosA][PosB].getShipId() == null) 
              {
            	  ToBeReturned = 1;
            	  Game.getCPUBoard()[PosA][PosB].setGuessed(true);
            	  
              }  
              else 
              {
            	  for (int i = 0; i < Ships.length; i++) 
            	  {
            		  if (Ships[i].getType() == Game.getCPUBoard()[PosA][PosB].getShipId() )
            		  {
            			  for (int j = 0; j < Ships[i].getPostions().length; j++) 
            			  {
            				  if (Ships[i].getPostions()[j].getGridX() == PosA && Ships[i].getPostions()[j].getGridY() == PosB ) 
            				  {
            					  Ships[i].setPostionsValues(PosA, PosB, true, j);
            				  }
            				  
            			  } 
            			 
            		  }
            	  }
            	  Game.getCPUBoard()[PosA][PosB].setGuessed(true);
            	  ToBeReturned = 2;  
              }
            	           
            }
            
            return ToBeReturned;
          
        }
        // method for checking if a player has lost 
        public boolean Checkloss () 
        {
        	int AllShips = 0;
        	
        	for (int i = 0; i < Ships.length; i++) 
        	{	
        		int ShipsPostions = 0;
        		for (int j = 0; j < Ships[i].getPostions().length; j++ ) 
        		{
        			if (Ships[i].getPostions()[j].getHit() == true) 
        			{
        				ShipsPostions++;
        			}
        				
        		}
        		if (ShipsPostions == Ships[i].getPostions().length) 
        		{
        			AllShips++;
        		}
        		
        		
        	}
        	
        	if (AllShips == Ships.length) 
        	{
        		return true;
        	}
        	else 
        	{
        		return false;
				
			}
          
        }
        //
        public int placeship(Ship ShipToPlace, int[] StartPos, String Direction)
        {
          try {
        	  //
        	  Game.getPlayerBoard()[StartPos[0]][StartPos[1]].setShipId(ShipToPlace.getType()); 
        	  Postion[] newPostions = new Postion[ShipToPlace.getLength()]; 
        	  switch (Direction) 
        	  {
        	   	case "left":
        	   		for (int i = 0; i < ShipToPlace.getLength(); i++ ) 
        	   		{
        	   			Game.getPlayerBoard()[StartPos[0] + i][StartPos[1]].setShipId(ShipToPlace.getType());
        	   			newPostions[i] = new Postion(StartPos[0] + i,StartPos[1], false);    
        	   		};
        	   	break;
        	   	case "right": 
        	   		for (int i = 0; i > ShipToPlace.getLength() ; i++ ) 
        	   		{
        	   			Game.getPlayerBoard()[StartPos[0] - i][StartPos[1]].setShipId(ShipToPlace.getType()); 
        	   			newPostions[i] = new Postion(StartPos[0] - i,StartPos[1], false);
        	   		};
        	   	break;
        	   	case "down":
        	   		for (int i = 0; i < ShipToPlace.getLength(); i++ ) 
        	   		{
        	   			Game.getPlayerBoard()[StartPos[0]][StartPos[1] + i].setShipId(ShipToPlace.getType()); 
        	   			newPostions[i] = new Postion(StartPos[0],StartPos[1] + i, false);
        	   		};
        	   	break;
        	   	case "up":
        			for (int i = 0; i > ShipToPlace.getLength(); i++ ) 
        	   		{
        	   			Game.getPlayerBoard()[StartPos[0]][StartPos[1] - i].setShipId(ShipToPlace.getType()); 
        	   			newPostions[i] = new Postion(StartPos[0],StartPos[1] - i, false);
        	   		};
        	   	break;
        	  }
        	  ShipToPlace.setPostions(newPostions);
          } 
          catch (Exception e) {
			return -1;
          }
        	
            
            return 0;
        
        }
}
