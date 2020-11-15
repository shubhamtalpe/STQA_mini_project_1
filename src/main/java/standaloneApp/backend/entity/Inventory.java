package standaloneApp.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    private String bookId;
    private String bookName;
    private String authorName;
    private int totalCopies;
    private int availableCopies;

    public Inventory() {
    }

    public Inventory(String bookId, String bookName, String authorName, int totalCopies, int availableCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable(){
        return this.availableCopies != 0;
    }

    public void issueBook(){
        this.availableCopies -= 1;
    }

    public void acceptBook(){
        this.availableCopies += 1;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }
}
