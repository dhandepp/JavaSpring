package multithreading.consumer;

public class Stream {
    private int data;
    private boolean canBroadCast = false;

    public synchronized int broadcast() throws InterruptedException {

        while(!canBroadCast){
            wait();
        }
        canBroadCast = true;
        notify();
        return data;
    }

    public synchronized void generate() throws InterruptedException {
        while (canBroadCast) {
            wait();
        }
        data++;
        canBroadCast = true;
        notify();
    }
}
