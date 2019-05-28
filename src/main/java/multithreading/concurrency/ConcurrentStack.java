package multithreading.concurrency;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentStack {
    private List<Integer> list = new ArrayList<Integer>();
    private int top = -1;

    public void push(int data) {
        synchronized (this) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(data);
            top++;
            notify();
        }
    }

    public int pop() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this) {
            if (top == 49) {
                notify();
            }
            if (top < 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return list.remove(top--);
        }
    }

    public static void main(String[] args) {
        final ConcurrentStack stack = new ConcurrentStack();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    stack.push(i);
                    System.out.println("Pushing +" + i);
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("Popping -" + stack.pop());
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("LIst size " + stack.list.size());
    }
}
