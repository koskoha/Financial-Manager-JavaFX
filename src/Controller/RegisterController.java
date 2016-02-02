package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;


/**
 * Created by kostya on 12.12.2015.
 */
public class RegisterController extends Controller {

    @FXML
    private TextField registerLogin;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private PasswordField reenteredPassword;
    @FXML
    private Label machingLable;
    @FXML
    private Button register;

    public void registerBtn(ActionEvent actionEvent) throws IOException {
        if (!reenteredPassword.getText().equals(registerPassword.getText())) {
            JOptionPane.showMessageDialog(null,"Passwords don't matching!","Error...",JOptionPane.ERROR_MESSAGE);

        }else {
            model.addUser(new User(registerLogin.getText(),registerPassword.getText()));
            showScene("/View/MainPanel.fxml",actionEvent);
        }

    }

    public void backToLogin(ActionEvent actionEvent) throws IOException {
        showScene("/View/loginForm.fxml", actionEvent);
    }

    private void showScene(String path, ActionEvent actionEvent) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource(path));
        Scene homePageScene = new Scene(homePageParent);
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();
    }


    public void cheskForMatch(Event event) {
        if (!reenteredPassword.getText().equals(registerPassword.getText())) {
            machingLable.setText("Passwords don't matching!");
            machingLable.setStyle("-fx-text-fill:red;");
        } else if (reenteredPassword.getText().equals(registerPassword.getText())) {
            machingLable.setText("Passwords are matching!");
            machingLable.setStyle("-fx-text-fill:green;");
        }
    }
}
