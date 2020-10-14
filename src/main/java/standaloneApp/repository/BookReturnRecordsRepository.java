package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.BookReturnRecords;

import java.util.List;

public interface BookReturnRecordsRepository extends CrudRepository<BookReturnRecords, String> {
    List<BookReturnRecords> findByRegId(String regId);
}
