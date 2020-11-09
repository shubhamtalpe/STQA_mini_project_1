package standaloneApp.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import standaloneApp.backend.entity.LoginInfo;

@Repository
public interface LoginInfoRepository extends CrudRepository<LoginInfo, String> {
    LoginInfo findByLoginId(String loginID);
}
