package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;
import java.util.Scanner;

/**
 * Business Logic Layer for Books
 * @author Ajla Zukic
 */

public class BookManager {
    public List<Book> getAll() throws BookException {
        return DaoFactory.bookDao().getAll();
    }
    public void delete(int bookId) throws BookException {
        DaoFactory.bookDao().delete(bookId);
    }
    public void update(Book b) throws BookException {
        DaoFactory.bookDao().update(b);
    }
    public Book add(Book b) throws BookException {
        return DaoFactory.bookDao().add(b);
    }
    public Book getById(int bookId) throws BookException {
        return DaoFactory.bookDao().getById(bookId);
    }

    /**
     * @param title
     * @return list of books
     * @throws BookException
     */
    public List<Book> searchBooksByTitle(String title) throws BookException {
        if (DaoFactory.bookDao().searchByTitle(title).size() == 0) throw new BookException("");
        return DaoFactory.bookDao().searchByTitle(title);
    }

    /**
     * @param author
     * @return list of books
     * @throws BookException
     */
    public List<Book> searchBooksByAuthor(String author) throws BookException {
        if (DaoFactory.bookDao().searchByAuthor(author).size() == 0) throw new BookException("");
        return DaoFactory.bookDao().searchByAuthor(author);

    }
}
