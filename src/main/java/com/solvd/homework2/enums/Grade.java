package com.solvd.homework2.enums;

public enum Grade {

    DISTINCTION("Distinction"),
    MERIT("Merit"),
    PASS("Pass"),
    FAIL("Fail");

    private String designation;

    Grade(String designation) {
        this.designation = designation;
    }

    public String getGrade() {
        return designation;
    }

}
