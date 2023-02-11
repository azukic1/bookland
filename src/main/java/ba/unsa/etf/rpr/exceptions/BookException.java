package ba.unsa.etf.rpr.exceptions;

public class BookException extends Exception{

    public BookException(String msg, Exception reason){
        super(msg, reason);
    }

    public BookException(String msg){
        super(msg);
    }

}
