package BattleShipClasses;

/**
 * @author Levi Peace
 */
public class ComPlayer extends Player{
    public static void main(String[] args) {
        ComPlayer aCom = new ComPlayer();
        for (Ship S : aCom.Ships) {
            System.out.println(S.getType());
        }

    }

    public ComPlayer() {
        super(true);
    }
}