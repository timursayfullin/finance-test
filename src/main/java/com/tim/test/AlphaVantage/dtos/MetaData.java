package com.tim.test.AlphaVantage.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tim.test.utils.LocalDateTimeDeserializer;

import java.time.LocalDate;

public class MetaData {
    @JsonProperty("1. Information")
    String information;

    @JsonProperty("2. Symbol")
    String symbol;

    @JsonProperty("3. Last Refreshed")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    LocalDate lastRefreshed;

    @JsonProperty("4. Output Size")
    String outputSize;

    @JsonProperty("5. Time Zone")
    String timeZone;
}
