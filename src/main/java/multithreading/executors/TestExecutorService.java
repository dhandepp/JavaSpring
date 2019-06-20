package multithreading.executors;

import java.util.concurrent.*;

public class TestExecutorService {
    public static void main(String[] args) {
        ExecutorService service = null;
        //  service = Executors.newFixedThreadPool(4);      // Uses blockingqueue for tasks
        //  service = Executors.newSingleThreadExecutor();  // recreate thread if killed by any task, sequential execution of tasks
        // service = Executors.newCachedThreadPool(); // Creates threads on demand, killed if stayed idle for more than 60 seconds
        //     service = Executors.newScheduledThreadPool(2);
        //   ((ScheduledExecutorService) service).schedule(new Task(), 10, TimeUnit.SECONDS);

        //kind of like a scheduler
       // ((ScheduledExecutorService) service).scheduleWithFixedDelay(new Task(), 10, 10, TimeUnit.SECONDS);

        // ThreadPoolExecutor exec = new ThreadPoolExecutor();

/*        for (int i = 0; i < 20; i++) {
            service.execute(new Task());
        }
        service.shutdown();     // RejectedExecutionException if submitted after shutdown
        System.out.println("Shutdown the executor");*/

        service = Executors.newSingleThreadExecutor();

      Future<Integer> future =  service.submit(new CallableTask());
        try {
            // Blocking call, main thread will wait till results are ready, add a timeout
            future.get(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            // do something, if results are not ready till the timeout

            future.cancel(true);    // Attempts to cancel the execution of task
            future.isCancelled();
            future.isDone();    // returns true for termination, exception or completion
        }

    }
}
