package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.BookReturnRecords;

public interface BookReturnRecordsRepository extends CrudRepository<BookReturnRecords, String> {
}
