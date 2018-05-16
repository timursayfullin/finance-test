package com.tim.test;

import com.tim.test.AlphaVantage.AlphaVantageRequest;
import com.tim.test.AlphaVantage.dtos.AlphaVantageData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootApplication
public class TestApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//
//        List<Callable<AlphaVantageData>> tasks = new ArrayList<>();
//        tasks.add(new AlphaVantageRequest());
//
//        List<AlphaVantageData> items = new ArrayList<>();
//        for(Future<AlphaVantageData> future : executorService.invokeAll(tasks)){
//            items.add(future.get());
//        }
//
//        executorService.shutdown();
        Stock stock = YahooFinance.get("INTC");

        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();
    }
}
