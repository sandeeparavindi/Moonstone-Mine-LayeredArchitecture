package lk.ijse.MoonstoneMine.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    public static void adminORcashierUI(String formName, AnchorPane pane) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigation.class.getResource
                    ("/lk/ijse/MoonstoneMine/view/" +
                    formName + ".fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) pane.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
