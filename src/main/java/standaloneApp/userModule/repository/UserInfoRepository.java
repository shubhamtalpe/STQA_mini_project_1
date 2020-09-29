package standaloneApp.userModule.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.userModule.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {

}
