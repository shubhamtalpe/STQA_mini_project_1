package standaloneApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    LibraryService libraryService;

    private int allowedNumberOfBooks;

    public TeacherService() {
        this.allowedNumberOfBooks = 5;
    }

    public int getAllowedNumberOfBooks() {
        return allowedNumberOfBooks;
    }

    public void setAllowedNumberOfBooks(int allowedNumberOfBooks) {
        this.allowedNumberOfBooks = allowedNumberOfBooks;
    }

    public String takeBook(String regId, String bookId, String date){
        return libraryService.issueBook(regId, bookId, date, allowedNumberOfBooks);
    }

    public String returnBook(String regId, String bookId, String date){
        return libraryService.returnBook(regId, bookId, date);
    }

    public void donateBook(String bookId, String bookName, String authorName, int numberOfCopies){
        libraryService.addBooksToInventory(bookId, bookName, authorName, numberOfCopies);
    }
}
