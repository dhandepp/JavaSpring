package designpattern.observer;

/**
 * Subject sends updates to it's subscribers
 */
public class TestObserver {
    public static void main(String[] args){
        StockGrabber grabber = new StockGrabber();

        StockObserver observer1 = new StockObserver(grabber);
        StockObserver observer2 = new StockObserver(grabber);

        grabber.setApplPrice(120.03);
        grabber.setGooglePrice(49.23);
        grabber.setIbmPrice(20.44);

        grabber.unRegister(observer2);
    }
}
