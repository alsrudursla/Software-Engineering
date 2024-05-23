import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest2 extends BookManager {
	private BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	}

	@Test
	void testAddBook() {
		Book book = bookManager.addBook(5, "소프트웨어 공학", "Young", 2024);
		assertEquals(5,book.getId());
		assertEquals("소프트웨어 공학", book.getTitle());
        assertEquals("Young", book.getAuthor());
        assertEquals(2024, book.getYear());
		System.out.println("Book{id: "+book.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}도서가 추가되었습니다.");
	}
	
	@Test
	void testAddExistingBook() {
		Book book = bookManager.addBook(3, "자료구조", "Can", 2020);
		Book book2 = bookManager.addBook(3, "자료구조", "Can", 2020);
		assertEquals(null,book2);
		System.out.println("해당 ID("+book.getId()+") 는 이미 존재합니다.");
	}

	@Test
	void testSearchBook() {
		System.out.println("검색 결과:");
		Book book = bookManager.addBook(2, "알고리즘", "Carol", 2021);
		Book book2 = bookManager.searchBook(2);
		assertEquals(2,book2.getId());
		assertEquals("알고리즘", book2.getTitle());
        assertEquals("Carol", book2.getAuthor());
        assertEquals(2021, book2.getYear());
		System.out.println("Book{id: "+book2.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}");	
	}
	
	@Test
	void testSearchNotExistingBook() {
		Book book = bookManager.addBook(6, "C++", "Bob", 2000);
		Book book2 = bookManager.searchBook(3);
		assertEquals(null, book2);
		System.out.println("검색된 도서가 없습니다.");
	}

	@Test
	void testRemoveBook() {
		Book book = bookManager.addBook(7, "메타버스", "Park", 1988);
		Book book2 = bookManager.removeBook(7);
		assertEquals(book.getId(), book2.getId());
		System.out.println("Book{id: "+book.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}도서를 삭제하였습니다.");	
	}
	
	@Test
	void testRemoveNotExistingBook() {
		Book book = bookManager.addBook(10, "정보보안", "Lee", 1888);
		Book book2 = bookManager.removeBook(5);
		assertEquals(null, book2);
		System.out.println("해당 ID("+book.getId()+")의 도서를 찾을 수 없습니다.");	
	}

}
