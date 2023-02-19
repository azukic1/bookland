package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

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
    public List<Book> searchBooksByTitle(String title) throws BookException {
        return DaoFactory.bookDao().searchByTitle(title);
    }
    public List<Book> searchBooksByAuthor(String author) throws BookException {
        return DaoFactory.bookDao().searchByAuthor(author);
    }
}
