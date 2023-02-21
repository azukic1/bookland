package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * JavaFX controller
 *
 * @author Ajla Zukic
 */
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

    /**
     * class constructor
     */
    public AddUserController() {
    }

    /**
     * class constructor
     * @param firstName
     * @param lastName
     */
    public AddUserController(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    @FXML
    public void initialize(){
        usernameId.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue.length()>=5) neispravanUsernameId.setText("");
            else neispravanUsernameId.setText("Invalid username");
        });
        passwordId.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue.length()>=8) neispravanPasswordId.setText("");
            else neispravanPasswordId.setText("Invalid password");
        });
    }

    /**
     * This method add user
     * @param actionEvent
     * @throws BookException
     */
    public void addUserAction(ActionEvent actionEvent) throws BookException {
        User u = new User();
        u.setFirstName(firstNameId.getText());
        u.setLastName(lastNameId.getText());
        u.setUsername(usernameId.getText());
        u.setPassword(passwordId.getText());
        u.setAdministrator(0);
        userManager.add(u);
        Stage s = (Stage)addUserBttn.getScene().getWindow();
        s.close();
    }



}
