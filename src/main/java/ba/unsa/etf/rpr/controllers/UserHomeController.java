package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class UserHomeController {
    public TextField titleId;
    public TextField authorId;
    public Button authorBttn;
    public Button titleBttn;
    public Button booksId;
    String author;

    public UserHomeController() {

    }


    @FXML
    public void initialize() {

    }

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
