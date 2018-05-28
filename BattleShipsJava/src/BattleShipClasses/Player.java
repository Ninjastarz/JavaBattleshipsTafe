package BattleShipClasses;


public class Player {
	// variables
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
		// The method for guessing where a ship is (feed in the coordinates)
        public int Guess(int PosA, int PosB) 
        {
			// will return a int
        	int ToBeReturned = 0;
			// if the position has already bean guessed 
            if (Game.getCPUBoard()[PosA][PosB].getGuessed() == true)
            {
            	ToBeReturned = -1;  
            }
            else
            {
				// if there is no ship on the tile 
              if (Game.getCPUBoard()[PosA][PosB].getShipId() == null) 
              {
            	  ToBeReturned = 1;
				  // sets the position on the game board as guessed
            	  Game.getCPUBoard()[PosA][PosB].setGuessed(true);
            	  
              }  
              else 
              {
				  // loops thought the ships array
            	  for (int i = 0; i < Ships.length; i++) 
            	  {		//if the position on the board has the same id as  this ship
            		  if (Ships[i].getType() == Game.getCPUBoard()[PosA][PosB].getShipId() )
            		  {		//loops though the array of positions
            			  for (int j = 0; j < Ships[i].getPostions().length; j++) 
            			  {		// if the grid coordinates match up with positions 
            				  if (Ships[i].getPostions()[j].getGridX() == PosA && Ships[i].getPostions()[j].getGridY() == PosB ) 
            				  {		// sets that position in ships as hit 
            					  Ships[i].setPostionsValues(PosA, PosB, true, j);
            				  }
            				  
            			  } 
            			 
            		  }
            	  }
				  // sets the position on the game board as guessed
            	  Game.getCPUBoard()[PosA][PosB].setGuessed(true);
            	  ToBeReturned = 2;  
              }
            	           
            }
            // returns here!
            return ToBeReturned;
          
        }
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
        public int placeship(Ship ShipToPlace, int[] StartPos, String Direction)
        {
          try {
        	  // sets the ship id in this position on the game board as the ship id thats been feed in
        	  Game.getPlayerBoard()[StartPos[0]][StartPos[1]].setShipId(ShipToPlace.getType()); 
			  // creates a new array of positions 
        	  Postion[] newPostions = new Postion[ShipToPlace.getLength()]; 
			  // feed in the declaration the end of the ship is 
        	  switch (Direction) 
        	  {
				  
        	   	case "left":
				
					// the for loop will go until the hole ship has bean placed
        	   		for (int i = 0; i < ShipToPlace.getLength(); i++ ) 
        	   		{
						// sets the ship id in this position on the game board as the ship id thats been feed in
        	   			Game.getPlayerBoard()[StartPos[0] + i][StartPos[1]].setShipId(ShipToPlace.getType());
						// gives one of the positions in the newPostions array the x and y gird coordinates 
        	   			newPostions[i] = new Postion(StartPos[0] + i,StartPos[1], false);    
        	   		};
        	   	break;
				
        	   	case "right": 
					
					// the for loop will go until the hole ship has bean placed
        	   		for (int i = 0; i > ShipToPlace.getLength() ; i++ ) 
        	   		{
						// sets the ship id in this position on the game board as the ship id thats been feed in
        	   			Game.getPlayerBoard()[StartPos[0] - i][StartPos[1]].setShipId(ShipToPlace.getType()); 
						// gives one of the positions the x and y gird coordinates 
        	   			newPostions[i] = new Postion(StartPos[0] - i,StartPos[1], false);
        	   		};
        	   	break;
        	   	case "down":
					// the for loop will go until the hole ship has bean placed
        	   		for (int i = 0; i < ShipToPlace.getLength(); i++ ) 
        	   		{
						// sets the ship id in this position on the game board as the ship id thats been feed in
        	   			Game.getPlayerBoard()[StartPos[0]][StartPos[1] + i].setShipId(ShipToPlace.getType()); 
						// gives one of the positions the x and y gird coordinates 
        	   			newPostions[i] = new Postion(StartPos[0],StartPos[1] + i, false);
        	   		};
        	   	break;
        	   	case "up":
					// the for loop will go until the hole ship has bean placed
        			for (int i = 0; i > ShipToPlace.getLength(); i++ ) 
        	   		{
						// sets the ship id in this position on the game board as the ship id thats been feed in
        	   			Game.getPlayerBoard()[StartPos[0]][StartPos[1] - i].setShipId(ShipToPlace.getType()); 
						// gives one of the positions the x and y gird coordinates 
        	   			newPostions[i] = new Postion(StartPos[0],StartPos[1] - i, false);
        	   		};
        	   	break;
        	  }
			  // sets the positions of the ship to the position in the method  
        	  ShipToPlace.setPostions(newPostions);
          } 
          catch (Exception e) {
			return -1;
          }
        	
            
            return 0;
        
        }
}
