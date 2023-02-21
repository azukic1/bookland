package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.BookManager;
import ba.unsa.etf.rpr.business.UserManager;
import ba.unsa.etf.rpr.domain.Book;
import ba.unsa.etf.rpr.domain.User;
import ba.unsa.etf.rpr.exceptions.BookException;
import javafx.collections.FXCollections;

import java.util.List;
import java.util.Scanner;

/**
 * Main class
 *
 * @author Ajla Zukic
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
             if(option == 1) {
                 List<User> users = FXCollections.observableList(userManager.getAll());
                 String username = "", password=" ";
                 Scanner input4 = new Scanner(System.in);
                 System.out.println("Enter username");
                 username = input4.nextLine();
                 int id = 0;
                 boolean valid = true;
                 do {
                     for (int i = 0; i < users.size(); i++) {
                         if (username.equals(users.get(i).getUsername())) {
                             id = users.get(i).getId();
                             break;
                         }
                     }
                     if(id == 0) {
                         System.out.println("Username not found, try again");
                         valid = false;
                         username = input4.nextLine();
                     }
                     else valid = true;
                 }while(!valid);
                 boolean valid1 = false;
                 System.out.println("Enter password");
                 do {
                     password = input4.nextLine();
                     if (password.equals(userManager.getById(id).getPassword()))  {
                         valid1 = true;
                     }
                     else System.out.println("Invalid password, try again");
                 }while (!valid1);
                 Scanner input5 = new Scanner(System.in);
                 if(userManager.getById(id).isAdministrator() == 1) {
                     System.out.println("Welcome back " + userManager.getById(id).getFirstName());
                     while(true) {
                         System.out.println("Choose an option from the following list");
                         System.out.println("1 - Add a user");
                         System.out.println("2 - Delete a user");
                         System.out.println("3 - Add a book");
                         System.out.println("4 - Delete a book");
                         System.out.println("5 - Close the application");
                         int option2 = input5.nextInt();
                         if(option2 == 1) {
                             User u = new User();
                             Scanner input3 = new Scanner(System.in);
                             String name=" ", lastName="", usernamee="", passwordd="";
                             System.out.println("First name");
                             name = input3.nextLine();
                             System.out.println("Last name");
                             lastName = input3.nextLine();
                             System.out.println("Username");
                             usernamee = input3.nextLine();
                             boolean val = true;
                             do {
                                 valid = true;
                                 List<User> list = FXCollections.observableList(userManager.getAll());
                                 for (int i = 0; i < list.size(); i++) {
                                     if (usernamee.equals(list.get(i).getUsername())) {
                                         val = false;
                                         System.out.println("Invalid username, try again");
                                         usernamee = input3.nextLine();
                                     }
                                 }
                                 if(usernamee.length()<5) {
                                     val= false;
                                     System.out.println("Invalid username, try again");
                                     usernamee = input3.nextLine();
                                 }
                             }while(!val);
                             System.out.println("Password");
                             passwordd = input3.nextLine();
                             while(passwordd.length()<8) {
                                 System.out.println("Invalid password, try again");
                                 passwordd = input3.nextLine();
                             }
                             u.setFirstName(name);
                             u.setLastName(lastName);
                             u.setUsername(usernamee);
                             u.setPassword(passwordd);
                             userManager.add(u);

                         }
                         if(option2 == 2) {
                             boolean v = false;
                             List<User> user = FXCollections.observableList(userManager.getAll());
                             Scanner input6 = new Scanner(System.in);
                             int indeks = 0;
                             System.out.println("Id:");
                             indeks = input6.nextInt();
                             for(int i = 0; i<user.size(); i++) {
                                 if(user.get(i).getId()==indeks) v = true;
                             }if(v)
                             userManager.delete(indeks);
                             else System.out.println("User not found");
                         }
                         if(option2 == 3) {
                             Scanner input6 = new Scanner(System.in);
                             String title="", author="";
                             int number=0;
                             System.out.println("Title:");
                             title = input6.nextLine();
                             System.out.println("Author:");
                             author = input6.nextLine();
                             System.out.println("Number of copies:");
                             number = input6.nextInt();
                             Book b = new Book();
                             b.setTitle(title);
                             b.setAuthor(author);
                             b.setNumberOfCopies(number);
                             b.setAvailableCopies(number);
                             bookManager.add(b);
                         }
                         if(option2 == 4) {
                             Scanner input6 = new Scanner(System.in);
                             int i = 0;
                             System.out.println("Id:");
                             i = input6.nextInt();
                             bookManager.delete(i);
                         }
                         if(option2 == 5) return;
                     }
                 }
                 else System.out.println("You don't have administrator access");

             }
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
                 boolean valid = true;
                 do {
                     valid = true;
                     List<User> users = FXCollections.observableList(userManager.getAll());
                     for (int i = 0; i < users.size(); i++) {
                         if (username.equals(users.get(i).getUsername())) {
                             valid = false;
                             System.out.println("Invalid username, try again");
                             username = input3.nextLine();
                         }
                     }
                     if(username.length()<5) {
                         valid = false;
                         System.out.println("Invalid username, try again");
                         username = input3.nextLine();
                     }
                 }while(!valid);
                 System.out.println("Enter your password");
                 password = input3.nextLine();
                 while(password.length()<5) {
                     System.out.println("Invalid password, try again");
                     password = input3.nextLine();
                 }

                 u.setFirstName(name);
                 u.setLastName(lasName);
                 u.setUsername(username);
                 u.setPassword(password);
                 userManager.add(u);
             }
             if(option == 3) {
                 List<User> users = FXCollections.observableList(userManager.getAll());
                 String username = "", password=" ";
                 Scanner input4 = new Scanner(System.in);
                 System.out.println("Enter username");
                 username = input4.nextLine();
                 int id = 0;
                 boolean valid = true;
                 do {
                     for (int i = 0; i < users.size(); i++) {
                         if (username.equals(users.get(i).getUsername())) {
                             id = users.get(i).getId();
                             break;
                         }
                     }
                         if(id == 0) {
                             System.out.println("Username not found, try again");
                             valid = false;
                             username = input4.nextLine();
                         }
                         else valid = true;
                 }while(!valid);
                 boolean valid1 = false;
                 System.out.println("Enter password");
                 do {
                     password = input4.nextLine();
                         if (password.equals(userManager.getById(id).getPassword()))  {
                             valid1 = true;
                         }
                         else System.out.println("Invalid password, try again");
                 }while (!valid1);

                 System.out.println("Welcome back " + userManager.getById(id).getFirstName());
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
