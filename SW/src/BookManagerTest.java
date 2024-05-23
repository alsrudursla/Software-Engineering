import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	private BookManager bookManager;

	@BeforeEach
	void setUp() throws Exception {
		bookManager = new BookManager();
	}

	@Test
	void testAddBook() {
		Book book = bookManager.addBook(1, "자바 기초", "Jane", 2021);
		assertEquals(1,book.getId());
		assertEquals("자바 기초", book.getTitle());
        assertEquals("Jane", book.getAuthor());
        assertEquals(2021, book.getYear());
		System.out.println("Book{id: "+book.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}도서가 추가되었습니다.");
	}
	
	@Test
	void testAddExistingBook() {
		Book book = bookManager.addBook(1, "자바 기초", "Jane", 2021);
		Book book2 = bookManager.addBook(1, "자바 기초", "Jane", 2021);
		assertEquals(null,book2);
		System.out.println("해당 ID("+book.getId()+") 는 이미 존재합니다.");
	}

	@Test
	void testSearchBook() {
		System.out.println("검색 결과:");
		Book book = bookManager.addBook(1, "자바 기초", "Jane", 2021);
		Book book2 = bookManager.searchBook(1);
		assertEquals(1,book2.getId());
		assertEquals("자바 기초", book2.getTitle());
        assertEquals("Jane", book2.getAuthor());
        assertEquals(2021, book2.getYear());
		System.out.println("Book{id: "+book2.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}");	
	}
	
	@Test
	void testSearchNotExistingBook() {
		Book book = bookManager.addBook(2, "파이썬", "Judy", 2018);
		Book book2 = bookManager.searchBook(1);
		assertEquals(null, book2);
		System.out.println("검색된 도서가 없습니다.");
	}

	@Test
	void testRemoveBook() {
		Book book = bookManager.addBook(1, "자바 기초", "Jane", 2021);
		Book book2 = bookManager.removeBook(1);
		assertEquals(book.getId(), book2.getId());
		System.out.println("Book{id: "+book.getId()+", 제목: "+book.getTitle()+", 저자: "+book.getAuthor()+", 출판년도: "+book.getYear()+"}도서를 삭제하였습니다.");	
	}
	
	@Test
	void testRemoveNotExistingBook() {
		Book book = bookManager.addBook(2, "파이썬", "Judy", 2018);
		Book book2 = bookManager.removeBook(1);
		assertEquals(null, book2);
		System.out.println("해당 ID("+book.getId()+")의 도서를 찾을 수 없습니다.");	
	}

}
