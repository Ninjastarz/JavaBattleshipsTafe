package BattleShipClasses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stage;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("myShips.fxml"));
        primaryStage.setTitle("Battleships");
        primaryStage.setScene(new Scene(root, 754, 870));
        primaryStage.show();

        stage = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(Parent fxml, int height){
        Parent root = fxml;
        stage.setScene(new Scene(root, 754, height));
        stage.show();

    }

}