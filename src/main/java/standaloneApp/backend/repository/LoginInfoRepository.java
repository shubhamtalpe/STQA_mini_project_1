package standaloneApp.backend.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.backend.entity.LoginInfo;

public interface LoginInfoRepository extends CrudRepository<LoginInfo, String> {
}
