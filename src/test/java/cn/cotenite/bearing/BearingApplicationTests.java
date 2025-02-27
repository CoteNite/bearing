package cn.cotenite.bearing;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BearingApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(BCrypt.hashpw("admin", BCrypt.gensalt()));
    }

}
