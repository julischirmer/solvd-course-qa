package com.solvd.homework2.enums;

public enum CourseAvailability {
    AVAILABLE,FULL;

    public String getCourseAvailability() {
        String data = "";
        switch (this) {
            case AVAILABLE:
                data = "The course has quota available";
                break;
            case FULL:
                data = "The course is full";
                break;
            default:
                data = null;
        }
        return data;
    }

}
