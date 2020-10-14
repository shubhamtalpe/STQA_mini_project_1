package standaloneApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import standaloneApp.entity.BookIssueRecords;
import standaloneApp.entity.BookReturnRecords;
import standaloneApp.entity.Inventory;
import standaloneApp.repository.BookIssueRecordsRepository;
import standaloneApp.repository.BookReturnRecordsRepository;
import standaloneApp.repository.InventoryRepository;

import java.util.List;

@Service
public class LibraryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BookIssueRecordsRepository bookIssueRecordsRepository;

    @Autowired
    private BookReturnRecordsRepository bookReturnRecordsRepository;

    public List<BookIssueRecords> getListOfIssuedBooks(String regId){
        return bookIssueRecordsRepository.findByRegId(regId);
    }

    public List<BookReturnRecords> getListOfReturnedBooks(String regId){
        return bookReturnRecordsRepository.findByRegId(regId);
    }

    public void addBooksToInventory(String bookId, String bookName, String authorName, int numberOfCopies){
        Inventory inventory = inventoryRepository.findById(bookId).orElse(null);
        if(inventory == null){
            inventoryRepository.save(new Inventory(bookId, bookName, authorName, numberOfCopies, numberOfCopies));
        }
        else{
            inventory.setTotalCopies(inventory.getTotalCopies() + numberOfCopies);
            inventory.setAvailableCopies(inventory.getAvailableCopies() + numberOfCopies);
            inventoryRepository.save(inventory);
        }
    }

    public String issueBook(String regId, String bookId, String date, int allowedNumberOfBooks){
        Inventory book = inventoryRepository.findById(bookId).orElse(null);
        List<BookIssueRecords> issuedBooks = bookIssueRecordsRepository.findByRegIdAndIsReturned(regId, false);
        List<BookIssueRecords> bookIssue = bookIssueRecordsRepository.findByRegIdAndBookId(regId, bookId);
        if(issuedBooks.size() >= allowedNumberOfBooks){
            return "Can not issue more books";
        }
        if(book == null){
            return "Invalid Book ID";
        }
        if(bookIssue != null) {
            for (BookIssueRecords bi : bookIssue) {
                if (!bi.isReturned()) {
                    return "Book already issued";
                }
            }
        }
        if(book.isAvailable()){
            book.issueBook();
            inventoryRepository.save(book);
            bookIssueRecordsRepository.save(new BookIssueRecords(regId, bookId, date));
            return "Book Issued";
        }
        else{
            return "Book Not Available";
        }
    }

    public String returnBook(String regId, String bookId, String date){
        Inventory book = inventoryRepository.findById(bookId).orElse(null);
        List<BookIssueRecords> bookIssue = bookIssueRecordsRepository.findByRegIdAndBookId(regId, bookId);
        if(book == null || bookIssue==null){
            return "Invalid Book ID";
        }
        String issueTransacId = null;
        for (BookIssueRecords bi : bookIssue) {
            if (!bi.isReturned()) {
                issueTransacId = bi.getIssueTransacId();
            }
        }
        if(issueTransacId == null){
            return "Book Already returned";
        }
        BookIssueRecords issueRecord = bookIssueRecordsRepository.findById(issueTransacId).orElse(null);
        issueRecord.setReturned(true);
        bookIssueRecordsRepository.save(issueRecord);
        book.acceptBook();
        inventoryRepository.save(book);
        bookReturnRecordsRepository.save(new BookReturnRecords(regId, bookId, date));
        return "Book Returned";
    }
}
