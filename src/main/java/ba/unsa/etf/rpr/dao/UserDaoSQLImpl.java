package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    private static UserDaoSQLImpl instance = null;

    private UserDaoSQLImpl() {
        super("Users");
    }

    public static UserDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new UserDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public List<User> searchByFirstName(String firstName) throws BookException{
        String query = "SELECT * FROM Users WHERE firstName=?";
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            stmt.setString(1,firstName);
            ResultSet rs = stmt.executeQuery();
            ArrayList<User> userList = new ArrayList<>();
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setFirstName(firstName);
                u.setLastName(rs.getString(3));
                u.setUsername(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setAdministrator(rs.getBoolean(6));
                userList.add(u);
            }
            return userList;

        }catch(SQLException e) {
            throw new BookException(e.getMessage(),e);
        }
    }

    @Override
    public List<User> searchByLastName(String lastName) throws BookException{
        String query = "SELECT * FROM Users WHERE lastName=?";
        try{
            PreparedStatement stmt = this.getConnection().prepareStatement(query);
            stmt.setString(1,lastName);
            ResultSet rs = stmt.executeQuery();
            ArrayList<User> userList = new ArrayList<>();
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt(1));
                u.setFirstName(rs.getString(2));
                u.setLastName(lastName);
                u.setUsername(rs.getString(4));
                u.setPassword(rs.getString(5));
                u.setAdministrator(rs.getBoolean(6));
                userList.add(u);
            }
            return userList;

        }catch(SQLException e) {
            throw new BookException(e.getMessage(), e);
        }
    }

    @Override
    public User row2object(ResultSet rs) throws BookException{
        try {
            User u = new User();
            u.setId(rs.getInt(1));
            u.setFirstName(rs.getString(2));
            u.setLastName(rs.getString(3));
            u.setUsername(rs.getString(4));
            u.setPassword(rs.getString(5));
            u.setAdministrator(rs.getBoolean(6));
            return u;
        }catch(Exception e) {
            throw new BookException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(User object)  {
        Map<String, Object> u = new TreeMap<String,Object>();
        u.put("id",object.getId());
        u.put("firstName",object.getFirstName());
        u.put("lastName",object.getLastName());
        u.put("username",object.getUsername());
        u.put("password",object.getPassword());
        return u;
    }
}
