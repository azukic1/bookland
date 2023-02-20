package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class BooksController {
    public Button addBookBttn;
    public Button deleteBookBttn;
    public Button cancelBttn;
    public ListView listId;

    private final BookManager bookManager = new BookManager();
    public BooksController() {

    }
    @FXML
    public void initialize() throws BookException {
        List<Book> allBooks = FXCollections.observableList(bookManager.getAll());
        List<String> books = new ArrayList<>();
        for(int i = 0; i<allBooks.size(); i++) {
                books.add(allBooks.get(i).getTitle() + " " + allBooks.get(i).getAuthor());

        }
        listId.getItems().addAll(books);
    }


    public void addBookAction(ActionEvent actionEvent) {

    }

    public void deleteBookAction(ActionEvent actionEvent) throws BookException {

    }
    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}
