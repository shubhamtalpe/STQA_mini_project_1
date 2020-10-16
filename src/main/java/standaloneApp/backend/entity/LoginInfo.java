package standaloneApp.backend.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginInfo {
    @Id
    private String regId;
    private String loginId;
    private String password;

    public LoginInfo(String regId, String loginId, String password) {
        this.regId = regId;
        this.loginId = loginId;
        this.password = password;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
