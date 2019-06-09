package pasek.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import pasek.utils.PersonImpl;
import pasek.entities.Person;
import pasek.utils.newScene;


public class LoginController {

    public Button button;
    public TextField email_field;
    public TextField pass_field;

    public Label error;

    public void handleLoginButtonAction(ActionEvent event) throws Exception {

        // Získané data
        String email = email_field.getText();
        String heslo = pass_field.getText();

        if(email.isEmpty() || heslo.isEmpty()){
            error.setText("Vyplňte správně formulář!");
            return;
        }

        PersonImpl pi = new PersonImpl();

        Person person = pi.selectedById(email);

        // Ověřování hesla
        if(heslo.equals(person.getPass())){
            newScene ns = new newScene();
            newScene.newScene("dashboard.fxml", event);
        } else{
            error.setText("Hesla se neschodují!");
            return;
        }
    }
}
