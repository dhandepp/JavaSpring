package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SynchronizedBlock {
    Object lock1 = new Object();
    Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList();
    private List<Integer> list2 = new ArrayList();
    Random r = new Random();

    public  void stageOne() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock1) {
            list1.add(r.nextInt(1000));
        }
    }

    public synchronized void stageTwo() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (lock2) {
            list2.add(r.nextInt(1000));
        }
    }

    public void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public static void main(String[] args) {
        final SynchronizedBlock sb = new SynchronizedBlock();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                sb.process();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                sb.process();
            }
        });

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //sb.process();

        long end = System.currentTimeMillis();

        System.out.println("Starting...\n Time taken: " + (end - start));
        sb.getSizes();
    }

    public void getSizes() {
        System.out.println("Size L1: " + list1.size());
        System.out.println("Size L1: " + list2.size());
    }
}
