package standaloneApp.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class BookReturnRecords {
    @Id
    private String returnTransacId;
    private String regId;
    private String bookId;
    private String date;

    public BookReturnRecords() {
    }

    public BookReturnRecords(String regId, String bookId, String date) {
        this.setReturnTransacId(UUID.randomUUID().toString());
        this.regId = regId;
        this.bookId = bookId;
        this.date = date;
    }

    public String getReturnTransacId() {
        return returnTransacId;
    }

    public void setReturnTransacId(String returnTransacId) {
        this.returnTransacId = returnTransacId;
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
