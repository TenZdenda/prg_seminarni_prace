package pasek.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import pasek.utils.PersonImpl;
import pasek.entities.Person;
import pasek.utils.newScene;

import java.io.IOException;

public class deleteUserController {

    public TextField user_email;
    public Button deleteButton;

    public void deleteUserButton(ActionEvent event) throws IOException {

        String email = user_email.getText();

        PersonImpl pi = new PersonImpl();
        Person verifyP = pi.selectedById(email);

        if(!email.equals(verifyP.getEmail())){
            newScene ns = new newScene();
            ns.newScene("../FXML/dashboard.fxml", event);
            return;
        }

        pi.delete(email);

        newScene ns = new newScene();
        ns.newScene("../FXML/dashboard.fxml", event);
        return;
    }

}
