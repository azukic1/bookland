package ba.unsa.etf.rpr.dao;

public class DaoFactory {
    private static final BookDao bookDao = new BookDaoSQLImpl();
    private static final ReservationDao reservationDao = new ReservationDaoSQLImpl();
    private static final UserDao userDao = new UserDaoSQLImpl();

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
