package BattleShipClasses;


import javafx.fxml.*;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class myShips implements Initializable {

    private int NoShips = 5;

    @FXML
    private Button
            A1, A2, A3, A4, A5, A6, A7, A8, A9, A10,
            B1, B2, B3, B4, B5, B6, B7, B8, B9, B10,
            C1, C2, C3, C4, C5, C6, C7, C8, C9, C10,
            D1, D2, D3, D4, D5, D6, D7, D8, D9, D10,
            E1, E2, E3, E4, E5, E6, E7, E8, E9, E10,
            F1, F2, F3, F4, F5, F6, F7, F8, F9, F10,
            G1, G2, G3, G4, G5, G6, G7, G8, G9, G10,
            H1, H2, H3, H4, H5, H6, H7, H8, H9, H10,
            I1, I2, I3, I4, I5, I6, I7, I8, I9, I10,
            J1, J2, J3, J4, J5, J6, J7, J8, J9, J10;

    public static Player player;

    public myShips(){
        player = new Player();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showShips() ;
    }

    public void rearrange(){
        try {
            Main.switchScene(FXMLLoader.load(getClass().getResource("myShips.fxml")), 870);

        }catch (IOException ex){

        }
    }

    public void play() {
        try {
            Main.switchScene(FXMLLoader.load(getClass().getResource("sample.fxml")), 950);

        }catch (IOException ex){

        }
    }

    public void showShips(){
        placeShips();
        GameBoard gameBoard = player.Game;
        Tile[][] playerBoard = gameBoard.getPlayerBoard();

        //Get the GameBoard.PlayerBoard and reset the scene
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                Button button = getButtonAtPosition(x, y);
                if (button != null) {
                    button.setStyle("-fx-background-color: white");
                }

            }
        }

        //Get the GameBoard.PlayerBoard and map the ships on the scene
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                if (playerBoard[x][y].getShipId() != 0){
                    Button button = getButtonAtPosition(x, y);
                    if (button != null){
                        switch(playerBoard[x][y].getShipId()) {
                            case 1: button.setStyle("-fx-background-color: blue");
                            break;
                            case 2: button.setStyle("-fx-background-color: red");
                            break;
                            case 3: button.setStyle("-fx-background-color: lime");
                            break;
                            case 4: button.setStyle("-fx-background-color: purple");
                            break;
                            case 5: button.setStyle("-fx-background-color: aqua");
                            break;
                        }
                    }
                }
            }
        }
    }

    public void placeShips() {

        int x, y, direction, length;
        String Direction = "";
        Ship ship = null;

        while (NoShips > 0) {


            x = (int) (Math.random() * 10 );
            y = (int) (Math.random() * 10 );
            length = NoShips;
            direction = (int) Math.round(Math.random() * 2 );

            switch (direction) {
                case 1:
                    Direction = "Left";
                    break;
                case 0:
                    Direction = "Up";
                    break;
            }


            switch (length) {
                case 5:
                    ship = new Ship(ShipType.MotherShip, length);
                    break;
                case 4:
                    ship = new Ship(ShipType.Tom_Carrier, length);
                    break;
                case 3:
                    ship = new Ship(ShipType.Nuke_Sub, length);
                    break;
                case 2:
                    ship = new Ship(ShipType.SOS_George, length);
                    break;
                case 1:
                    ship = new Ship(ShipType.Ninja_Dingy, length);
                    break;
            }
            ship.setDirection(Direction);
            ship.setPositions(new Position[length]);

            switch (Direction) {
                case "Left":
                    setPositionValues(ship, x, y, length, true);

                    break;
                case "Up":
                    setPositionValues(ship, x, y, length, false);

                    break;
            }

            if (player.placeShip(ship, x, y))  {
                NoShips--;
            }
        }
    }

    public void setPositionValues(Ship ship, int x, int y, int length, boolean Left) {
        if (Left) {
            switch (length) {
                case 5:
                    for (int i = 0; i < 5; i++) {
                        if (x > 4) {
                            ship.setPostionsValues(new Position(x - i, y, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x + i, y, false), i);
                        }
                    }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++) {
                        if (x > 4) {
                            ship.setPostionsValues(new Position(x - i, y, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x + i, y, false), i);
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 3; i++) {
                        if (x > 4) {
                            ship.setPostionsValues(new Position(x - i, y, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x + i, y, false), i);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++) {
                        if (x > 4) {
                            ship.setPostionsValues(new Position(x - i, y, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x + i, y, false), i);
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 1; i++) {
                        if (x > 4) {
                            ship.setPostionsValues(new Position(x - i, y, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x + i, y, false), i);
                        }
                    }
                    break;
            }
        } else {
            switch (length) {
                case 5:
                    for (int i = 0; i < 5; i++)
                        if (y > 4) {
                            ship.setPostionsValues(new Position(x, y - i, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x, y + i, false), i);
                        }
                    break;
                case 4:
                    for (int i = 0; i < 4; i++)
                        if (y > 4) {
                            ship.setPostionsValues(new Position(x, y - i, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x, y + i, false), i);
                        }
                    break;
                case 3:
                    for (int i = 0; i < 3; i++)
                        if (y > 4) {
                            ship.setPostionsValues(new Position(x, y - i, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x, y + i, false), i);
                        }
                    break;
                case 2:
                    for (int i = 0; i < 2; i++)
                        if (y > 4) {
                            ship.setPostionsValues(new Position(x, y - i, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x, y + i, false), i);
                        }
                    break;
                case 1:
                    for (int i = 0; i < 1; i++)
                        if (y > 4) {
                            ship.setPostionsValues(new Position(x, y - i, false), i);
                        } else {
                            ship.setPostionsValues(new Position(x, y + i, false), i);
                        }
                    break;
            }
        }
    }

    private Button getButtonAtPosition(int x, int y){

        String buttonId = mapTileToButton(x, y);

        switch (buttonId){
            case "A1":
                return this.A1;
            case "A2":
                return this.A2;
            case "A3":
                return this.A3;
            case "A4":
                return this.A4;
            case "A5":
                return this.A5;
            case "A6":
                return this.A6;
            case "A7":
                return this.A7;
            case "A8":
                return this.A8;
            case "A9":
                return this.A9;
            case "A10":
                return this.A10;
            case "B1":
                return this.B1;
            case "B2":
                return this.B2;
            case "B3":
                return this.B3;
            case "B4":
                return this.B4;
            case "B5":
                return this.B5;
            case "B6":
                return this.B6;
            case "B7":
                return this.B7;
            case "B8":
                return this.B8;
            case "B9":
                return this.B9;
            case "B10":
                return this.B10;
            case "C1":
                return this.C1;
            case "C2":
                return this.C2;
            case "C3":
                return this.C3;
            case "C4":
                return this.C4;
            case "C5":
                return this.C5;
            case "C6":
                return this.C6;
            case "C7":
                return this.C7;
            case "C8":
                return this.C8;
            case "C9":
                return this.C9;
            case "C10":
                return this.C10;
            case "D1":
                return this.D1;
            case "D2":
                return this.D2;
            case "D3":
                return this.D3;
            case "D4":
                return this.D4;
            case "D5":
                return this.D5;
            case "D6":
                return this.D6;
            case "D7":
                return this.D7;
            case "D8":
                return this.D8;
            case "D9":
                return this.D9;
            case "D10":
                return this.D10;
            case "E1":
                return this.E1;
            case "E2":
                return this.E2;
            case "E3":
                return this.E3;
            case "E4":
                return this.E4;
            case "E5":
                return this.E5;
            case "E6":
                return this.E6;
            case "E7":
                return this.E7;
            case "E8":
                return this.E8;
            case "E9":
                return this.E9;
            case "E10":
                return this.E10;
            case "F1":
                return this.F1;
            case "F2":
                return this.F2;
            case "F3":
                return this.F3;
            case "F4":
                return this.F4;
            case "F5":
                return this.F5;
            case "F6":
                return this.F6;
            case "F7":
                return this.F7;
            case "F8":
                return this.F8;
            case "F9":
                return this.F9;
            case "F10":
                return this.F10;
            case "G1":
                return this.G1;
            case "G2":
                return this.G2;
            case "G3":
                return this.G3;
            case "G4":
                return this.G4;
            case "G5":
                return this.G5;
            case "G6":
                return this.G6;
            case "G7":
                return this.G7;
            case "G8":
                return this.G8;
            case "G9":
                return this.G9;
            case "G10":
                return this.G10;
            case "H1":
                return this.H1;
            case "H2":
                return this.H2;
            case "H3":
                return this.H3;
            case "H4":
                return this.H4;
            case "H5":
                return this.H5;
            case "H6":
                return this.H6;
            case "H7":
                return this.H7;
            case "H8":
                return this.H8;
            case "H9":
                return this.H9;
            case "H10":
                return this.H10;
            case "I1":
                return this.I1;
            case "I2":
                return this.I2;
            case "I3":
                return this.I3;
            case "I4":
                return this.I4;
            case "I5":
                return this.I5;
            case "I6":
                return this.I6;
            case "I7":
                return this.I7;
            case "I8":
                return this.I8;
            case "I9":
                return this.I9;
            case "I10":
                return this.I10;
            case "J1":
                return this.J1;
            case "J2":
                return this.J2;
            case "J3":
                return this.J3;
            case "J4":
                return this.J4;
            case "J5":
                return this.J5;
            case "J6":
                return this.J6;
            case "J7":
                return this.J7;
            case "J8":
                return this.J8;
            case "J9":
                return this.J9;
            case "J10":
                return this.J10;
        }

        return null;
    }

    private String mapTileToButton(int x, int y){
        String firstBit = "";

        switch (x){
            case 0:
                firstBit = "A";
                break;
            case 1:
                firstBit = "B";
                break;
            case 2:
                firstBit = "C";
                break;
            case 3:
                firstBit = "D";
                break;
            case 4:
                firstBit = "E";
                break;
            case 5:
                firstBit = "F";
                break;
            case 6:
                firstBit = "G";
                break;
            case 7:
                firstBit = "H";
                break;
            case 8:
                firstBit = "I";
                break;
            case 9:
                firstBit = "J";
                break;
        }

        return firstBit + (y+1);
    }



}


