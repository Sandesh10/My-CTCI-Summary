/*
Online Book Reader: 
Design the data structures for an online book reader system.
*/

Basic Functionality:
- user membership creation and extension
- searching the database of books
- reading a book
- only one active user at a time
- only one active book by this user.

Objects: User, Book and Library

public class OnlineReaderSystem {
	private Library library;
	private UserManager userManager;
	private Display display;

	private Book activeBook;
	private User activeUser;

	public OnlineReaderSystem(){
		userManager = new UserManager();
		library = new Library();
		display = new Display();
	}

	public Library getLibrary() { return library; }
	public UserManager getUserManager() {return userManager; }

	public Display getDisplay() {return display; }
	public Book getActiveBook() {return activeBook; }
	public void setActiveBook(Book b){ 
		activeBook = book;
		display.displayBook(book);
	}

	public void setActiveUser(User u){ 
		activeUser = u;
		display.displayUser(u);
	}	
}

// separate classes to handle user manager, library and the display
private class Library {
	private HashMap<Integer, Book> books;

	public Book addBook(int id, String details){
		if (books.containsKey(id)){
			return null;
		}
		Book book =  new Book(id, details);
		books.put(id, book);
		return book;
	}

	public boolean remove(Book b) {return remove(b.getID());}
	public boolean remove(int id){
		if (!books.containsKey(id)) {return false;}
		books.remove(id);
		return true;
	}

	public Book find(int id){
		return books.get(id);
	}
}

public class UserManager {
	private HashMap<Integer, User> users;

	public User addUser(int id, String details, int accountType) {
		if (users.containsKey(id)){
			return null;
		}
		User user = new User(id, details, accountType);
		users.put(id, user);
		return user;
	}

	public User find(int id){}
	public boolean remove(User user){}
	public boolean remove(int id){}
}

public class Display {
	private Book activeBook;
	private User activeUser;
	private int pageNumber =0;

	public void displayUser(User user){
		activeUser = user;
		refreshUsername();
	}

	public void displayBook(Book book){
		pageNumber = 0;
		activeBook = book;

		refreshTitle();
		refreshDetails();
		refreshPage();
	}

	public void turnPageForward() {
		pageNumber++;
		refreshPage();
	}

	/*
	Other functionalities:
	refreshUsername();
	refreshTitle();
	refreshDetails();
	refreshPage();
	*/
}

public class Book  {
	private int bookId;
	private String details;

	public Book(int id, String det){}

	/*
	Other functions:
	getID();
	setID();
	getDetails();
	setDetails(String d);
	*/
}

public class User {
	private int userId;
	private String details;
	private int accountType;

	public void renewMembership(){}

	public User(int id, String details, int accountType){}
	/*
	Other functions:
	setDetails(String details);
	getID()
	setID()
	getDetails()
	getAccountType()
	setAccountType()
	*/
}