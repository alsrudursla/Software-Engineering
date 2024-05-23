import java.util.*;

public class BookManager extends Book {
	
	private List<Book> bookList;
	
	public BookManager() {
		this.bookList = new ArrayList<>();
	}
	
	public Book addBook(int id, String title, String author, int year) {
		for (Book b : bookList) {
			if (b.getId() == id) {
				return null;
			}
		}
		Book book = new Book(id, title, author, year);
		bookList.add(book);
		return book;
	}
	
	public Book searchBook(int id) {
		for (Book book : bookList) {
			if (book.getId() == id) {
				return book;
			}
		}
		return null;
		
	}
	
	public Book removeBook(int id) {
		for (Book b : bookList) {
			if (b.getId() == id) {
				Book tmp = b;
				bookList.remove(b);
				return tmp;
			}
		}
		return null;
	}

}
