package com.solvd.homework2.enums;

public enum CourseStatus {
    OPEN("The course is open to enrollment"),
    CLOSE("The course is close to enrollment");

    private String status;

    CourseStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
