package com.tim.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeItem {
    @JsonProperty("1. open")
    Double open;

    @JsonProperty("2. high")
    Double high;
    @JsonProperty("3. low")
    Double low;

    @JsonProperty("4. close")
    Double close;

    @JsonProperty("5. adjusted close")
    Double adjustedClose;

    @JsonProperty("6. volume")
    Double volume;

    @JsonProperty("7. dividend amount")
    Double dividendAmount;

    @JsonProperty("8. split coefficient")
    Double splitCoefficient;
}
