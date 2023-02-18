package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    public TextField firstNameId;
    public TextField lastNameId;
    public TextField usernameId;
    public PasswordField passwordId;

    public Button signUpBttn;
    public Label neispravanPasswordId;
    public Label neispravanUsernameId;

    public SignUpController() {

    }
    @FXML
    public void initialize() {
        usernameId.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue.length()>=5) neispravanUsernameId.setText("");
            else neispravanUsernameId.setText("Invalid username");
        });
        passwordId.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue.length()>=5) neispravanPasswordId.setText("");
            else neispravanPasswordId.setText("Invalid password");
        });
    }

    public void signUpAction(ActionEvent actionEvent) {

    }
}
