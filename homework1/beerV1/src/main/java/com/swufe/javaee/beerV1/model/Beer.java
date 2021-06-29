package com.swufe.javaee.beerV1.model;

public class Beer {
    private String brand;
    private double price;
    private String color;
    private int degree;

    Beer(String brand,double price,String color,int degree){
        this.brand = brand;
        this.price = price;
        this.color = color;
        this.degree = degree;
    }

    public String toString(){
        return ("The brand is "+brand + '/' +
                "the price is " + price + '/' +
                "the color is " + color + '/'
                + "the degree is " + degree);
    }

}
