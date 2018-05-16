package com.tim.test.YahooFinance;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.util.concurrent.Callable;

public class YahooFinanceRequest implements Callable<Stock> {
    @Override
    public Stock call() throws Exception {
        return YahooFinance.get("INTC");
    }
}
