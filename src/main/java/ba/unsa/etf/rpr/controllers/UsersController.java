package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX controller
 *
 * @author Ajla Zukic
 */
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class UsersController {
    public ListView listId;
    public Button addBttnId;
    public Button deleteBttnId;
    public Button CancelId;

    /**
     * Class constructor
     */
    public UsersController() {
    }
    private final UserManager userManager = new UserManager();
    @FXML
    public void initialize() throws BookException {
        List<User> allUsers = FXCollections.observableList(userManager.getAll());
        List<String> users = new ArrayList<>();
        for(int i = 0; i<allUsers.size(); i++) {
            if(allUsers.get(i).isAdministrator()!=1) {
                users.add(allUsers.get(i).getFirstName() + " " + allUsers.get(i).getLastName());
            }
        }
        listId.getItems().addAll(users);
    }

    /**
     * This method open new window, admin can add new book
     * @param actionEvent
     * @throws BookException
     * @throws IOException
     */
    public void addBttnAction(ActionEvent actionEvent) throws BookException, IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addUser.fxml"));
        AddUserController controller = new AddUserController();
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(x->{
            String s = controller.firstNameId.getText() + " " + controller.lastNameId.getText();
            listId.getItems().add(s);

        });
    }

    /**
     *
     * @param actionEvent
     * @throws BookException
     */
    public void deleteBttnAction(ActionEvent actionEvent) throws BookException {
        List<User> allUsers = FXCollections.observableList(userManager.getAll());
        int i = listId.getSelectionModel().getSelectedIndex();
        userManager.delete(allUsers.get(i).getId());
        listId.getItems().remove(i);
        listId.refresh();
    }

    /**
     * Method that closes current window
     * @param actionEvent
     */
    public void cancelBttn(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}
