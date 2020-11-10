package standaloneApp.backend.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.backend.entity.Inventory;

import java.util.List;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
    List<Inventory> findByBookId(String bookId);
    List<Inventory> findByBookName(String bookName);
    List<Inventory> findByAuthorName(String authorName);
}
