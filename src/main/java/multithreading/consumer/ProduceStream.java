package multithreading.consumer;

public class ProduceStream implements Runnable {

    private Stream stream;

    public ProduceStream(Stream stream) {
        super();
        this.stream = stream;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            try {
                stream.generate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("Consumed " + stream.broadcast());
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
