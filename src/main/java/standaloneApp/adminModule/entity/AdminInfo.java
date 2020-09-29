package standaloneApp.adminModule.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminInfo {
    @Id
    private String adminRegisterId;
    private String name;

    public AdminInfo(String adminRegisterId, String name) {
        this.adminRegisterId = adminRegisterId;
        this.name = name;
    }

    public String getAdminRegisterId() {
        return adminRegisterId;
    }

    public void setAdminRegisterId(String adminRegisterId) {
        this.adminRegisterId = adminRegisterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
