package standaloneApp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class fineRecord {
    @Id
    private String fineRecordId;
    private String regId;
    private String bookId;
    private int fineAmount;

    public fineRecord(String regId, String bookId, int fineAmount) {
        this.setFineRecordId(UUID.randomUUID().toString());
        this.regId = regId;
        this.bookId = bookId;
        this.fineAmount = fineAmount;
    }

    public String getFineRecordId() {
        return fineRecordId;
    }

    public void setFineRecordId(String fineRecordId) {
        this.fineRecordId = fineRecordId;
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

    public int getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(int fineAmount) {
        this.fineAmount = fineAmount;
    }
}
