package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;

import java.util.List;

public interface BookDao extends Dao<Book> {

    List<Book> searchByAuthor(String author);
    List<Book> searchByTitle(String title);

}
