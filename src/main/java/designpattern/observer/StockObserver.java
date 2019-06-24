package designpattern.observer;

public class StockObserver implements Observer {
    private int observerId;
    private static int observerCount;
    private Subject grabber;

    public StockObserver(Subject grabber) {
        observerId = ++observerCount;
        System.out.println("New Observer " + observerId);
        this.grabber = grabber;
        grabber.register(this);
    }

    @Override
    public void update(double ibmPrice, double applPrice, double googPrice) {
        System.out.println("Observer " + observerId);
        System.out.println("Ibm = " + ibmPrice + "\nApple = " + applPrice + "\nGoogle =" + googPrice);
    }
}
