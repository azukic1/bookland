package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchByTitleController {
    public ListView listId;
    public Button borrowBookBttn;
    public Button cancelBttn;
    String title;
    private final BookManager bookManager = new BookManager();

    public SearchByTitleController(String t) {
        title = t;
    }

    @FXML
    public void initialize() throws BookException {
        List<Book> allBooks = FXCollections.observableList(bookManager.searchBooksByTitle(title));
        List<String> books = new ArrayList<>();
        for(int i = 0; i<allBooks.size(); i++) {
            books.add(allBooks.get(i).getTitle() + " " + allBooks.get(i).getAuthor());
        }
        listId.getItems().addAll(books);

    }

    public void borrowBookAction(ActionEvent actionEvent) {

    }

    public void cancelAction(ActionEvent actionEvent) {

    }
}

