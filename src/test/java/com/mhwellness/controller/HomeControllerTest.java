package com.mhwellness.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /*
    This is an automated API test. This test is
    designed to send a Bad Request (STATUS 400)
    to the client if an empty message/string is
    sent to the server. This test will run automatically
    when triggered,enabling the server to run smoothly
    and catch errors and exceptions as needed. Before
    this test existed,I had to manually test in PowerShell,
    but now this test is fully automated.
     */
    @Test
    void emptyMessageShouldBeRejected() throws Exception {
        // MockMvc simulates
        // HTTP requests through Spring MVC.
        mockMvc.perform(
                post("/api/v1/message")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"\"}")
        )
                .andExpect(status().isBadRequest());
    }

    /*
    This is an automated API test. This test is
    designed to send a OK Request (STATUS 200)
    to the client if sends a message. If the message
    has a string, then the message should be
    accepted. The status should accept the
    message because there is a string present in
    the JSON message. This test will run automatically
    when triggered, enabling the server to run smoothly and catch
    errors and exceptions as needed. Before this test
    existed, I had to manually test in PowerShell,
    but now this test is fully automated.
     */
    @Test
    void validMessageShouldBeAccepted() throws Exception{
        mockMvc.perform(
                post("/api/v1/message")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\"Hello MHWellness\"}")
        )
                .andExpect(status().isOk()) // .isOk() method instead of .Accepted()
                                            // because the request succeeded and was processed.
                .andExpect(content().string("Received: Hello MHWellness"));
    }

    /*
    This is an automated API test. This test is
    designed to send a Bad Request (STATUS 400)
    to the client if the JSON sends a blank message,
    in this case, and empty string. If there is an
    empty string, the message should be rejected.
    This test will run automatically when triggered,
    enabling the server to run smoothly and catch
    errors and exceptions as needed, Before this
    test existed I had to manually test in
    PowerShell, but now this test is fully automated.
     */
    @Test
    void whitespaceOnlyMessagesShouldBeRejected() throws Exception{
        mockMvc.perform(
                post("/api/v1/message")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"message\":\" \"}")
        )
                .andExpect(status().isBadRequest()); // Should get Bad Request (STATUS 400) because
                                                    // the request should be rejected.
    }

}