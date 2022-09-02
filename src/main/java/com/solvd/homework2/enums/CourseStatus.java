package com.solvd.homework2.enums;

public enum CourseStatus {
    OPEN, CLOSE;

    public String getCourseStatus() {
        String data = "";
        switch (this) {
            case OPEN:
                data = "The course is open to enrollment";
                break;
            case CLOSE:
                data = "\"The course is close to enrollment";
                break;
            default:
                data = null;
        }
        return data;
    }
}
