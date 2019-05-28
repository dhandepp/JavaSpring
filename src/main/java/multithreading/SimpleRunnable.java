package multithreading;

public class SimpleRunnable implements Runnable {
    public SimpleRunnable(){
        System.out.println("Startup");
    }
    public void run(){
        System.out.println("Message 1");
        Thread.yield();
        System.out.println("Message 2");
        Thread.yield();
        System.out.println("Message 3");
        Thread.yield();
        System.out.println("Shutdown");
    }
}
