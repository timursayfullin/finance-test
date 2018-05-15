package com.tim.test;

import com.tim.test.AlphaVantage.dtos.AlphaVantageData;
import com.tim.test.AlphaVantage.dtos.AlphaVantageRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        AlphaVantageData financialData;

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<AlphaVantageData>> tasks = new ArrayList<>();
        tasks.add(new AlphaVantageRequest());

        List<AlphaVantageData> items = new ArrayList<>();
        for(Future<AlphaVantageData> future : executorService.invokeAll(tasks)){
            items.add(future.get());
        }

        executorService.shutdown();
    }
}
