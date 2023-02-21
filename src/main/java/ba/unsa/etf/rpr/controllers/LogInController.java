package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author Ajla Zukic
 */
public class LogInController {

    public TextField usernameId;
    public PasswordField passwordId;
    public Button loginBttn;
    public Button signupBttn;

    /**
     * class constructor
     */
    public LogInController() {

    }

    /**
     * @param actionEvent
     * @throws IOException
     */
    public void signUpActionn(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/signup.fxml"));
        SignUpController controller = new SignUpController();
        loader.setController(controller);
        stage.setTitle("Sign Up");
        stage.setScene(new Scene(loader.load(),USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        Stage s = (Stage)signupBttn.getScene().getWindow();
        s.close();

    }
    UserManager userManager = new UserManager();
    public void loginAction(ActionEvent actionEvent) throws BookException, IOException {
        List<User> allUsers = FXCollections.observableList(userManager.getAll());
        boolean valid = false;
        int id = 0;

        for(int i = 0; i< allUsers.size(); i++) {
            if(allUsers.get(i).getUsername().equals(usernameId.getText()) && allUsers.get(i).getPassword().equals(passwordId.getText())) {
                valid = true;
                id = i;
                break;
            }
        }
        if(valid) {
            if (allUsers.get(id).isAdministrator() == 1) {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/adminhome.fxml"));
                AdminHomeController controller = new AdminHomeController();
                loader.setController(controller);
                stage.setTitle("");
                stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
                Stage s = (Stage) loginBttn.getScene().getWindow();
                s.close();
            } else {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/userhome.fxml"));
                UserHomeController controller = new UserHomeController();
                loader.setController(controller);
                stage.setTitle("");
                stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
                stage.setResizable(false);
                stage.show();
                Stage s = (Stage) loginBttn.getScene().getWindow();
                s.close();

            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid username or password");
            alert.setContentText("Please try again");
            alert.show();
            }
    }


}
