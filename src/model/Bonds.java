package model;

public class Bonds {
    private String BondsName;
    private double BondsPrice;
    private double BondsProfitability;

    public Bonds(String bondsName, double bondsPrice, double bondsProfitability) {
        BondsName = bondsName;
        BondsPrice = bondsPrice;
        BondsProfitability = bondsProfitability;
    }

    public String getBondsName() {
        return BondsName;
    }

    public void setBondsName(String bondsName) {

        BondsName = bondsName;
    }

    public double getBondsPrice() {
        return BondsPrice;
    }

    public void setBondsPrice(double bondsPrice) {
        BondsPrice = bondsPrice;
    }

    public double getBondsProfitability() {
        return BondsProfitability;
    }

    public void setBondsProfitability(double bondsProfitability) {
        BondsProfitability = bondsProfitability;
    }
}
