package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class BooksController {
    public Button addBookBttn;
    public Button deleteBookBttn;
    public Button cancelBttn;
    public ListView listId;

    public BooksController() {

    }

    public void addBookAction(ActionEvent actionEvent) {
    }

    public void deleteBookAction(ActionEvent actionEvent) {
    }
    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}
