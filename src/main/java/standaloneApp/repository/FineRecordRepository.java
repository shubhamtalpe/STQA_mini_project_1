package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.FineRecord;

public interface FineRecordRepository extends CrudRepository<FineRecord, String> {
}
