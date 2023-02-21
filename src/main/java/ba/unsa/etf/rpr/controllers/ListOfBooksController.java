package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.ReservationManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.Reservation;
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

public class ListOfBooksController {
    public ListView listId;
    public Button borrowBookBttn;
    public Button cancelBttn;
    private int id;

    public ListOfBooksController(int id) {
        this.id = id;
    }
    public ListOfBooksController() {}

    private final BookManager bookManager = new BookManager();

    @FXML
    public void initialize() throws BookException {
        List<Book> allBooks = FXCollections.observableList(bookManager.getAll());
        List<String> books = new ArrayList<>();
        for(int i = 0; i<allBooks.size(); i++) {
            books.add(allBooks.get(i).getTitle() + " " + allBooks.get(i).getAuthor());

        }
        listId.getItems().addAll(books);
        System.out.println(id);
    }
    private final ReservationManager reservationManager = new ReservationManager();
    private final UserManager userManager = new UserManager();
    //private final BookManager bookManager = new BookManager();

    public void borrowBookAction(ActionEvent actionEvent) throws BookException {
        int in = listId.getSelectionModel().getSelectedIndex();
        Reservation r = new Reservation();
        List<User> users = FXCollections.observableList(userManager.getAll());
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == 5) r.setUser(users.get(i));
        }
        int a=0;
        List<Book> books = FXCollections.observableList(bookManager.getAll());
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == books.get(in).getId()) {
                r.setBook(books.get(i));
                a = books.get(in).getId();
            }
        }
        reservationManager.add(r);
        int n = books.get(in).getAvailableCopies();
        books.get(in).setAvailableCopies(n-1);
        bookManager.update(books.get(in));
        System.out.println(id);
    }

    public void cancelAction(ActionEvent actionEvent) {
        Stage stage = (Stage) listId.getScene().getWindow();
        stage.close();
    }
}
