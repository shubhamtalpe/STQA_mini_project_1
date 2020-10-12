package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
}
