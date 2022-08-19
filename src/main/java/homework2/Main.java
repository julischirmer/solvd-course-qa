package homework2;

import homework2.exceptions.InvalidCourseCostException;
import homework2.exceptions.InvalidMailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static Logger console = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            console.info("This is info");
            run();
        } catch (InvalidCourseCostException e) {
            System.out.println(e.getMessage());
        } catch (InvalidMailException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void run() throws InvalidCourseCostException, InvalidMailException {

        LinkedList<Student> students = new LinkedList<>();

        Student student = new Student(111, "Julián", "Schirmer",
                "j@gmail.com", LocalDate.of(2001, 10, 30));
        Student student2 = new Student(112, "Carlos", "Perez",
                "c@gmail.com", LocalDate.of(1999, 2, 14));

        students.add(student);
        students.add(student2);


        Course testAutomationCourse = new Course(2424, 1000, "Test Automation");
        Course dataScienceCourse = new Course(2525, 1200, "Data Science");
        testAutomationCourse.setStudents(students);
        // dataScienceCourse.setStudents(students);

        Subject subject1testAutomation = new Subject(5454, "Java Language");
        Subject subject2testAutomation = new Subject(6464, "SQL");
        LinkedList<Subject> subjectstestAutomation = new LinkedList<>();
        subjectstestAutomation.add(subject1testAutomation);
        subjectstestAutomation.add(subject2testAutomation);


        testAutomationCourse.setSubjects(subjectstestAutomation);

        LinkedList<Course> courses = new LinkedList<>();
        courses.add(testAutomationCourse);
        courses.add(dataScienceCourse);


        menu(students, courses);

    }

    public static void menu(LinkedList<Student> students, LinkedList<Course> courses) throws InvalidCourseCostException {

        int opc = 1;
        while (opc != 5) {
            System.out.println("Chose an option: \n 1. Create Course \n 2. Find student by dni \n 3. Cost of a Course" +
                    " \n 4.Is the course available? \n 5. See subjects per course \n 6.  \n 7. Exit");
            Scanner scanner = new Scanner(System.in);
            opc = scanner.nextInt();
            switch (opc) {
                case 1: {
                    // Create new course
                    System.out.println(Course.createCourse());
                    break;
                }

                case 2: {
                    // Find student by dni
                    Student.findStudent(students);
                    console.info("Info");
                    break;
                }
                case 3: {
                    // What is the cost of a course?
                    Course.getCourseCost(courses);
                    break;
                }
                case 4: {
                    //Is the course available?
                    Course.isTheCourseAvailable(courses);
                    break;

                }
                case 5: {
                    // What are the subjects in a course
                    Course.getCourseSubjects(courses);
                    break;
                }
                case 6: {
                    // Create Fee
                    Fee.createFee();
                    break;
                }
                case 7: {
                    System.out.println("End");
                    System.out.close();
                    break;
                }
                default: {
                    System.out.println("Choose only the allowed options");
                    break;
                }
            }

        }
    }

}

