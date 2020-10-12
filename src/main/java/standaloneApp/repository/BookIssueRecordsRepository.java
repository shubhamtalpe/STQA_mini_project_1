package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.BookIssueRecords;

public interface BookIssueRecordsRepository extends CrudRepository<BookIssueRecords, String> {
}
