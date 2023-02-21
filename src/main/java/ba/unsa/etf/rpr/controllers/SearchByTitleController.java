package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajla Zukic
 */
public class SearchByTitleController {
    public ListView listId;
    public Button borrowBookBttn;
    public Button cancelBttn;
    String title;
    private final BookManager bookManager = new BookManager();

    /**
     * class constructor
     * @param t
     */
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
    /**
     * Method that closes current window
     * @param actionEvent
     */
    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}

