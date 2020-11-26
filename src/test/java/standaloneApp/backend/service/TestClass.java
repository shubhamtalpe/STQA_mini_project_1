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
class TestClass {
    @Autowired
    LibrarianService librarianService;
    @Autowired
    LoginService loginService;

    @Test
    void checkValidCredentials() {
        assertTrue(loginService.checkCredentials("admin", "admin@123"));
    }

    @Test
    void checkInvalidCredentials() {
        assertFalse(loginService.checkCredentials("admin", "admin123"));
    }

    @Test
    void issueMoreBooksThanAllowed() {
        assertEquals(librarianService.issueBook("0100", "00004", new java.util.Date().toString()), "Can not issue more books");
    }

    @Test
    void issueInvalidBook() {
        assertEquals(librarianService.issueBook("0102", "00008", new java.util.Date().toString()), "Invalid Book ID");
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
        assertEquals(librarianService.returnBook("0102", "00004", new java.util.Date().toString()), "Invalid Book ID");
    }

    @Test
    void returnBook() {
        assertEquals(librarianService.returnBook("0010", "00002", new java.util.Date().toString()), "Book Returned");
    }

    @Test
    void returnBookWhichIsAlreadyReturned() {
        assertEquals(librarianService.returnBook("0010", "00004", new java.util.Date().toString()), "Book Already returned");
    }

    @Test
    void addBook() {
        assertEquals(librarianService.addBook("11111", "Test Book", "Test Author", 1), "Book Added");
    }

    @Test
    void addBooksFromInvalidFile() {
        assertEquals(librarianService.addBooksFromFile(""), "Error While Reading file");
    }

    @Test
    void addBooksFromFile() {
        assertEquals(librarianService.addBooksFromFile("D:\\Book.csv"), "Books Added");
    }

    @Test
    void addUser() {
        assertEquals(librarianService.addUser("1111", "Test User", 3), "User added");
    }

    @Test
    void addMultipleUserFromInvalidFile() {
        assertEquals(librarianService.addMultipleUserFromFile(""), "Error While Reading file");
    }

    @Test
    void addMultipleUserFromFile() {
        assertEquals(librarianService.addMultipleUserFromFile("D:\\User.csv"), "Users Added");
    }

    @Test
    void changeInvalidUserAccessLevel() {
        assertEquals(librarianService.changeUserAccessLevel("0",3), "Invalid User ID");
    }

    @Test
    void changeUserAccessLevel() {
        assertEquals(librarianService.changeUserAccessLevel("0102", 3), "Access Level Changed");
    }
}