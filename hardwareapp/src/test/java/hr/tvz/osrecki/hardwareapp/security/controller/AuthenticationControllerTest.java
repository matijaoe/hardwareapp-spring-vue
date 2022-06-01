package hr.tvz.osrecki.hardwareapp.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
class AuthenticationControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    Map<String, Object> bodyAdmin = new HashMap<>();

    public void setBodyAdmin(Map<String, Object> bodyAdmin) {
        bodyAdmin.put("username", "admin");
        bodyAdmin.put("password", "admin");
        this.bodyAdmin = bodyAdmin;
    }

    public void setBodyAdminInvalid(Map<String, Object> bodyAdmin) {

    }

    @Test
    void login() throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("username", "admin");
        body.put("password", "admin");

        this.mockMvc.perform(
                        post("/authentication/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().encoding(StandardCharsets.UTF_8))
                .andExpect(jsonPath("$.jwt").isNotEmpty());
    }
}