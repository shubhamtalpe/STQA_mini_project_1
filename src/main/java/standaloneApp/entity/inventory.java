package standaloneApp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class inventory {
    @Id
    private String bookId;
    private String bookName;
    private String authorName;
    private int totalCopies;
    private int availableCopies;

    public inventory(String bookId, String bookName, String authorName, int totalCopies, int availableCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.totalCopies = totalCopies;
        this.availableCopies = availableCopies;
    }

    public String getBookId() {
        return bookId;
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
