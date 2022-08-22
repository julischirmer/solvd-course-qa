package com.solvd.homework2.enums;

public enum Deparment {
    SCIENCE("Science"),
    ART("Art"),
    MATH("Math"),
    TECHNOLOGY("Technology");

    private String deparment;
    Deparment(String deparment){
        this.deparment = deparment;
    }

    public String getDeparment(){
        return this.deparment;
    }

}
