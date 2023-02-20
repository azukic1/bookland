package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class UsersController {
    public ListView listId;
    public Button addBttnId;
    public Button deleteBttnId;
    public Button CancelId;

    public UsersController() {
    }
    private final UserManager userManager = new UserManager();
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

    public void addBttnAction(ActionEvent actionEvent) throws BookException, IOException {

    }

    public void deleteBttnAction(ActionEvent actionEvent) throws BookException {
        List<User> allUsers = FXCollections.observableList(userManager.getAll());
        int i = listId.getSelectionModel().getSelectedIndex();
        userManager.delete(allUsers.get(i).getId());
        listId.getItems().remove(i);
        listId.refresh();
    }

    public void cancelBttn(ActionEvent actionEvent) {
    }
}
