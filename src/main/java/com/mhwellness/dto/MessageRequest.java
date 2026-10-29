package com.mhwellness.dto;
import jakarta.validation.constraints.NotBlank;

public class MessageRequest {
    //Attribute
    /*
    The @NotBlank annotation means
    that this attribute must contain
    at least one non-white space character.
    In other words, the string message
    cannot be an empty string or null.
     */
    @NotBlank
    private String message;

    //Getter Method for attribute message
    public String getMessage() {
        return message;
    }

    //Setter Method for attribute message
    public void setMessage(String message) {
        this.message = message;
    }

    //Constructor
    public MessageRequest(){

    }
}
