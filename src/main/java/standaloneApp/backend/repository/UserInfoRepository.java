package standaloneApp.backend.repository;

import org.springframework.data.repository.CrudRepository;
import standaloneApp.backend.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String> {
    UserInfo findByRegId(String regId);
}
