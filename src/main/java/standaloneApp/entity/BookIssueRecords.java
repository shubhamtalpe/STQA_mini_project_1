package standaloneApp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class BookIssueRecords {
    @Id
    private String issueTransacId;
    private String regId;
    private String bookId;
    private String date;

    public BookIssueRecords(String regId, String bookId, String date) {
        this.setIssueTransacId(UUID.randomUUID().toString());
        this.regId = regId;
        this.bookId = bookId;
        this.date = date;
    }

    public String getIssueTransacId() {
        return issueTransacId;
    }

    public void setIssueTransacId(String issueTransacId) {
        this.issueTransacId = issueTransacId;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
