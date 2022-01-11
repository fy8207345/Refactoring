package com.fy.refactor;

import static com.fy.refactor.Movie.*;

public abstract class Price {
    abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public int getFrequentPoints(int daysRented){
        return 1;
    }
}
