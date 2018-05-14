package com.tim.test;

import lombok.Data;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;

@Data
public class FinancialRequest implements Callable<FinancialData> {
    private String urlPattern = "https://www.alphavantage.co/query?apikey=476GZO6Y88EM9OJ8&function=TIME_SERIES_DAILY_ADJUSTED&symbol={symbol}";
    private RestTemplate rest;
    private HttpHeaders headers;
    private HttpStatus status;

    public FinancialRequest() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    @Override
    public FinancialData call() throws Exception {
        String response = get("MSFT");

        System.out.println(response);

        return null;
    }

    private String get(String symbol) {
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);

        String url = urlPattern.replace("{symbol}", symbol);
        System.out.println(url);

        ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());
        return responseEntity.getBody();
    }
}
