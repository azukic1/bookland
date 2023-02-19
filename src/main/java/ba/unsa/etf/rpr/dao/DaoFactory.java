package ba.unsa.etf.rpr.dao;

/**
 * Factory method for singleton implementation of DAOs
 *
 * @author Ajla Zukic
 */
public class DaoFactory {
    private static final BookDao bookDao =  BookDaoSQLImpl.getInstance();
    private static final ReservationDao reservationDao = ReservationDaoSQLImpl.getInstance();
    private static final UserDao userDao = UserDaoSQLImpl.getInstance();

    private DaoFactory() {

    }
    public static BookDao bookDao() {
        return bookDao;
    }

    public static ReservationDao reservationDao() {
        return reservationDao;
    }
    public static UserDao userDao() {
        return userDao;
    }

}
