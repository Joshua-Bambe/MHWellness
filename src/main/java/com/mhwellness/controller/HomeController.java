package com.mhwellness.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.mhwellness.dto.MessageRequest;
import com.mhwellness.dto.StatusResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
    //@GetMapping maps GET requests
    // to a java method. GET itself
    // is the HTTP method.
    //("/") is the path. This means
    // when this application receives an HTTP GET
    // request for /, execute this method.
    @GetMapping("/")
    //Method for the first end point
    // returns MHWellness API is running!
    public String home(){
        return "MHWellness API is running!";
    }

    @GetMapping("/status")
    //Method for the second end point
    // returns the application status and
    // version information of the JSON
    // Returns a java object, but Spring
    // turns the object into a JSON
    // and that is what is being sent to the
    // HTTP client/browser
    public StatusResponse status(){
        StatusResponse statusResponse = new StatusResponse(
                "MHWellness",
                "healthy",
                1,
                false
        );

        return statusResponse;
    }
    // Receives JSON from the HTTP request body.
    // Spring deserializes the JSON into a
    // MessageRequest object.
    /**
     * Take the body of the incoming HTTP request
     * deserialize its JSON, and give me the
     * resulting MessageRequest object through
     * this parameter.
     */
    @PostMapping("/message")
    public String message(@Valid @RequestBody MessageRequest request){
        return "Received: " + request.getMessage().strip();
    }
}
