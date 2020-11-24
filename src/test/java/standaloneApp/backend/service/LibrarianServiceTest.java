package standaloneApp.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class LibrarianServiceTest {
    @Autowired
    LibrarianService librarianService;

    @Test
    void issueBook() {

    }
    @Test
    void returnBook() {

    }

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