package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

/**
 * Business Logic Layer for Users
 * @author Ajla Zukic
 */

public class UserManager {

    public List<User> getAll() throws BookException {
        return DaoFactory.userDao().getAll();
    }
    public void delete(int userId) throws BookException {
        DaoFactory.userDao().delete(userId);
    }
    public void update(User u) throws BookException {
        DaoFactory.userDao().update(u);
    }
    public User add(User u) throws BookException {
        return DaoFactory.userDao().add(u);
    }
    public User getById(int userId) throws BookException {
        return DaoFactory.userDao().getById(userId);
    }

    /**
     *
     * @param firstName
     * @return list of users
     * @throws BookException
     */
    public List<User> searchUsersByFirstName(String firstName) throws BookException {
        return DaoFactory.userDao().searchByFirstName(firstName);
    }

    /**
     * @param lastName
     * @return list of users
     * @throws BookException
     */
    public List<User> searchUsersByLastName(String lastName) throws BookException {
        return DaoFactory.userDao().searchByLastName(lastName);
    }

}
