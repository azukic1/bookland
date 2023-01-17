package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

public class UserDaoSQLImpl implements UserDao{
    private static Connection connection;

    public UserDaoSQLImpl() {
        try {
            Properties p = new Properties();
            p.load(ClassLoader.getSystemResource("application.properties").openStream());
            String url = p.getProperty("db.connection_string");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
            UserDaoSQLImpl.connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User add(User item) {
        return null;
    }

    @Override
    public User update(User item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> searchByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        return null;
    }
}
