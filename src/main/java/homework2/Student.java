package homework2;

import homework2.exceptions.InvalidMailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class Student extends Person {

    private static Logger console = LogManager.getLogger(Student.class.getName());
    private double averagemark;

    public Student(int dni, String name, String lastname, String mail, LocalDate birthday) throws InvalidMailException {
        this.setDni(dni);
        this.setName(name);
        this.setLastname(lastname);
        this.setMail(mail);
        this.setBirthday(birthday);

    }


    public Student(int dni) {
        this.setDni(dni);
    }

    public static void findStudent(LinkedList<Student> students) {

        try {
            Scanner scanner = new Scanner(System.in);

            console.info("Insert dni to find student: ");
            Student studentcompare = new Student(scanner.nextInt());

            if (students.contains(studentcompare)) {
                console.info("The student was found ");
                Student studentFind = students.get(students.indexOf(studentcompare));
                console.info(studentFind);

            } else {
                console.warn("The student wasn't found");
            }
        } catch (InputMismatchException e) {
            console.error("The DNI must be a number");
            console.info("The program keeps working...");
        }


    }

    public double getAverageMark() {
        return averagemark;
    }

    public void setAverageMark(double averageMark) {
        this.averagemark = averageMark;
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "dni=" + getDni() +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                "averagemark=" + averagemark +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        if (getDni() != person.getDni()) {
            return false;
        }
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getDni());
    }

    @Override
    public void getDegree() {
        System.out.println("The student doesn't have a degree");
    }


}
