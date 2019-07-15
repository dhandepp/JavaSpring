package Refactoring;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public String getName() {
        return _name;
    }

    public void addRental(Rental rental) {
        _rentals.add(rental);
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // footer
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You have earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement(){
        Enumeration rentals = _rentals.elements();
        String result = "<h1> Rentals for <em>" + getName() + "</em></h1>\n";
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            // show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<br>\n";
        }

        // footer
        result += "<p> You owe <em>" + String.valueOf(getTotalAmount()) + "</em>\n";
        result += "On this rental you have earned <em>" + String.valueOf(getTotalFrequentRenterPoints()) + "</em> frequent renter points</p>";
        return result;
    }

    public double getTotalAmount(){
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result+= each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints(){
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result+= each.getFrequentRenterPoints();
        }
        return result;
    }
}
