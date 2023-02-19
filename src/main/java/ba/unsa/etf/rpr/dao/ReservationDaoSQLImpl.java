package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Reservation;
import ba.unsa.etf.rpr.exceptions.BookException;

import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * MySQL implementation of the DAO
 * @author Ajla Zukic
 */

public class ReservationDaoSQLImpl extends AbstractDao<Reservation> implements ReservationDao{

    private static ReservationDaoSQLImpl instance = null;

    private ReservationDaoSQLImpl() {
        super("Reservations");
    }
    public static ReservationDaoSQLImpl getInstance(){
        if(instance==null)
            instance = new ReservationDaoSQLImpl();
        return instance;
    }

    public static void removeInstance(){
        if(instance!=null)
            instance=null;
    }

    @Override
    public Reservation row2object(ResultSet rs) throws BookException {

        try{
            Reservation r = new Reservation();
            r.setId(rs.getInt(1));
            r.setBook(DaoFactory.bookDao().getById(rs.getInt(2)));
            r.setUser(DaoFactory.userDao().getById(rs.getInt(3)));
            return r;

        }catch(Exception e){
            throw new BookException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Reservation object) {
        Map<String, Object> r = new TreeMap<String,Object>();
        r.put("id",object.getId());
        r.put("idUser",object.getUser().getId());
        r.put("idBook",object.getBook().getId());
        return r;
    }

}
