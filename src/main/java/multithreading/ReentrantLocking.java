package multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {
    private int count;
    Lock lock = new ReentrantLock();
    Condition blockingPoolA = lock.newCondition();


    public void increment() {
        for (int i = 0; i < 1000; i++) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    public void firstThread() {
        lock.lock();
        try {
            increment();
            blockingPoolA.await();
        } catch (Exception ex) {
        } finally {
            lock.unlock();
        }
    }

    public void secondThread() {
        lock.lock();
        try {
            increment();
            blockingPoolA.signal();
        } catch (Exception ex) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final ReentrantLocking obj = new ReentrantLocking();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                obj.firstThread();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                obj.secondThread();
            }
        });

        try {
            t1.start();
            t2.start();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Count is " + obj.getCount());
    }
}
