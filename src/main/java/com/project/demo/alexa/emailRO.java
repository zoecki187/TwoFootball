package com.project.demo.alexa;

import com.fasterxml.jackson.annotation.JsonProperty;

public class emailRO {
    @JsonProperty("name")
    private String name;

    @JsonProperty("value")
    private String email;

    @JsonProperty("value")
    public String getEmail(){return email; }

    public emailRO() {super();}

}
