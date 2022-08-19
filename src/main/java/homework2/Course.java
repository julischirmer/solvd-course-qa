package homework2;

import homework2.exceptions.InvalidCourseCostException;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Course {

    private static final int total = 150;
    private int idCourse;
    private String name;
    private LinkedList<Subject> subjects = new LinkedList<>();
    private LinkedList<Student> students = new LinkedList<>();
    private double cost;


    public Course(int idcourse, double price, String name) throws InvalidCourseCostException {
        this.setIdCourse(idcourse);
        this.setName(name);
        this.setCost(price);
    }

    public Course() {

    }

    public Course(int idCourse) {
        this.setIdCourse(idCourse);
    }

    public static void isTheCourseAvailable(LinkedList<Course> courses) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert course ID");
            Course course = new Course(scanner.nextInt());
            if (courses.contains(course)) {
                Course coursefinded = courses.get(courses.indexOf(course));
                if (coursefinded.getAvailability() > 0) {
                    System.out.println("The Course is available");
                    System.out.println("The course quota is: " + coursefinded.getAvailability());
                } else {
                    System.out.println("The Course is completed");
                }
            } else {
                System.out.println("The id Course doesn't exist");
            }
        } catch (InputMismatchException e) {
            System.out.println("The course id must be a number");
            System.out.println("The program keeps working...");
        }
    }

    public static void getCourseCost(LinkedList<Course> courses) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert course ID");
            Course course = new Course(scanner.nextInt());
            if (courses.contains(course)) {
                Course coursefind = courses.get(courses.indexOf(course));
                System.out.println("The course: " + coursefind.getName() + " has the cost: u$d " + coursefind.getCost());
            } else {
                System.out.println("The course doesn't exist");
            }
        } catch (InputMismatchException e) {
            System.out.println("The course id must be a number");
            System.out.println("The program keeps working...");
        }
    }

    public static void getCourseSubjects(LinkedList<Course> courses) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Insert course ID");
            Course course = new Course(scanner.nextInt());
            if (courses.contains(course)) {
                Course coursefinded = courses.get(courses.indexOf(course));
                System.out.println(coursefinded.getSubjects());
            } else {
                System.out.println("The id Course doesn't exist");
            }
        } catch (InputMismatchException e) {
            System.out.println("The course id must be a number");
            System.out.println("The program keeps working...");
        }
    }

    public static Course createCourse() throws InvalidCourseCostException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert course name");
        String nameCourse = scanner.nextLine();
        System.out.println("Insert course ID");
        int courseId = scanner.nextInt();
        System.out.println("Insert cost course");
        double courseprice = scanner.nextDouble();
        Course course = new Course(courseId, courseprice, nameCourse);
        return course;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idcourse) {
        this.idCourse = idcourse;
    }

    public LinkedList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(LinkedList<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) throws InvalidCourseCostException {
        if (cost < 0) {
            throw new InvalidCourseCostException("The cost can't be negative");
        } else {
            this.cost = cost;
        }
    }

    public int getAvailability() {
        return (this.total - students.size());
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "idCourse=" + idCourse +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return idCourse == course.idCourse;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCourse);
    }


}
