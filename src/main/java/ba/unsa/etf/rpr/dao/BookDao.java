package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

public interface BookDao extends Dao<Book> {

    List<Book> searchByAuthor(String author) throws BookException;
    List<Book> searchByTitle(String title) throws BookException;

}
