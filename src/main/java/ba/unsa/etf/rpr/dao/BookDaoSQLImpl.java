package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao{

    public BookDaoSQLImpl() {
        super("books");
    }

    @Override
    public Book row2object(ResultSet rs) throws BookException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Book object) throws BookException {
        return null;
    }

    @Override
    public List<Book> searchByAuthor(String author) throws BookException {
        return null;
    }

    @Override
    public List<Book> searchByTitle(String title) throws BookException {
        return null;
    }
}
