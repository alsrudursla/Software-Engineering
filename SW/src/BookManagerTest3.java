import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest3 {

    private BookManager bookManager;

    @BeforeEach
    void setUp() throws Exception {
        bookManager = new BookManager();
    }
    
    @Test
    void testAddBook() {
        Book book1 = bookManager.addBook(1, "자바 기초", "Jane", 2021);
        assertNotNull(book1);
        System.out.println("Book{id: " + book1.getId() + ", 제목: " + book1.getTitle() + ", 저자: " + book1.getAuthor() + ", 출판년도: " + book1.getYear() + "} 도서가 추가되었습니다.");

        Book duplicateBook = bookManager.addBook(1, "자바 기초", "Jane", 2021);
        assertNull(duplicateBook);
        System.out.println("해당 ID(" + 1 + ") 는 이미 존재합니다.");
    }

    @Test
    void testSearchBook() {
        bookManager.addBook(1, "자바 기초", "Jane", 2021);
        Book book = bookManager.searchBook(1);
        assertNotNull(book);
        System.out.println("검색 결과:\nBook{id: " + book.getId() + ", 제목: " + book.getTitle() + ", 저자: " + book.getAuthor() + ", 출판년도: " + book.getYear() + "}");
    }

    @Test
    void testSearch_bs() {
        bookManager.addBook(1, "자바 기초", "Jane", 2021);
        bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);
        bookManager.addBook(3, "분산 컴퓨팅", "Yoon", 2024);

        Book book1 = bookManager.search_bs(1);
        assertNotNull(book1);
        System.out.println("검색 결과:\nBook{id: " + book1.getId() + ", 제목: " + book1.getTitle() + ", 저자: " + book1.getAuthor() + ", 출판년도: " + book1.getYear() + "}");

        Book book2 = bookManager.search_bs(2);
        assertNotNull(book2);
        System.out.println("검색 결과:\nBook{id: " + book2.getId() + ", 제목: " + book2.getTitle() + ", 저자: " + book2.getAuthor() + ", 출판년도: " + book2.getYear() + "}");

        Book book3 = bookManager.search_bs(3);
        assertNotNull(book3);
        System.out.println("검색 결과:\nBook{id: " + book3.getId() + ", 제목: " + book3.getTitle() + ", 저자: " + book3.getAuthor() + ", 출판년도: " + book3.getYear() + "}");

        Book bookNotFound = bookManager.search_bs(4);
        assertNull(bookNotFound);
        System.out.println("검색된 도서가 없습니다.");
    }

    @Test
    void testRemoveBook() {
        bookManager.addBook(1, "자바 기초", "Jane", 2021);
        bookManager.addBook(2, "소프트웨어 공학", "Tom", 2014);

        Book removedBook = bookManager.removeBook(1);
        assertNotNull(removedBook);
        System.out.println("Book{id: " + removedBook.getId() + ", 제목: " + removedBook.getTitle() + ", 저자: " + removedBook.getAuthor() + ", 출판년도: " + removedBook.getYear() + "} 도서를 삭제하였습니다.");

        Book bookNotFound = bookManager.removeBook(1);
        assertNull(bookNotFound);
        System.out.println("해당 ID(" + 1 + ")의 도서를 찾을 수 없습니다.");
    }
}
