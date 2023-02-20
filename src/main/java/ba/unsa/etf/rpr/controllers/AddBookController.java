package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBookController {

    public TextField titleId;
    public TextField authorId;
    public TextField copiesId;
    public Button addBookBttn;

    public AddBookController() {

    }
    private final BookManager bookManager = new BookManager();

    public void addBookAction(ActionEvent actionEvent) throws BookException {
        Book b = new Book();
        b.setTitle(titleId.getText());
        b.setAuthor(authorId.getText());
        String number = copiesId.getText();
        b.setNumberOfCopies(Integer.parseInt(number));
        b.setAvailableCopies(Integer.parseInt(number));
        bookManager.add(b);
        Stage s = (Stage)addBookBttn.getScene().getWindow();
        s.close();

    }
}
