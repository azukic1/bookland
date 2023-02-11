package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    public UserDaoSQLImpl() {
        super("users");
    }

    @Override
    public List<User> searchByFirstName(String firstName) throws BookException{
        return null;
    }

    @Override
    public List<User> searchByLastName(String lastName) throws BookException{
        return null;
    }

    @Override
    public User row2object(ResultSet rs) throws BookException{
        return null;
    }

    @Override
    public Map<String, Object> object2row(User object) throws BookException {
        return null;
    }
}
