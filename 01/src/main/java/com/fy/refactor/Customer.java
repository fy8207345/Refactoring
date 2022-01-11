package com.fy.refactor;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental){
        _rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String htmlStatement(){
        Enumeration<Rental> rentals = _rentals.elements();

        return "";
    }

    public String statement(){
        Enumeration<Rental> rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while (rentals.hasMoreElements()){
            Rental each = rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
        }

        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getFrequentPoints() + " frequent renter points";
        return result;
    }

    private double getTotalCharge(){
        double result = 0;
        Enumeration<Rental> rentalEnumeration = _rentals.elements();
        while (rentalEnumeration.hasMoreElements()){
            Rental rental = rentalEnumeration.nextElement();
            result += rental.getCharge();
        }
        return result;
    }

    private int getFrequentPoints(){
        int result = 0;
        Enumeration<Rental> rentalEnumeration = _rentals.elements();
        while (rentalEnumeration.hasMoreElements()){
            Rental rental = rentalEnumeration.nextElement();
            result += rental.getFrequentPoints();
        }
        return result;
    }

}
