package com.swufe.javaee.beerV1.model;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {

    public List getBrands(String color) {
        List<Beer> beer = new ArrayList<>();
        if (color.equals("amber")) {
            beer.add(new Beer("Jack Amber", 1000, "red", 15));
        } else {
            beer.add(new Beer("Red Mouse", 2000, "white", 20));
        }
        return (beer);
    }

}
