package com.solvd.homework2.exceptions;

public class InvalidSalary extends Exception {

    public InvalidSalary() {

    }

    public InvalidSalary(String msgError) {
        super(msgError);
    }
}
