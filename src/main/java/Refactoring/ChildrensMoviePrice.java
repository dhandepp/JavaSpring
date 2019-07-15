package Refactoring;

public class ChildrensMoviePrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        if (daysRented > 3) {
            return (daysRented - 3) * 1.5;
        }
        return 1.5;
    }
}
