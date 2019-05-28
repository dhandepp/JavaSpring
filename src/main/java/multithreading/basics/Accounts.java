package multithreading.basics;

public class Accounts {
    private double balance = 50;

    public void withDraw(){
        this.balance -= 10;
    }

    public double getBalance(){
        return balance;
    }
}
