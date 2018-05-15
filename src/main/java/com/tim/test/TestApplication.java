package com.tim.test;

import com.tim.test.dtos.FinancialData;
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
        FinancialData financialData;

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<FinancialData>> tasks = new ArrayList<>();
        tasks.add(new FinancialRequest());

        executorService.invokeAll(tasks);
        executorService.shutdown();
    }
}
