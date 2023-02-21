package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.dao.BookDao;
import ba.unsa.etf.rpr.dao.BookDaoSQLImpl;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
         System.out.println("Welcome to Bookland");
         Scanner input =  new Scanner(System.in);
         BookManager bookManager = new BookManager();
         while(true) {
             System.out.println("Choose an option from the following list");
             System.out.println("1 - Login as administrator");
             System.out.println("2 - Sign up");
             System.out.println("3 - Login");
             System.out.println("4 - List of all books");
             System.out.println("5 - Search for a book by title ");
             System.out.println("6 - Search for a book by author");
             System.out.println("7 - Close the application");
             int option = input.nextInt();
             if(option == 4) {
                 List<Book> books = FXCollections.observableList(bookManager.getAll());
                 for(int i = 0; i<books.size(); i++) {
                     System.out.println(books.get(i).getTitle() + " " + books.get(i).getAuthor());
                 }
             }
             if(option == 7) return;

         }
    }
}
