package model;

public class Bank extends Person {
    private int Id;
    private float balance;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public float getBalance() {
        return balance;
    }

    public float setBalance(float balance) {
        this.balance = balance;
        return balance;
    }
}
