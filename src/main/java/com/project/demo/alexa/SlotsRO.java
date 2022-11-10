package com.project.demo.alexa;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonTypeName(value = SlotsRO.TYPENAME)
public class SlotsRO
{
    protected final static String TYPENAME = "SlotRO";

    @JsonProperty("Email")
    private emailRO emailRO;

    @JsonProperty("Email")
    public emailRO getEmailRO() {return emailRO;}

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public SlotsRO()
    {
        super();
    }
  
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
