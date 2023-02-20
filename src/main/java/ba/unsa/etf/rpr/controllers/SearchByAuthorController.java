package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class SearchByAuthorController {
    public ListView listId;
    public Button borrowBookBttn;
    public Button cancelBttn;
    String author;
    private final BookManager bookManager = new BookManager();

    public SearchByAuthorController(String a) {
        author = a;
    }

    @FXML
    public void initialize() throws BookException {


    }

    public void borrowBookAction(ActionEvent actionEvent) {

    }

    public void cancelAction(ActionEvent actionEvent) {

    }
}
