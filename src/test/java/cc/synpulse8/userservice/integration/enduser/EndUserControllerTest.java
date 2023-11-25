package cc.synpulse8.userservice.integration.enduser;

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
class EndUserControllerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test_find_user_success() throws Exception {
        String sid = "S231101";

        RequestBuilder requestbuilder = MockMvcRequestBuilders
                .get("/api/end-user/{sid}", sid)
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestbuilder)
                .andDo(print())
                .andExpect(jsonPath("$.data.sid").value("S231101"))
                .andExpect(jsonPath("$.data.userName").value("William"))
                .andExpect(jsonPath("$.data.passwd").value("$10$lu7IyMib6wpf3VDUA71Q/u2Ve0OkRrNihPUapLDdofVSoHc7ReyB2"))
                .andExpect(status().is(200));
    }

    @Test
    void test_user_not_found_shall_throw_exception() throws Exception {

        String sid = "A123456";

        RequestBuilder requestbuilder = MockMvcRequestBuilders
                .get("/api/end-user/{sid}", sid)
                .contentType(MediaType.APPLICATION_JSON);

        testFormatErrorMockPerform(requestbuilder, "U10000");

    }

    private void testFormatErrorMockPerform(RequestBuilder requestbuilder, String errorCode) throws Exception {

        mockMvc.perform(requestbuilder)
                .andDo(print())
                .andExpect(jsonPath("$.customErrorCode").value(errorCode))
                .andExpect(status().is(400));

    }

}
