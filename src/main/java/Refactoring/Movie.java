package Refactoring;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
        initPrice();
    }

    public void initPrice() {
        switch (_priceCode) {
            case REGULAR:
                _price = new RegularMoviePrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleaseMoviePrice();
                break;
            case CHILDRENS:
                _price = new ChildrensMoviePrice();
                break;
        }
    }

    public String getTitle() {
        return _title;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        // For new release movie, if rented for more than 2 days, bonus rental point
        if (_price.isEligibleForBonus() && daysRented > 2) {
            return 2;
        }
        return 1;
    }


}
