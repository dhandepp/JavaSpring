package designpattern.observer;

public interface Subject {

    public void register(Observer newObserver);
    public void unRegister(Observer newObserver);
    public void notifyObservers();
}
