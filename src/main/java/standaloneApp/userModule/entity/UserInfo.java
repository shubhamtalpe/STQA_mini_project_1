package standaloneApp.userModule.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    private String userRegisterId;
    private String name;

    public UserInfo(String userRegisterId, String name) {
        this.userRegisterId = userRegisterId;
        this.name = name;
    }

    public String getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(String userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
