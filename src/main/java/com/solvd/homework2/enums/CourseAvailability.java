package com.solvd.homework2.enums;

public enum CourseAvailability {
    AVAILABLE("The course has quota available"),
    FULL ("The course is full");

    private String courseAvailability;
    CourseAvailability(String courseAvailability){
        this.courseAvailability = courseAvailability;
    }

    public String getCourseAvailability(){
        return this.courseAvailability;
    }

}
