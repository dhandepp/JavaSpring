package Refactoring;

public abstract class Price {
    public abstract double getCharge(int daysIdentified);
    public boolean isEligibleForBonus(){
        if(this instanceof NewReleaseMoviePrice){
            return true;
        }
        return false;
    }
}
