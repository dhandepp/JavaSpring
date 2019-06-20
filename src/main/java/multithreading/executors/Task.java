package multithreading.executors;

public class Task implements Runnable {
    private static int taskCount;

    @Override
    public void run() {
        System.out.println("#" + (++taskCount));
        System.out.println(Thread.currentThread().getName() + " is waiting for 1 second");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
