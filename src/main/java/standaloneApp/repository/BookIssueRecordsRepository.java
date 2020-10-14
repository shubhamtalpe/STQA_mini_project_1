package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.BookIssueRecords;

import java.util.List;

public interface BookIssueRecordsRepository extends CrudRepository<BookIssueRecords, String> {
    List<BookIssueRecords> findByRegId(String regId);

    List<BookIssueRecords> findByRegIdAndBookId(String regId, String bookId);

    List<BookIssueRecords> findByRegIdAndIsReturned(String regId, Boolean isReturned);
}
