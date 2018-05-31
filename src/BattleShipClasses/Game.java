package BattleShipClasses;

public class Game {
	// The player Boards 
    Player Human;
    ComPlayer CPU;
    
    Player Current;
    Player Opponent;
    // constructor 
    public Game() 
    {
        Human = new Player();
        CPU = new ComPlayer();
        
        Current = Human;
        Opponent = CPU;
    }
    // getters and setters 
    
    public void Turn() {
    	
    }
    
    public int placeship(Ship ShipToPlace, int[] StartPos, String Direction)
    {
      try {
    	  // sets the ship id in this position on the game board as the ship id thats been feed in
    	  Human.getBoard()[StartPos[0]][StartPos[1]].setShipId(ShipToPlace.getType()); 
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
    	   			Human.getBoard()[StartPos[0] + i][StartPos[1]].setShipId(ShipToPlace.getType());
					// gives one of the positions in the newPostions array the x and y gird coordinates 
    	   			newPostions[i] = new Postion(StartPos[0] + i,StartPos[1], false);    
    	   		};
    	   	break;
			
    	   	case "right": 
				
				// the for loop will go until the hole ship has bean placed
    	   		for (int i = 0; i > ShipToPlace.getLength() ; i++ ) 
    	   		{
					// sets the ship id in this position on the game board as the ship id thats been feed in
    	   			Human.getBoard()[StartPos[0] - i][StartPos[1]].setShipId(ShipToPlace.getType()); 
					// gives one of the positions the x and y gird coordinates 
    	   			newPostions[i] = new Postion(StartPos[0] - i,StartPos[1], false);
    	   		};
    	   	break;
    	   	case "down":
				// the for loop will go until the hole ship has bean placed
    	   		for (int i = 0; i < ShipToPlace.getLength(); i++ ) 
    	   		{
					// sets the ship id in this position on the game board as the ship id thats been feed in
    	   			Human.getBoard()[StartPos[0]][StartPos[1] + i].setShipId(ShipToPlace.getType()); 
					// gives one of the positions the x and y gird coordinates 
    	   			newPostions[i] = new Postion(StartPos[0],StartPos[1] + i, false);
    	   		};
    	   	break;
    	   	case "up":
				// the for loop will go until the hole ship has bean placed
    			for (int i = 0; i > ShipToPlace.getLength(); i++ ) 
    	   		{
					// sets the ship id in this position on the game board as the ship id thats been feed in
    	   			Human.getBoard()[StartPos[0]][StartPos[1] - i].setShipId(ShipToPlace.getType()); 
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
    
    public int Guess(int PosA, int PosB) 
	{
    	Player Opponent =
		// will return a int
		int ToBeReturned = 0;
		// if the position has already bean guessed 
		if (CPU.getBoard()[PosA][PosB].getGuessed() == true)
		{
			ToBeReturned = -1;  
		}
		else
		{
			// if there is no ship on the tile 
			if (CPU.getBoard()[PosA][PosB].getShipId() == null) 
			{
				ToBeReturned = 1;
				// sets the position on the game board as guessed
				CPU.getBoard()[PosA][PosB].setGuessed(true);

			}  
			else 
			{
				// loops thought the ships array
				for (int i = 0; i < Ships.length; i++) 
				{		//if the position on the board has the same id as  this ship
					if (Ships[i].getType() == CPU.getBoard()[PosA][PosB].getShipId() )
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
				CPU.getBoard()[PosA][PosB].setGuessed(true);
				ToBeReturned = 2;  
			}

		}
		// returns here!
		return ToBeReturned;

	}
}
