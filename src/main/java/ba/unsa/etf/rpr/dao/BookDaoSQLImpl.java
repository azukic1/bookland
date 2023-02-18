package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BookDaoSQLImpl extends AbstractDao<Book> implements BookDao{

    private static BookDaoSQLImpl instance = null;
    private BookDaoSQLImpl() {
        super("Books");
    }

    public static BookDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new BookDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Book row2object(ResultSet rs) throws BookException {
        try{
            Book b = new Book();
            b.setId(rs.getInt(1));
            b.setTitle(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setNumberOfCopies(rs.getInt(4));
            b.setAvailableCopies(rs.getInt(5));
            return b;
        }catch(Exception e) {
            throw new BookException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Book object){
        Map<String, Object> b = new TreeMap<String,Object>();
        b.put("id",object.getId());
        b.put("title",object.getTitle());
        b.put("author",object.getAuthor());
        b.put("numberOfCopies",object.getNumberOfCopies());
        b.put("availableCopies",object.getAvailableCopies());
        return b;
    }

    @Override
    public List<Book> searchByAuthor(String author) throws BookException {
        String query = "SELECT * FROM Books WHERE author LIKE concat('%', ?, '%')";
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            stmt.setString(1,author);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Book> bookList = new ArrayList<>();
            while(rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setTitle(rs.getString(2));
                b.setAuthor(author);
                b.setNumberOfCopies(rs.getInt(4));
                b.setAvailableCopies(rs.getInt(5));
                bookList.add(b);
            }
            return bookList;

        }catch(SQLException e) {
            throw new BookException(e.getMessage(),e);
        }
    }

    @Override
    public List<Book> searchByTitle(String title) throws BookException{
        String query = "SELECT * FROM Books WHERE title LIKE concat('%', ?, '%')";
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            stmt.setString(1,title);
            ResultSet rs = stmt.executeQuery();
            ArrayList<Book> bookList = new ArrayList<>();
            while(rs.next()) {
                Book b = new Book();
                b.setId(rs.getInt(1));
                b.setTitle(title);
                b.setAuthor(rs.getString(3));
                b.setNumberOfCopies(rs.getInt(4));
                b.setAvailableCopies(rs.getInt(5));
                bookList.add(b);
            }
            return bookList;

        }catch(SQLException e) {
            throw new BookException(e.getMessage(),e);
        }
    }
}
