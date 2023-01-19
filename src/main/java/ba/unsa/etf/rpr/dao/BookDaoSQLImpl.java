package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao{

    public BookDaoSQLImpl() {
        super("books");
    }

    @Override
    public Book row2object(ResultSet rs) {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Book object) {
        return null;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return null;
    }
}
