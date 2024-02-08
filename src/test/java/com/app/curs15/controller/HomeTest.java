package com.app.curs15.controller;

import com.app.curs15.models.Message;
import com.app.curs15.utils.MessageMockMissingField;
import com.app.curs15.utils.MessageMockValid;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestHeader;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HomeTest {
    Message message = MessageMockValid.createValidMockedMessage();
    Message invalidMessage = MessageMockMissingField.createInvalidMessage();
    @Autowired
    private Home controller;
    @Autowired
    private MockMvc mockMvc;
    @Test()
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
    @Test
    void givenValidBodyAndAuthenticationHeader_whenCallingPostMessage_Return200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/messages")
                .content(asJsonString(message))
                .contentType(MediaType.APPLICATION_JSON)
                .header("authentication", "devmind-api-key"))
                .andExpect(status().is2xxSuccessful());
    }
    @Test
    void givenInvalidBody_whenCallingPostMessage_Return400() throws Exception{
        mockMvc.perform((MockMvcRequestBuilders
                .post("/messages")
                .content(asJsonString(invalidMessage))
                .contentType(MediaType.APPLICATION_JSON)
                .header("authentication", "devmind-api-key")))
                .andExpect(status().is4xxClientError());
    }
    @Test
    void givenInvalidAuthentication_whenCallingPostMessage_Return401() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .post("/messages")
                .content(asJsonString(message))
                .contentType(MediaType.APPLICATION_JSON)
                .header("authentication", "invalid"))
                .andExpect(status().is4xxClientError());
    }
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
