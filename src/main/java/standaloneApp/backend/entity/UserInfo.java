package standaloneApp.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserInfo {
    @Id
    private String regId;
    private String name;
    private int accessLevel;    //1 for admin, 2 for teacher and 3 for student


    public UserInfo() {
    }

    public UserInfo(String regId, String name, int accessLevel) {
        this.regId = regId;
        this.name = name;
        this.accessLevel = accessLevel;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }
}
