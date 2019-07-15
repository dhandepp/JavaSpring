package Refactoring;

public class NewReleaseMoviePrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
