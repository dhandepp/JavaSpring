package multithreading.consumer;

public class BroadCaster implements Runnable {
    private Stream stream;

    public BroadCaster(Stream stream) {
        super();
        this.stream = stream;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                System.out.println("Streaming "+ stream.broadcast());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
