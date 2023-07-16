package lk.ijse.chatApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginFormController {
    public static String name;
    @FXML
    private AnchorPane pane;

    @FXML
    private TextField txtName;

    @FXML
    private Button buttonJoin;

    public void nameOnAction(ActionEvent event) {
        buttonJoin.fire();
    }

    public void clientLogin() throws IOException{
        name=txtName.getText();
        if (Pattern.matches("^[a-z\\s]+",txtName.getText())){
            Parent root = FXMLLoader.load(getClass().getResource("/view/ChatForm.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.setResizable(false);
            stage.show();

            txtName.clear();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Please enter your name");
            alert.show();
        }
    }

    public void loginOnAction(ActionEvent event) throws IOException {
        clientLogin();
    }
}
