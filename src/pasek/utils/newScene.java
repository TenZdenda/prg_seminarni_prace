package pasek.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class newScene {

    public static void newScene(String fxmlFile, ActionEvent event) throws IOException {
        Parent window = FXMLLoader.load(newScene.class.getResource(fxmlFile));
        Scene windowScene = new Scene(window);

        Stage win = (Stage)((Node)event.getSource()).getScene().getWindow();
        win.setScene(windowScene);
        win.show();
    }
}
