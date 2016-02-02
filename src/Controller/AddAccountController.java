package Controller;

import Model.Account;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.tools.jar.Main;

import java.io.IOException;

/**
 * Created by kostya on 12/25/2015.
 */
public class AddAccountController extends Controller {
    @FXML
    private static TextField accDescription;
    @FXML
    private static TextField addAccBallance;
    @FXML
    private static Button addAccountBtn;

    private static User user;
    static Account account;

    public static Account display(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/View/AddAccount.fxml"));
        AnchorPane addNewAccount = loader.load();

        Stage addDialogStage = new Stage();
        addDialogStage.setTitle("Add New Account");
        addDialogStage.initModality(Modality.APPLICATION_MODAL);
        addDialogStage.initOwner(primaryStage);
        Scene scene = new Scene(addNewAccount);
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();

        addAccountBtn.setOnAction(e ->{
            System.out.println(accDescription.getText() +" : "+Integer.parseInt(addAccBallance.getText()));
            System.out.println(user);
            account = new Account(1,accDescription.getText(),Integer.parseInt(addAccBallance.getText()));
        });
        return account;
    }

   /* public void addAccount(ActionEvent actionEvent) {
        System.out.println(accDescription.getText() +" : "+Integer.parseInt(addAccBallance.getText()));
        System.out.println(user);
        model.addAccount(user, new Account(1,accDescription.getText(),Integer.parseInt(addAccBallance.getText()),user.getLogin()));
    }*/
}
