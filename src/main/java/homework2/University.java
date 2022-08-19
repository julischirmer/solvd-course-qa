package homework2;

import homework2.generics.CustomLinkedList;

import java.util.LinkedList;

public class University {
    private String name;
    private String location;
    private CustomLinkedList<Course> courses = new CustomLinkedList<>();

    public University(String name, CustomLinkedList<Course> courses) {
        this.setName(name);
        this.setCourses(courses);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CustomLinkedList<Course> getCourses() {
        return courses;
    }

    public void setCourses(CustomLinkedList<Course> courses) {
        this.courses = courses;
    }

    public void getCoursesSize(LinkedList<Course> courses) {
        System.out.println("The number of available courses are" + courses.size());
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course); // VER
    }



    @Override
    public String toString() {
        return "\nUniversity{" +
                "universityname='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
