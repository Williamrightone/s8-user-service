package cc.synpulse8.userservice.integration.permission;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PermissionControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_find_user_permissions_success() throws Exception {
        String sid = "S231101";

        RequestBuilder requestbuilder = MockMvcRequestBuilders
                .get("/api/permission/{sid}", sid)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestbuilder)
                .andDo(print())
                .andExpect(jsonPath("$.data[0]").value("ACCOUNTING_VIEW"))
                .andExpect(status().is(200));
    }

    @Test
    void test_find_user_no_any_permissions() throws Exception {
        String sid = "S231102";

        RequestBuilder requestbuilder = MockMvcRequestBuilders
                .get("/api/permission/{sid}", sid)
                .contentType(MediaType.APPLICATION_JSON);

        testFormatErrorMockPerform(requestbuilder, "U10001");
    }


    private void testFormatErrorMockPerform(RequestBuilder requestbuilder, String errorCode) throws Exception {

        mockMvc.perform(requestbuilder)
                .andDo(print())
                .andExpect(jsonPath("$.customErrorCode").value(errorCode))
                .andExpect(status().is(400));

    }

}
