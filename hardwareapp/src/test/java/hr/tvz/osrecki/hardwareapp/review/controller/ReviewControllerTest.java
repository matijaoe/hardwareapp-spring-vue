package hr.tvz.osrecki.hardwareapp.review.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
class ReviewControllerTest {

    String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY1NDYxMzg4NywiaWF0IjoxNjU0MDA5MDg3LCJhdXRob3JpdGllcyI6IlJPTEVfQURNSU4ifQ.aYWAIT3Qb5Kws7dFB3gEgVE6wxhWqFCAi8bKKCiic6_0OOrPCQ1kKT4RC6PTG43tTYbCUOBeTtdX5QCUJCaJDQ";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllReviews() throws Exception {
        this.mockMvc.perform
                        (get("/reviews")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Test
    void getReviewsForHardware() throws Exception {
        this.mockMvc.perform
                        (get("/reviews")
                                .param("code", "69")
                                .with(csrf())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
    }
}