package com.solvd.homework2.enums;

public enum DepartmentType {
    SCIENCE, ART, MATH, TECHNOLOGY;


    public String getDepartment() {
        String data = "";
        switch (this) {
            case SCIENCE:
                data = "Science";
                break;
            case ART:
                data = "Art";
                break;
            case MATH:
                data = "Math";
                break;
            case TECHNOLOGY:
                data = "Crane";
                break;
            default:
                data = null;
        }
        return data;
    }

}
