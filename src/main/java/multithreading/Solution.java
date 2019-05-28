package multithreading;

public class Solution {
    public static void main(String[] args){
        Thread t1 = new Thread(new SimpleRunnable());
        Thread t2 = new Thread(new SimpleRunnable());
        Thread t3 = new Thread(new SimpleRunnable());

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Inside main");
    }
}
