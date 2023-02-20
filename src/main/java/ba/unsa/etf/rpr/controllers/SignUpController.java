package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpController {

    private final UserManager userManager = new UserManager();

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
            if(newValue.length()>=8) neispravanPasswordId.setText("");
            else neispravanPasswordId.setText("Invalid password");
        });
    }

    public void signUpAction(ActionEvent actionEvent) throws BookException, IOException {
        boolean valid = true;
        if(firstNameId.getText() == null  || lastNameId.getText() == null || usernameId.getText() == null
           || passwordId.getText() == null) valid = false;
        if(firstNameId.getText().contains(" ") || lastNameId.getText().contains(" ") || usernameId.getText().contains(" ")
           || passwordId.getText().contains(" ")) valid = false;
        if(usernameId.getText().length() < 5 || passwordId.getText().length() < 8) valid = false;

        if(!valid) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Can not add user");
                alert.setContentText("Please try again");
                alert.show();
        }
        else {
            User u = new User();
            u.setFirstName(firstNameId.getText());
            u.setLastName(lastNameId.getText());
            u.setUsername(usernameId.getText());
            u.setPassword(passwordId.getText());
            u.setAdministrator(0);
            userManager.add(u);
            Stage s = (Stage)signUpBttn.getScene().getWindow();
            s.close();
        }
    }
}
