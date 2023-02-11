package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

public interface Dao<T> {

    T getById(int id) throws BookException;

    T add(T item) throws BookException;

    T update(T item) throws BookException;

    void delete(int id) throws BookException;

    List<T> getAll() throws BookException;

}
