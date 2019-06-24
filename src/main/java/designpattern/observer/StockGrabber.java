package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabber implements Subject {
    List<Observer> observers;
    private double ibmPrice;
    private double googlePrice;
    private double applPrice;

    public void setIbmPrice(double ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObservers();
    }

    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
        notifyObservers();
    }

    public void setApplPrice(double applPrice) {
        this.applPrice = applPrice;
        notifyObservers();
    }

    public StockGrabber() {
        observers = new ArrayList<>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unRegister(Observer observer) {
        int index = observers.indexOf(observer);
        System.out.println("Removed observer #" + index);
        observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        observers.stream()
                .forEach(observer -> observer.update(ibmPrice, applPrice, googlePrice));
    }
}
