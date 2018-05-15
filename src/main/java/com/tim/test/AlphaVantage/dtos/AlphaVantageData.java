package com.tim.test.AlphaVantage.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class AlphaVantageData {
    @JsonProperty("Meta Data")
    MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    Map<String, TimeItem>  timeSeries;
}
