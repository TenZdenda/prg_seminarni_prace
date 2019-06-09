package pasek.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pasek.entities.Person;
import pasek.utils.newScene;
import pasek.utils.DatabaseConnect;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;


public class DashboardController implements Initializable {

    public TableView<Person> tableview;
    public TableColumn<Person, String> colName;
    public TableColumn<Person, String> colEmail;
    public TableColumn<Person, String> colPass;
    public Button logout;
    public Button addUser;


    ObservableList<Person> oblist = FXCollections.observableArrayList();

    public void initialize(URL location, ResourceBundle resources) {

        try{

            Connection connection = DatabaseConnect.getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM users");

            while (rs.next()){
                oblist.add(new Person(rs.getString("name"), rs.getString("email"), rs.getString("pass")));
            }

        } catch (Exception e){
            System.out.println("Chyba: " + e);
        }

        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPass.setCellValueFactory(new PropertyValueFactory<>("pass"));


        tableview.setItems(oblist);

    }


    public void lougoutButton(ActionEvent actionEvent) {
        Stage stage = (Stage) logout.getScene().getWindow();
        stage.close();

    }

    public void addNewUser(ActionEvent event) throws IOException {
        newScene ns = new newScene();
        ns.newScene("addNewUserDiagram.fxml", event);
    }

    public void deleteUser(ActionEvent event) throws IOException {
        newScene ns = new newScene();
        ns.newScene("deleteUser.fxml", event);
    }
}
