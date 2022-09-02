package com.solvd.homework2;


import com.solvd.homework2.enums.Grade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.function.BiPredicate;

public class Exam {
    public final Logger logger = LogManager.getLogger(Exam.class.getName());
    private LocalDate examdate;
    private int examnumber;
    private LinkedList<Professor> professors;
    private Subject subject;
    private LinkedList<Student> students;

    private Grade grade = null;


    public Exam(int examnumber, Subject subject) {

        this.setExamdate(examdate);
        this.setSubject(subject);
    }

    public LocalDate getExamdate() {
        return examdate;
    }

    public void setExamdate(LocalDate examdate) {
        this.examdate = examdate;
    }

    public int getExamnumber() {
        return examnumber;
    }

    public void setExamnumber(int examnumber) {
        this.examnumber = examnumber;
    }

    public LinkedList<Professor> getProfessors() {
        return professors;
    }

    public void newProffesor() {
        addProfessor.accept(new Professor(111,"Carlos", "Daniel", 1000));
    }

    public void setSubject (Subject subject){
        this.subject = subject;
    }

    public Subject getSubject(){
        return this.subject;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    Consumer<Professor> addProfessor = (Professor) -> {
        logger.info(Professor);
        professors.add(Professor);
    };

    Consumer<Student> addStudent = (Student) -> {
        logger.info(Student);
        students.addLast(Student);
    };

    public void addStudent(Student student){
        this.students.add(student);
    }
    public List<String> getStudentsNames (){
        return this.students.stream().map(student -> student.getName()).collect(Collectors.toList());
    }

    // STREAMS

    public void toLowerCaseNames(List<String> studentsnames){
        studentsnames.stream().map(x -> x.toLowerCase()).forEach(x -> logger.info(x));
    }

    public void countStudents(){
        long count = students.stream().count();
        logger.info("The quantity of students enroll for the exam are: " + count);
    }

    public void findName(List<String> studentsnames, String name){
        studentsnames.stream().filter(x -> x.equals(name)).forEach(x->logger.info(x));
    }

    public void sortedNamesAtoZ(List<String> studentsNames){
        studentsNames.stream().sorted().forEach(x->logger.info(x));
    }

    public void sortedNamesZtoA(List<String> studentsNames){
        studentsNames.stream().sorted((x,y)-> y.compareTo(x)).forEach(x->logger.info(x));
    }

    public void distinctNames(List<String> studentsnames){
        studentsnames.stream().distinct().forEach(x->logger.info(x));
    }

    // util.function

    public void BiPredicate(){
        BiConsumer<Integer,Integer> addTwo = (x, y) -> logger.info(x+y);
        addTwo.accept(5,5);
    }


    @Override
    public String toString() {
        return "Exam{" +
                "examdate=" + examdate +
                ", examnumber=" + examnumber +
                ", professors=" + professors +
                '}';
    }
}
