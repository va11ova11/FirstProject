package model;

public class Portfolio {
    private int id;
    private FoundStructure fondname;
    private int amountfond;
    private float summafond;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FoundStructure getFondname() {
        return fondname;
    }

    public void setFondname(FoundStructure fondname) {
        this.fondname = fondname;
    }

    public int getAmountfond() {
        return amountfond;
    }

    public void setAmountfond(int amountfond) {
        this.amountfond = amountfond;
    }

    public float getSummafond() {
        return summafond;
    }

    public void setSummafond(float summafond) {
        this.summafond = summafond;
    }
}
