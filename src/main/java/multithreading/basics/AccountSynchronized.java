package multithreading.basics;

public class AccountSynchronized implements Runnable {
    Accounts account;

    public AccountSynchronized() {
        account = new Accounts();
    }

    public synchronized void withDraw() {
        System.out.println(Thread.currentThread().getName() + " is checking balance");
        if (account.getBalance() > 10) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withDraw();
            System.out.println(Thread.currentThread().getName() + " has withdrawn");
        } else {
            System.out.println("No balance " + Thread.currentThread().getName());
        }

    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            withDraw();
        }
    }
}
