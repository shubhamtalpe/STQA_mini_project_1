package standaloneApp.adminModule.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import standaloneApp.adminModule.entity.AdminInfo;
import standaloneApp.adminModule.repository.AdminInfoRepository;
import standaloneApp.userModule.entity.UserInfo;
import standaloneApp.userModule.repository.UserInfoRepository;

@Service
public class AdminService {
    @Autowired
    private AdminInfoRepository adminInfoRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;

    public void addAdmin(String adminRegisterId, String name){
        adminInfoRepository.save(new AdminInfo(adminRegisterId, name));
    }

    public void removeAdminById(String adminRegisterId){
        adminInfoRepository.deleteById(adminRegisterId);
    }

    public void addUser(String userRegisterId, String name){
        userInfoRepository.save(new UserInfo(userRegisterId, name));
    }

    public void removeUserById(String userRegisterId){
        userInfoRepository.deleteById(userRegisterId);
    }
}
