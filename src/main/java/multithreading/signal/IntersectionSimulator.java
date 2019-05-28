package multithreading.signal;

public class IntersectionSimulator {
    private boolean signalA = true;
    private boolean signalB = false;

    public synchronized void allowAToB() {
        if (signalA) {
            try {
                System.out.println("Allowing A-B for 5 seconds.........");
                Thread.sleep(2500);
                System.out.println("Red signal between A-B");
                signalA = false;
                signalB = true;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void allowCToD() {
        if (signalB) {
            try {
                System.out.println("Allowing C-D for 5 seconds.........");
                Thread.sleep(2500);
                System.out.println("Red signal between C-D");
                signalB = false;
                signalA = true;
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final IntersectionSimulator sm = new IntersectionSimulator();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    sm.allowAToB();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    sm.allowCToD();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
