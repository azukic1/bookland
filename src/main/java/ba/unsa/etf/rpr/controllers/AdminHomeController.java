package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class AdminHomeController {

    public Button usersBttn;
    public Button booksBttn;

    public AdminHomeController() {

    }

    public void booksBttnAction(ActionEvent actionEvent) throws IOException{
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/books.fxml"));
        BooksController controller = new BooksController();
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }

    public void usersBttnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/users.fxml"));
        UsersController controller = new UsersController();
        loader.setController(controller);
        stage.setTitle("");
        stage.setScene(new Scene(loader.load(), USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.setResizable(false);
        stage.show();
    }
}
