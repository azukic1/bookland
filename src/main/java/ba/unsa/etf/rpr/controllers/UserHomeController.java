package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * JavaFX controller
 *
 * @author Ajla Zukic
 */
public class UserHomeController {
    public TextField titleId;
    public TextField authorId;
    public Button authorBttn;
    public Button titleBttn;
    public Button booksId;
    String author;

    /**
     * Class constructor
     */
    public UserHomeController() {

    }


    @FXML
    public void initialize() {

    }

    /**
     * This method puts results of a search into list view
     * @param actionEvent
     * @throws IOException
     * @throws BookException
     */
    public void searchByAuthorAction(ActionEvent actionEvent) throws IOException, BookException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listOfBooks.fxml"));
        SearchByAuthorController controller = new SearchByAuthorController(authorId.getText());
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }
    /**
     * This method puts results of a search into list view
     * @param actionEvent
     * @throws IOException
     * @throws BookException
     */
    public void searchByTitleAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listOfBooks.fxml"));
        SearchByTitleController controller = new SearchByTitleController(titleId.getText());
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();

    }

    /**
     * This method shows a list of books
     * @param actionEvent
     * @throws IOException
     */
    public void browseAllAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/listOfBooks.fxml"));
        ListOfBooksController controller = new ListOfBooksController();
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
