package standaloneApp.backend.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.backend.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
