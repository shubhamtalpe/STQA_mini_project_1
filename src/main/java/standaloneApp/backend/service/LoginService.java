package standaloneApp.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import standaloneApp.backend.entity.LoginInfo;
import standaloneApp.backend.repository.LoginInfoRepository;

@Service
public class LoginService {
    @Autowired
    private LoginInfoRepository loginInfoRepository;

    public boolean checkCredentials(String loginId, String password){
        if(loginId != null) {
            LoginInfo creds = loginInfoRepository.findByLoginId(loginId);
            if (creds != null) {
                System.out.println(password);
                System.out.println(creds.getPassword());
                if (creds.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
