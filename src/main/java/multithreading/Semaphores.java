package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Semaphores {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(50);

        for (int i = 0; i < 200; i++) {
            service.submit(() -> Connection.getInstance().doConnect());
        }

    }

}

class Connection {
    private static Connection connection;
    private int connections;
    Semaphore semaphore = new Semaphore(3, true);

    public static Connection getInstance() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    public void doConnect() {
        try {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                System.out.println("Connection till now " + ++connections);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            doRelease();
        }
    }

    private void doRelease() {
        synchronized (this) {
            --connections;
        }
        semaphore.release();
    }
}
