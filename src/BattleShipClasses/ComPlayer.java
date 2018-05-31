/**
 * 
 */
package BattleShipClasses;

/**
 * @author Levi Peace
 *
 */
public class ComPlayer extends Player {

	
	public static void main(String[] args) {
		ComPlayer aCom = new ComPlayer();
		for (Ship S : ) {
			System.out.println(S.getType());
		}
		
	}
	/**
	 * 
	 */
	public ComPlayer() {
		// TODO Auto-generated constructor stub
		super();
	}

	
	public int Guess(int PosA, int PosB) {
		// TODO Auto-generated method stub
		return super.Guess(PosA, PosB);
	}

	public boolean Checkloss() {
		// TODO Auto-generated method stub
		return super.Checkloss();
	}

	public int placeship(Ship ShipToPlace, int[] StartPos, String Direction) {
		// TODO Auto-generated method stub
		return super.placeship(ShipToPlace, StartPos, Direction);
	}

}
