package ba.unsa.etf.rpr.dao;


import ba.unsa.etf.rpr.domain.User;

import java.util.List;

public interface UserDao extends Dao<User> {

    List<User> searchByFirstName(String firstName);

    List<User> searchByLastName(String lastName);



}
