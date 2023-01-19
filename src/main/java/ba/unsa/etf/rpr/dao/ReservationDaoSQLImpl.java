package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;

import java.sql.ResultSet;
import java.util.Map;

public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{

    public ReservationDaoSQLImpl() {
        super("reservations");
    }

    @Override
    public Reservation row2object(ResultSet rs) {
        return null;
    }

    @Override
    public Map<String, Object> object2row(Reservation object) {
        return null;
    }

}
