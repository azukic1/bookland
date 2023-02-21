package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
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

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX controller
 *
 * @author Ajla Zukic
 */
public class BooksController {
    public Button addBookBttn;
    public Button deleteBookBttn;
    public Button cancelBttn;
    public ListView listId;

    private final BookManager bookManager = new BookManager();

    /**
     * class constructor
     */
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

    /**
     * This method open new window, admin can add new book
     * @param actionEvent
     * @throws IOException
     */
    public void addBookAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/addBook.fxml"));
        AddBookController controller = new AddBookController();
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
        stage.setOnHiding(x->{
            String s = controller.titleId.getText() + " " + controller.authorId.getText();
            listId.getItems().add(s);

        });
    }

    /**
     *
     * @param actionEvent
     * @throws BookException
     */
    public void deleteBookAction(ActionEvent actionEvent) throws BookException {
        List<Book> allBooks = FXCollections.observableList(bookManager.getAll());
        int i = listId.getSelectionModel().getSelectedIndex();
        bookManager.delete(allBooks.get(i).getId());
        listId.getItems().remove(i);
        listId.refresh();
    }

    /**
     * This method closes current window
     * @param actionEvent
     */
    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}
