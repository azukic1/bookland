package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.User;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class UserDaoSQLImpl extends AbstractDao<User> implements UserDao{

    public UserDaoSQLImpl() {
        super("users");
    }

    @Override
    public List<User> searchByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> searchByLastName(String lastName) {
        return null;
    }

    @Override
    public User row2object(ResultSet rs) {
        return null;
    }

    @Override
    public Map<String, Object> object2row(User object) {
        return null;
    }
}
