package pasek.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pasek.utils.PersonImpl;
import pasek.entities.Person;
import pasek.utils.newScene;

import java.io.IOException;

public class AddDialogController {

    public TextField user_name;
    public TextField user_email;
    public TextField user_pass;
    public Button addNewUser;

    public Label error;


    public void addNewUser(ActionEvent event) throws IOException {

        String name = user_name.getText();
        String email = user_email.getText();
        String pass = user_pass.getText();

        PersonImpl pi = new PersonImpl();

        Person verifyP = pi.selectedById(email);

        if(user_name.getText().isEmpty() || user_email.getText().isEmpty() || user_pass.getText().isEmpty() || email.equals(verifyP.getEmail())){
            newScene ns = new newScene();
            ns.newScene("dashboard.fxml", event);
            return;
        }

        Person person = new Person(name, email, pass);

        pi.insert(person);
    }


}
