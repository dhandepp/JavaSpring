package multithreading.basics;

public class SolutionSynchronized {
    public static void main(String[] args){
        AccountSynchronized sync = new AccountSynchronized();

        Thread lucy = new Thread(sync,"Lucy");
        Thread fred = new Thread(sync,"Fred");

        lucy.start();
        fred.start();
    }
}
