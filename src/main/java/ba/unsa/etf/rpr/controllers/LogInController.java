package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class LogInController {

    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginBttn;
    public Button signupBttn;

    public LogInController() {

    }

    public void signUpAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signup.fxml"));
        SignUpController controller = new SignUpController();
        loader.setController(controller);
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(loader.load(),USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }


}
