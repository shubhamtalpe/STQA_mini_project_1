package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.LoginInfo;

public interface LoginInfoRepository extends CrudRepository<LoginInfo, String> {
}
