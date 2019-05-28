package multithreading.basics;

public class SolutionBasics {
    public static void main(String[] args){
        MyRunnable r = new MyRunnable();
        Thread t1 = new Thread(r,"t1");
        Thread t3 = new Thread(r,"t3");
        Thread t2 = new Thread(r,"t2");

        /*
        Thread state is New, not alive, when start() is not executed, NEW
        * Thread is alive, as start is called, (not necessarily run is called), RUNNABLE
        * Dead, when run() is done for that thread, getState() returns state of thread, DEAD
        *
        * When start() is called, new thread of execution starts, RUNNABLE state and run() will get called whenever it's possible
        * when run() is called, it's RUNNING
        *  Waiting/Blocked for some IO
        * Accessing current thread, Thread.currentThread().getName()
        *
        * start() can be called only once, Runtime execution occurs otherwise
        *
        * join()- t.join(), tells current thread, though main thread to join execution only after thread t completes it's run(),
        * t.join(timeout), tells current thread to become runnable after t is dead or if timeout exceeds.
        *
        * Synchronization- Thread acquires lock on an object. Object can have only one lock.
        * No other thread can access that lock, need to have synchronized block so as to make a process atomic(one operation)
         */
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();



        t2.start();
        t3.start();

        /*
        * Thread is alive, as start is called, (not necessarily run is called)
        * */



        System.out.println("Normal main");
    }
}
