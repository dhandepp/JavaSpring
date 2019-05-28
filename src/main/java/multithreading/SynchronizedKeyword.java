package multithreading;

public class SynchronizedKeyword {
    private int count;

    public static void main(String[] args) throws InterruptedException {
        SynchronizedKeyword ojb = new SynchronizedKeyword();
        ojb.doStuff();
    }

    public void doStuff() throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++)
               increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 1000; i++)
                increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count is "+ count);
    }

    public synchronized void increment(){
        count++;
    }

}

