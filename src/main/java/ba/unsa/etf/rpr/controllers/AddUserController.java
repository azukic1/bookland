package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController {
    public TextField firstNameId;
    public TextField lastNameId;
    public TextField usernameId;
    public Label neispravanPasswordId;
    public Button addUserBttn;
    public PasswordField passwordId;
    public Label neispravanUsernameId;
    String firstName, lastName;
    private final UserManager userManager = new UserManager();

    public AddUserController() {
    }

    public AddUserController(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addUserAction(ActionEvent actionEvent) throws BookException {

    }



}
