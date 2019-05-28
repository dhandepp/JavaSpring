package multithreading.consumer;

public class InterThread {
    public static void main(String[] args){
        Stream stream = new Stream();
        ProduceStream producer = new ProduceStream(stream);
        BroadCaster cosumer = new BroadCaster(stream);

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(cosumer);

        t1.start();
        t2.start();
    }

}
