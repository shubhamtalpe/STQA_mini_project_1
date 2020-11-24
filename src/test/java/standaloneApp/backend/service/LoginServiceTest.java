package standaloneApp.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(loader = HeadlessSpringBootContextLoader.class)
class LoginServiceTest {
    @Autowired
    LoginService loginService;

    @Test
    void checkValidCredentials() {
        assertTrue(loginService.checkCredentials("admin", "admin@123"));
    }
    @Test
    void checkInvalidCredentials() {
        assertFalse(loginService.checkCredentials("admin", "admin123"));
    }
}