package com.tim.test.AlphaVantage;

import com.tim.test.AlphaVantage.dtos.AlphaVantageData;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

@Data
public class AlphaVantageRequest implements Callable<AlphaVantageData> {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    private String urlPattern = "https://www.alphavantage.co/query?apikey=476GZO6Y88EM9OJ8&function=TIME_SERIES_DAILY_ADJUSTED&symbol={symbol}";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public AlphaVantageRequest() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    @Override
    public AlphaVantageData call() {
        String url = urlPattern.replace("{symbol}", "MSFT");
        logger.info(url);

        return rest.getForObject(url, AlphaVantageData.class);
    }
}
