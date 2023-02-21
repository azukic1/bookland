package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.dao.BookDao;
import ba.unsa.etf.rpr.dao.BookDaoSQLImpl;
import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
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
         UserManager userManager =  new UserManager();
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
             if(option == 2) {
                 User u = new User();
                 Scanner input3 = new Scanner(System.in);
                 String name=" ", lasName="", username="", password="";
                 System.out.println("Enter your name");
                 name = input3.nextLine();
                 System.out.println("Enter your last name");
                 lasName = input3.nextLine();
                 System.out.println("Enter your username");
                 username = input3.nextLine();
                 System.out.println("Enter your password");
                 password = input3.nextLine();
                 u.setFirstName(name);
                 u.setLastName(lasName);
                 u.setUsername(username);
                 u.setPassword(password);
                 userManager.add(u);
             }
             if(option == 4) {
                 List<Book> books = FXCollections.observableList(bookManager.getAll());
                 for(int i = 0; i<books.size(); i++) {
                     System.out.println(books.get(i).getTitle() + " " + books.get(i).getAuthor());
                 }
             }
             if(option == 5) {
                 String title = "";
                 System.out.println("Enter title");
                 Scanner input2 =  new Scanner(System.in);
                 title = input2.nextLine();
                 try {
                     List<Book> books = FXCollections.observableList(bookManager.searchBooksByTitle(title));
                     for (int i = 0; i < books.size(); i++) {
                         System.out.println(books.get(i).getTitle() + " " + books.get(i).getAuthor());
                     }
                 }catch (BookException b) {
                     System.out.println("There is no book in the list");
                 }
             }
             if(option == 6) {
                 String author = "";
                 System.out.println("Enter author name");
                 Scanner input1 =  new Scanner(System.in);
                 author = input1.nextLine();
                 try {
                     List<Book> books = FXCollections.observableList(bookManager.searchBooksByAuthor(author));
                     for (int i = 0; i < books.size(); i++) {
                         System.out.println(books.get(i).getTitle() + " " + books.get(i).getAuthor());
                     }
                 }catch (BookException b) {
                     System.out.println("There is no book in the list");
                 }
             }
             if(option == 7) return;

         }
    }
}
