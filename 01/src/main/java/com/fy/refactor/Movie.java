package com.fy.refactor;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;


    private String title;
    private Price _price;

    public Movie(String title, int priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        switch (priceCode){
            case REGULAR:
                _price = new RegularPrice();
                break;
            case CHILDRENS:
                _price = new ChildrenPrice();
                break;
            case NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrent price code");
        }
    }

    //determine amounts for aRental line
    public double getCharge(int daysRented){
        return _price.getCharge(daysRented);
    }

    public int getFrequentPoints(int daysRented){
        //add bonus for a two day new release rental
        if(getPriceCode() == NEW_RELEASE && daysRented > 1){
            return 2;
        }
        return 1;
    }
}
