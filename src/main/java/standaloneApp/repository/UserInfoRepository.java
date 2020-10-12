package standaloneApp.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {
}
