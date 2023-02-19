package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

/**
 * Dao interface for User domain bean
 *
 * @author Ajla Zukic
 */
public interface UserDao extends Dao<User> {

    /**
     *
     * @param firstName
     * @return list of users
     * @throws BookException
     */
    List<User> searchByFirstName(String firstName) throws BookException;

    /**
     *
     * @param lastName
     * @return list of users
     * @throws BookException
     */
    List<User> searchByLastName(String lastName) throws BookException;



}
