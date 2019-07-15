package Refactoring;

public class RegularMoviePrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        if (daysRented > 2) {
           return  (daysRented - 2) * 1.5;
        }
        return 2;
    }
}
