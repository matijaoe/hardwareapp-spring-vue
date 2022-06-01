package hr.tvz.osrecki.hardwareapp.hardware.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import hr.tvz.osrecki.hardwareapp.hardware.model.Hardware;
import hr.tvz.osrecki.hardwareapp.hardware.model.HardwareType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
class HardwareControllerTest {

    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDYxMzg4NywiaWF0IjoxNjU0MDA5MDg3LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.aYWAIT3Qb5Kws7dFB3gEgVE6wxhWqFCAi8bKKCiic6_0OOrPCQ1kKT4RC6PTG43tTYbCUOBeTtdX5QCUJCaJDQ";

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void getAllHardware() throws Exception {
        this.mockMvc.perform
                        (get("/hardware")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    void getHardware() throws Exception {
        Hardware testHardware = new Hardware("BX8071512700K", "Intel Core i7-12700K", 384.98, HardwareType.CPU, 14);
        this.mockMvc.perform(get("/hardware/BX8071512700K"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.code").value(testHardware.getCode()))
                .andExpect(jsonPath("$.name").value(testHardware.getName()))
                .andExpect(jsonPath("$.price").value(testHardware.getPrice()));
    }

    @Test
    void getHardwareInvalid() throws Exception {
        this.mockMvc.perform
                        (get("/hardware/69")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        )
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void save() throws Exception {
        Map<String, Object> body = new HashMap<>();
        body.put("name", "Matija hardver");
        body.put("code", "matijacode");
        body.put("price", 699);
        body.put("type", "CPU");
        body.put("quantity", 12);

        System.out.println(body);

        this.mockMvc.perform(
                        post("/hardware")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.name").value("Matija hardver"))
                .andExpect(jsonPath("$.price").value(699));
    }
}