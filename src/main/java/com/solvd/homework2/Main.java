package com.solvd.homework2;

import com.solvd.homework2.enums.DepartmentType;
import com.solvd.homework2.exceptions.InvalidCourseCostException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.function.*;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws InvalidCourseCostException {

        LinkedList<Course> courses = new LinkedList<>();

        University harvard = new University("Harvard", "Cambridge, Massachusetts");

        Student student1 = new Student(111, "Julian", 6.30);
        Student student2 = new Student(112, "Carlos", 7.40);

        Professor professor1 = new Professor(2000, "Juan", "Perez", 1000);
        Professor professor2 = new Professor(2001, "Miguel", "Adriano", 1300);

        DepartmentType tech = DepartmentType.TECHNOLOGY;

        Course IA = new Course(555, 12000, "Artificial Intelligent", tech);
        Course QA = new Course(556, 10000, "QA Testing Automation", tech);

        Subject java = new Subject(110000, "Java Language");
        Subject SQL = new Subject(110001, "MySQL");

        QA.addSubject(java);
        QA.addSubject(SQL);

        QA.addStudent(student1);
        QA.addStudent(student2);

        IA.addStudent(student1);

        Enrollment enrol = new Enrollment(00001, student1, QA);
        Enrollment enrol2 = new Enrollment(00001, student2, IA);

        Exam QAexam = new Exam(0002, java);
        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);

        QAexam.setStudents(students);

        // Streams
        List<String> names = QAexam.getStudentsNames();
        logger.info("To lower case names:");
        QAexam.toLowerCaseNames(names);

        logger.info("Find Julian name");
        QAexam.findName(names, "Julian");

        QAexam.countStudents();

        logger.info("names sorted");
        QAexam.sortedNamesAtoZ(names);

        logger.info("Full names students list: ");
        logger.info(names);
        logger.info("Same list with distinct");
        QAexam.distinctNames(names);


        professor1.increaseSalary(150);
        logger.info("Professors increase salary: u$d " + professor1.getSalary());

        // util Function
        Course.getCostCourse(QA);
        Course.isStudentEnroll(student1,IA);




/*
        Function<Department, Integer> funct = (x) -> {
          return y;
        };
*/




        // Scholarship discount example
/*
        student1.setAverageMark(10);
        Fee fee = new Fee(student1,1,true,QA);
        fee.DiscountScholarship(student1,QA);
        fee.isUpToday(student1,fee);
*/









    }

}

/*

public static void lambdaUtils(){
        lambdaUtilConsumer();
        longFunction();
        intToDouble();
        lambdaUtilPredicated();
    }

    public static void intToDouble(){
        // IntToDouble
        Professor professor = new Professor(1111,"Julian","Perez", 100);

        IntToDoubleFunction toDouble = (dni) -> {
            return Double.parseDouble(Integer.toString(dni));
        };

        double dniToDouble = toDouble.applyAsDouble(professor.getDni());
        console.info(dniToDouble);
    }

    public static void lambdaUtilConsumer() throws NullPointerException{
        Exam exam = new Exam(1111, new Subject(1111, "QA Testing"));
        Consumer<Professor> addProfessor = (Professor) -> {
            console.info(Professor);
            exam.getProfessors().addLast(Professor);
        };

        Professor professorTesting = new Professor(121212,"Carlos","Nicole",1000);
        addProfessor.accept(professorTesting);
        console.info(exam.getProfessors());
    }

    public static void longFunction() {
        long University1 = 10000;
        long University2 = 15000;
        long University3 = 25000;
        LongFunction longexample = (total) -> {
            total = University1 + University2 + University3;
            return total;
        };
        long total = 0;
        long totalStudents = (long) longexample.apply(total);
        console.info(totalStudents);
    }

    public static void lambdaUtilPredicated (){
        Professor miguel = new Professor(2020,"Miguel","Guemez", 1000);
        Professor juan = new Professor(1515,"Juan", "Belgrano", 2000);
        BiPredicate professor = (name1, name2) -> {
            if(name1.equals(name2)){
                return true;
            } else {
                return false;
            }
        };
        boolean answer = professor.test(miguel.getName(),juan.getName());
        console.info(answer);
    }

*/





