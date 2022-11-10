package com.project.demo.alexa;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;


@JsonTypeName(value = IntentRO.TYPENAME)
public class IntentRO
{
    protected final static String TYPENAME = "IntentRO";
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("slots")
    private SlotsRO slots;
    // So müsste es weitergehen, wenn der Intent Slots hat
    //
    
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    public IntentRO()
    {
        super();
    }

    public IntentRO(String name, SlotsRO slots)
    {
        super();
        this.name = name;
        this.slots = slots;
    }
    
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("slots")
    public SlotsRO getSlots() { return slots; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
