package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;
/**
 * Dao interface for Book domain bean
 *
 * @author Ajla Zukic
 */

public interface BookDao extends Dao<Book> {

    /**
     * @param author
     * @return list of books
     * @throws BookException
     */
    List<Book> searchByAuthor(String author) throws BookException;

    /**
     * @param title
     * @return list of books
     * @throws BookException
     */
    List<Book> searchByTitle(String title) throws BookException;

}
