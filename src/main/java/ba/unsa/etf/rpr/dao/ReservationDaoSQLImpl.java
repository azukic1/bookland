package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.ResultSet;
import java.util.Map;

public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{

    public ReservationDaoSQLImpl() {
        super("Reservations");
    }

    @Override
    public Reservation row2object(ResultSet rs)throws BookException {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Reservation object) throws BookException {
        return null;
    }

}
