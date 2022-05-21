package de.hochtaunusschule.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * @author BlueTeaWolf
 */
public class MainFX extends Application {
    public static void main(String[] args) {
    launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(MainFX.class.getResource("/gui/javafx.fxml"));

        Scene scene = new Scene(root, 1000, 500);

        stage.setTitle("Arithmetic Puzzle");
        stage.setScene(scene);
        stage.show();
    }
}
