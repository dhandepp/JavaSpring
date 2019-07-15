package Refactoring;

public class RefacApp {
    public static void main(String[] args){
        Movie t1 = new Movie("Terminator 1",0);
        Movie t2 = new Movie("Terminator 2",1);
        Movie t3 = new Movie("Terminator 3",2);

        Rental r1 = new Rental(t1,5);
        Rental r2 = new Rental(t2,2);
        Rental r3 = new Rental(t3, 1);

        Customer ch = new Customer("Chandler");
        ch.addRental(r1);
        ch.addRental(r2);
        ch.addRental(r3);

        System.out.println(ch.htmlStatement());
    }
}
