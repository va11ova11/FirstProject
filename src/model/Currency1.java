package model;

public class Currency1 {
    private String CurrencyName;
    private int PriceOnRub;
    private double CurrencyProfitability;

    public Currency1(int priceOnRub, String currencyName, double CurrencyProfitability) {
        this.PriceOnRub = priceOnRub;
        this.CurrencyName = currencyName;
        this.CurrencyProfitability = CurrencyProfitability;
    }

    public int getPriceOnRub() {
        return PriceOnRub;
    }

    public void setPriceOnRub(int priceOnRub) {
        this.PriceOnRub = priceOnRub;
    }

    public String getCurrencyName() {
        return CurrencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.CurrencyName = currencyName;
    }

    public double getCurrencyProfitability() {
        return CurrencyProfitability;
    }

    public void setCurrencyProfitability(double currencyProfitability) {
        this.CurrencyProfitability = currencyProfitability;

    }
}
