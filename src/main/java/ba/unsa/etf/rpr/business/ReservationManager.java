package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.util.List;

public class ReservationManager {
    public List<Reservation> getAll() throws BookException {
        return DaoFactory.reservationDao().getAll();
    }
    public void delete(int reservationId) throws BookException {
        DaoFactory.reservationDao().delete(reservationId);
    }
    public void update(Reservation r) throws BookException {
        DaoFactory.reservationDao().update(r);
    }
    public Reservation add(Reservation r) throws BookException {
        return DaoFactory.reservationDao().add(r);
    }
    public Reservation getById(int reservationId) throws BookException {
        return DaoFactory.reservationDao().getById(reservationId);
    }
}
