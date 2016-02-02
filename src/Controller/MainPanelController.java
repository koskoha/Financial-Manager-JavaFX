package Controller;

import Model.Account;
import Model.Record;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sun.tools.jar.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

public class MainPanelController extends Controller implements Initializable {
    private Stage primaryStage;
    @FXML
    private Label usetNameLable;
    @FXML
    private TableView mainTableView;
    @FXML
    private ListView<String> accountsListView;
    @FXML
    private Label accBallance;
    @FXML
    private TextField accDescription;
    @FXML
    private TextField addAccBallance;

    private User user;
    private Set<Account> accounts;


    public void selectedAccount(Event event) {
        TableColumn<Record, Integer> recId = new TableColumn<>("ID");
        recId.setMinWidth(50);
        recId.setCellValueFactory(new PropertyValueFactory<Record, Integer>("rec_ID"));

        TableColumn<Record, Integer> isPut = new TableColumn<>("Deposite");
        isPut.setMinWidth(50);
        isPut.setCellValueFactory(new PropertyValueFactory<Record, Integer>("isPut"));

        TableColumn<Record, String> date = new TableColumn<>("Date");
        date.setMinWidth(50);
        date.setCellValueFactory(new PropertyValueFactory<Record, String>("date"));

        TableColumn<Record, Integer> amount = new TableColumn<>("Amount");
        amount.setMinWidth(50);
        amount.setCellValueFactory(new PropertyValueFactory<Record, Integer>("amount"));

        TableColumn<Record, String> description = new TableColumn<>("Description");
        description.setMinWidth(50);
        description.setCellValueFactory(new PropertyValueFactory<Record, String>("description"));

        mainTableView.getColumns().clear();
        mainTableView.setItems(getRecordsfromAccount(accountsListView.getSelectionModel().getSelectedItem()));
        mainTableView.getColumns().addAll(recId, description, date, isPut, amount);
    }

    public void logOutLbl(Event event) throws IOException {
        Parent homePageParent = FXMLLoader.load(getClass().getResource("/View/loginForm.fxml"));
        Scene homePageScene = new Scene(homePageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(homePageScene);
        appStage.show();
    }

    public ObservableList<Record> getRecordsfromAccount(String accName) {
        for (Account acc : accounts) {
            if (acc.getDescription().equals(accName)) {
                accBallance.setText(String.valueOf(acc.getBalance()));
                ObservableList<Record> records = FXCollections.observableArrayList();
                records.addAll(model.getRecords(acc));
                return records;
            }
        }
        return null;
    }

    public void setMainScene(User user, Stage stage) {
        this.user = user;
        usetNameLable.setText(user.getLogin());
        accountsListView.getItems().addAll(getAccountsNames());
        primaryStage = stage;
    }

    private Set<String> getAccountsNames() {
        accounts = model.getAccounts(user);
        Set<String> accountsNames = new TreeSet<>();
        for (Account acc : accounts) {
            accountsNames.add(acc.getDescription());
        }
        return accountsNames;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void showAddAccountForm(ActionEvent actionEvent) throws IOException {

        Account account = AddAccountController.display(primaryStage);

       /* FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/View/AddAccount.fxml"));
        AnchorPane addNewAccount = loader.load();

        Stage addDialogStage = new Stage();
        addDialogStage.setTitle("Add New Account");
        addDialogStage.initModality(Modality.WINDOW_MODAL);
        addDialogStage.initOwner(primaryStage);
        Scene scene = new Scene(addNewAccount);
        addDialogStage.setScene(scene);
        addDialogStage.showAndWait();*/
    }

  /*  public void addAccount(ActionEvent actionEvent) {
        System.out.println(accDescription.getText() +" : "+Integer.parseInt(addAccBallance.getText()));
        System.out.println(user);
        model.addAccount(user, new Account(1,accDescription.getText(),Integer.parseInt(addAccBallance.getText()),user.getLogin()));
    }*/
}
