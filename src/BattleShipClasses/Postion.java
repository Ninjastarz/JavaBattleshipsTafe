package BattleShipClasses;


public class Postion {

	private int GridX;
	private int GridY;
	private Boolean Hit;
	public Postion(int gridX, int gridY, Boolean hit) {
		super();
		GridX = gridX;
		GridY = gridY;
		Hit = hit;
	}
	public int getGridX() {
		return GridX;
	}
	public void setGridX(int gridX) {
		GridX = gridX;
	}
	public int getGridY() {
		return GridY;
	}
	public void setGridY(int gridY) {
		GridY = gridY;
	}
	public Boolean getHit() {
		return Hit;
	}
	public void setHit(Boolean hit) {
		Hit = hit;
	}
	
	
}
