package standaloneApp.adminModule.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.adminModule.entity.AdminInfo;

public interface AdminInfoRepository extends CrudRepository <AdminInfo, String>{
}
