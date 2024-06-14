import java.util.*;

public class BookManager {
	
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
		long startTime = System.currentTimeMillis();
		System.out.println("> startTime: " + startTime);
		
		for (Book book : bookList) {
			if (book.getId() == id) {
				long endTime = System.currentTimeMillis();
				System.out.println("> endTime: " + endTime);
				System.out.println("> Basic search operation performance: " + (endTime - startTime) + " ms\n");
				
				return book;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("> endTime: " + endTime);
		System.out.println("> Basic search operation performance (Book Not Found): " + (endTime - startTime) + " ms\n");
		
		return null;
		
	}
	
	public Book search_bs(int id) {
		long startTime = System.currentTimeMillis();
		System.out.println("> startTime: " + startTime);
		
		// bookList 를 id 값을 기준으로 정렬
		Collections.sort(bookList, Comparator.comparingInt(Book::getId));
		
		// 이진 탐색으로 책 탐색
		int start_idx = 0;
		int end_idx = bookList.size() - 1;
		while (start_idx <= end_idx) {
			int mid_idx = (start_idx + end_idx) / 2;
			Book mid_val = bookList.get(mid_idx);
			if (mid_val.getId() > id) {
				end_idx = mid_idx - 1;
			} else if (mid_val.getId() < id) {
				start_idx = mid_idx + 1;
			} else {
				long endTime = System.currentTimeMillis();
				System.out.println("> endTime: " + endTime);
				System.out.println("> Binary search operation performance: " + (endTime - startTime) + " ms\n");
				
				return mid_val;
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("> endTime: " + endTime);
		System.out.println("> Binary search operation performance (Book Not Found): " + (endTime - startTime) + " ms\n");
		
		// 찾는 id 값이 없을 시 null 값 리턴
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
