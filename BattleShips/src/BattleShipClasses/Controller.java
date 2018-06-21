package BattleShipClasses;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable{

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
            J1, J2, J3, J4, J5, J6, J7, J8, J9, J10,
            PlayAgain;
    @FXML
    private GridPane details;
    @FXML
    private Label shots, hits, misses;

    private Button[] buttons;
    private int Hits = 0, Misses = 0, Shots = 0;
    public Player player;
    public GameBoard gameBoard;

    public Controller() {
        gameBoard = new GameBoard(false);
        player = gameBoard.Current;
        if (buttons == null) {
            buttons = new Button[100];
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addButtons(new ArrayList<>());
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

    private Position mapButtonToPosition (String buttonId){
        Position returnPos = new Position(0,0,false);

        String firstBit = buttonId.substring(0,1);
        String secondBit = buttonId.substring(1,buttonId.length());

        int x = 0;
        int y = (Integer.valueOf(secondBit))-1;

        switch (firstBit){
            case "B":
                x = 1;
                break;
            case "C":
                x = 2;
                break;
            case "D":
                x = 3;
                break;
            case "E":
                x = 4;
                break;
            case "F":
                x = 5;
                break;
            case "G":
                x = 6;
                break;
            case "H":
                x = 7;
                break;
            case "I":
                x = 8;
                break;
            case "J":
                x = 9;
                break;
        }
        returnPos.setGridX(x);
        returnPos.setGridY(y);
        return returnPos;
    }

    public int getIdOfShipAtLocation(int x, int y) {
        Tile[][] cpuBoard = gameBoard.getCPUBoard();
        Tile tile = cpuBoard[x][y];
        int shipId = tile.getShipId();

        if (shipId != 0) {
            Button button = getButtonAtPosition(x, y);
            if (button != null) {
                return gameBoard.Guess(x, y, gameBoard.Opponent, tile);
            }
        }
        return -1;
    }

    public void shot(ActionEvent event) {
        int y, x, idOfShipAtLocation;
        details.setVisible(true);


        for (Button button: buttons) {
            Position pos = mapButtonToPosition(button.getId());
            GridPane.setColumnIndex(button, pos.getGridX());
            GridPane.setRowIndex(button, pos.getGridY());
        }

        Button button = (Button) event.getSource();
        if (!player.checkLoss()) {
            Position pos = mapButtonToPosition(button.getId());
            x = pos.getGridX();
            y = pos.getGridY();

            shots.setText(Integer.toString(++Shots));

            idOfShipAtLocation = getIdOfShipAtLocation(x, y);

            if (idOfShipAtLocation > -1){

                switch (idOfShipAtLocation){
                    case 5: button.setStyle("-fx-background-color: aqua");
                        break;
                    case 4: button.setStyle("-fx-background-color: purple");
                        break;
                    case 3: button.setStyle("-fx-background-color: lime");
                        break;
                    case 2: button.setStyle("-fx-background-color: red");
                        break;
                    case 1: button.setStyle("-fx-background-color: blue");
                        break;
                }



                hits.setText(Integer.toString(++Hits));
                misses.setText(Integer.toString(Misses));
            } else {
                button.setStyle("-fx-background-color: gray");
                misses.setText(Integer.toString(++Misses));
                hits.setText(Integer.toString(Hits));
            }
        }
        if (player.checkLoss()){
            PlayAgain.setVisible(true);
            PlayAgain.setOnAction(e -> {
                try {
                    Main.switchScene(FXMLLoader.load(getClass().getResource("myShips.fxml")), 870);

                }catch (IOException ex){

                }
            });
        }
    }

    public void addButtons(ArrayList<Button> Buttons){
        Buttons.add(A1);
        Buttons.add(A2);
        Buttons.add(A3);
        Buttons.add(A4);
        Buttons.add(A5);
        Buttons.add(A6);
        Buttons.add(A7);
        Buttons.add(A8);
        Buttons.add(A9);
        Buttons.add(A10);
        Buttons.add(B1);
        Buttons.add(B2);
        Buttons.add(B3);
        Buttons.add(B4);
        Buttons.add(B5);
        Buttons.add(B6);
        Buttons.add(B7);
        Buttons.add(B8);
        Buttons.add(B9);
        Buttons.add(B10);
        Buttons.add(C1);
        Buttons.add(C2);
        Buttons.add(C3);
        Buttons.add(C4);
        Buttons.add(C5);
        Buttons.add(C6);
        Buttons.add(C7);
        Buttons.add(C8);
        Buttons.add(C9);
        Buttons.add(C10);
        Buttons.add(D1);
        Buttons.add(D2);
        Buttons.add(D3);
        Buttons.add(D4);
        Buttons.add(D5);
        Buttons.add(D6);
        Buttons.add(D7);
        Buttons.add(D8);
        Buttons.add(D9);
        Buttons.add(D10);
        Buttons.add(E1);
        Buttons.add(E2);
        Buttons.add(E3);
        Buttons.add(E4);
        Buttons.add(E5);
        Buttons.add(E6);
        Buttons.add(E7);
        Buttons.add(E8);
        Buttons.add(E9);
        Buttons.add(E10);
        Buttons.add(F1);
        Buttons.add(F2);
        Buttons.add(F3);
        Buttons.add(F4);
        Buttons.add(F5);
        Buttons.add(F6);
        Buttons.add(F7);
        Buttons.add(F8);
        Buttons.add(F9);
        Buttons.add(F10);
        Buttons.add(G1);
        Buttons.add(G2);
        Buttons.add(G3);
        Buttons.add(G4);
        Buttons.add(G5);
        Buttons.add(G6);
        Buttons.add(G7);
        Buttons.add(G8);
        Buttons.add(G9);
        Buttons.add(G10);
        Buttons.add(H1);
        Buttons.add(H2);
        Buttons.add(H3);
        Buttons.add(H4);
        Buttons.add(H5);
        Buttons.add(H6);
        Buttons.add(H7);
        Buttons.add(H8);
        Buttons.add(H9);
        Buttons.add(H10);
        Buttons.add(I1);
        Buttons.add(I2);
        Buttons.add(I3);
        Buttons.add(I4);
        Buttons.add(I5);
        Buttons.add(I6);
        Buttons.add(I7);
        Buttons.add(I8);
        Buttons.add(I9);
        Buttons.add(I10);
        Buttons.add(J1);
        Buttons.add(J2);
        Buttons.add(J3);
        Buttons.add(J4);
        Buttons.add(J5);
        Buttons.add(J6);
        Buttons.add(J7);
        Buttons.add(J8);
        Buttons.add(J9);
        Buttons.add(J10);
        buttons = Buttons.toArray(buttons);
    }
}
