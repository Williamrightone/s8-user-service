package cc.synpulse8.userservice.domain.enduser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class EndUserTest {

    @Test
    void test_passwd_encode_api_match() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String passwd_a = passwordEncoder.encode("Demo9731");
        String passwd_b = passwordEncoder.encode("Demo9732");

        System.out.println(passwd_a);

        boolean flagA = passwordEncoder.matches("Demo9731", passwd_a);
        System.out.println(flagA);
        System.out.println(passwd_b);

        assertTrue(flagA);

    }



}