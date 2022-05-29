package model;

public class Stock {
    private String StockName;
    private double StockPrice;
    private double StockProfitability;

    public Stock(String stockName, double stockPrice, double stockProfitability) {
        StockName = stockName;
        StockPrice = stockPrice;
        StockProfitability = stockProfitability;
    }

    public String getStockName() {
        return StockName;
    }

    public void setStockName(String stockName) {
        StockName = stockName;
    }

    public double getStockPrice() {
        return StockPrice;
    }

    public void setStockPrice(double stockPrice) {
        StockPrice = stockPrice;
    }

    public double getStockProfitability() {
        return StockProfitability;
    }

    public void setStockProfitability(double stockProfitability) {
        StockProfitability = stockProfitability;
    }
}
