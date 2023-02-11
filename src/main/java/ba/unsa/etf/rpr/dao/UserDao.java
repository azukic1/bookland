package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

public interface UserDao extends Dao<User> {

    List<User> searchByFirstName(String firstName) throws BookException;

    List<User> searchByLastName(String lastName) throws BookException;



}
