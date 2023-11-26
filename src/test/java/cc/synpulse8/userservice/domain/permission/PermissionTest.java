package cc.synpulse8.userservice.domain.permission;

import cc.synpulse8.userservice.domain.repository.PermissionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PermissionTest {

    @Autowired
    private PermissionRepository permissionRepository;

    @Test
    void test_repository_get_permission_by_sid() {

        String sid ="S231101";

        List<String> permissions = permissionRepository.findPermissionBySid(sid);

        assertEquals(1, permissions.size());
        assertEquals("ACCOUNTING_VIEW", permissions.get(0));

    }

}
