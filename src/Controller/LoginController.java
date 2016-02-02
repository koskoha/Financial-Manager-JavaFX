package Controller;

import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kostya on 12.12.2015.
 */
public class LoginController extends Controller implements Initializable {
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;


    @FXML
    private void login(ActionEvent actionEvent) throws IOException {
        User user = model.getUser(login.getText());
        if (user == null) {
            JOptionPane.showMessageDialog(null, login.getText() + " doesn't exist! \n Try again!", "Error...", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!(user.getPassword().equals(password.getText()))) {
            JOptionPane.showMessageDialog(null, "Wrong password!", "Error...", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/MainPanel.fxml"));
            Parent homePageParent = (Parent)fxmlLoader.load();
            MainPanelController mainPanelController = fxmlLoader.<MainPanelController>getController();
            Scene homePageScene = new Scene(homePageParent);
            Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            mainPanelController.setMainScene(user,appStage);
            appStage.setScene(homePageScene);
            appStage.show();
        }
    }

    @FXML
    private void switchToRegister(ActionEvent actionEvent) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("/View/registrationForm.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage appStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
