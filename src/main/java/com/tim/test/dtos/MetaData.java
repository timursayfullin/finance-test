package com.tim.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;

public class MetaData {
    @JsonProperty("1. Information")
    String information;

    @JsonProperty("2. Symbol")
    String symbol;

    @JsonProperty("3. Last Refreshed")
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    LocalDateTime lastRefreshed;

    @JsonProperty("4. Output Size")
    String outputSize;

    @JsonProperty("5. Time Zone")
    String timeZone;
}
