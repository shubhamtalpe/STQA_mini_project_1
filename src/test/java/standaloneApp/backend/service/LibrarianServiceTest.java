package standaloneApp.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class LibrarianServiceTest {
    @Autowired
    LibrarianService librarianService;

    @Test
    void issueMoreBooksThanAllowed() {
        assertEquals(librarianService.issueBook("0100", "00004", new java.util.Date().toString()), "Can not issue more books");
    }

    @Test
    void issueInvalidBook() {
        assertEquals(librarianService.issueBook("0100", "00005", new java.util.Date().toString()), "Invalid Book ID");
    }

    @Test
    void issueBookAlreadyIssued() {
        assertEquals(librarianService.issueBook("0010", "00001", new java.util.Date().toString()), "Book already issued");
    }

    @Test
    void issueBook() {
        assertEquals(librarianService.issueBook("0010", "00002", new java.util.Date().toString()), "Book Issued");
    }

    @Test
    void issueBookWhichIsNotAvailable() {
        assertEquals(librarianService.issueBook("0010", "00003", new java.util.Date().toString()), "Book Not Available");
    }

    @Test
    void returnBookWhichIsNotIssued() {
        assertEquals(librarianService.returnBook("0100", "00004", new java.util.Date().toString()), "Invalid Book ID");
    }

    @Test
    void returnBook() {
        assertEquals(librarianService.returnBook("0010", "00002", new java.util.Date().toString()), "Book Returned");
    }

    @Test
    void returnBookWhichIsAlreadyReturned() {
        assertEquals(librarianService.returnBook("0010", "00001", new java.util.Date().toString()), "Book Already returned");
    }


    //Done till here


    @Test
    void addBook() {
    }

    @Test
    void addBooksFromFile() {
    }

    @Test
    void addUser() {
    }

    @Test
    void addMultipleUserFromFile() {
    }

    @Test
    void showUserDetails() {
    }

    @Test
    void searchByBookId() {
    }

    @Test
    void searchByTitle() {
    }

    @Test
    void searchByAuthor() {
    }

    @Test
    void changeUserAccessLevel() {
    }
}