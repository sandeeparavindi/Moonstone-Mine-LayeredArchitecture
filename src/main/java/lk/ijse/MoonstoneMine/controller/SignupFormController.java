package lk.ijse.MoonstoneMine.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.MoonstoneMine.bo.BOFactory;
import lk.ijse.MoonstoneMine.bo.Custom.SignupFormBO;
import lk.ijse.MoonstoneMine.dao.Custom.UserDAO;
import lk.ijse.MoonstoneMine.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class SignupFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtPw;
    @FXML
    private TextField txtUserName;
    SignupFormBO signupFormBO = (SignupFormBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.SIGNUPFORM);
    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        try {
            boolean userCheck = txtEmail.getText().equals(signupFormBO.getEmail(txtEmail.getText()));
            if (!userCheck){

                UserDto userDto = new UserDto();
                userDto.setEmail(txtEmail.getText());
                userDto.setName(txtUserName.getText());
                userDto.setPassword(txtPw.getText());

                boolean saved = signupFormBO.addUser(userDto);
                if (saved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "user Saved").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "user  not saved").show();
                }
            }else {
                new Alert(Alert.AlertType.WARNING, "Already exist ").show();
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @FXML
    void hyperLoginHereOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));

        Scene scene = new Scene(rootNode);

        root.getChildren().clear();
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(scene);
        stage.setTitle("Login Form");
    }
}
