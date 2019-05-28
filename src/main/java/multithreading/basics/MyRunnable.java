package multithreading.basics;

public class MyRunnable implements Runnable {
    public void run() {

     //   System.out.println(Thread.currentThread().getState());

        try {
            Thread.sleep(3000);
            // Sets current thread to sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("In thread "+ Thread.currentThread().getName());
    }
}
