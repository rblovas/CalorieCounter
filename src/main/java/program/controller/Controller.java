package program.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Objects;

public class Controller {
    public static void errorBox(String infoMessage, String titleBar, String headerMessage) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    public void sceneSwitch(Stage stage, String fxml, ActionEvent event){

        try {
            Node source = (Node) event.getSource();
            stage = (Stage) source.getScene().getWindow();
            Scene newScene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("views/" + fxml + ".fxml"))));
            stage.setScene(newScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
