package com.tim.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.Map;

public class FinancialData {
    @JsonProperty("Meta Data")
    MetaData metaData;

    @JsonProperty("Time Series (Daily)")
    Map<String, TimeItem>  timeSeries;
}
