package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Idable;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public abstract class AbstractDao <T extends Idable> implements Dao<T> {
    private static Connection connection = null;
    private String tableName;

    public AbstractDao(String tableName) {
        this.tableName = tableName;
        createConnection();
    }

    private static void createConnection(){
        if(AbstractDao.connection==null) {
            try {
                Properties p = new Properties();
                p.load(ClassLoader.getSystemResource("application.properties").openStream());
                String url = p.getProperty("db.connection_string");
                String username = p.getProperty("db.username");
                String password = p.getProperty("db.password");
                AbstractDao.connection = DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public static Connection getConnection(){
        return AbstractDao.connection;
    }
    public abstract T row2object(ResultSet rs);
    public abstract Map<String, Object> object2row(T object);

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public T add(T item) {
        return null;
    }

    @Override
    public T update(T item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<T> getAll() {
        return null;
    }
}
