package com.solvd.homework2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class Exam {
    private static Logger console = LogManager.getLogger(Exam.class.getName());
    private LocalDate examdate;
    private int examnumber;
    private LinkedList<Professor> professors;
    private Subject subject;
    private LinkedList<Student> students;

    private LinkedList<String> studentsnames;

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

    public LinkedList<String> getStudentsnames() {
        return studentsnames;
    }

    public void setStudentsnames(LinkedList<String> studentsnames) {
        this.studentsnames = studentsnames;
    }

    Consumer<Professor> addProfessor = (Professor) -> {
        console.info(Professor);
        professors.add(Professor);
    };

    Consumer<Student> addStudent = (Student) -> {
        console.info(Student);
        students.add(Student);
    };

    public LinkedList<String> getStudentsNames (LinkedList<Student> students){
        LinkedList<String> names = new LinkedList<>();
        for (Student s:students) {
            names.addLast(s.getName());
        }
        setStudentsnames(names);
        return studentsnames;
    }

    public void toLowerCaseNames(LinkedList<String> studentsnames){
        studentsnames.stream().map(x -> x.toLowerCase()).forEach(x -> console.info(x));
    }

    public void countStudents(LinkedList<Student> students){
        long count = students.stream().count();
        console.info("The quantity of students enroll for the exam are: " + count);
    }

    public void matchNames(LinkedList<String> studentsnames, String name){
        toLowerCaseNames(studentsnames);
        console.info(studentsnames);
        studentsnames.stream().filter(x -> x.equals(name)).forEach(x->console.info(x));
    }

    public void sortedNamesAtoZ(LinkedList<String> studentsnames){
        studentsnames.stream().sorted().forEach(x->console.info(x));
    }

    public void sortedNamesZtoA(LinkedList<String> studentsnames){
        studentsnames.stream().sorted((x,y)-> y.compareTo(x)).forEach(x->console.info(x));
    }

    public void distinctNames(LinkedList<String> studentsnames){
        studentsnames.stream().distinct().forEach(x->console.info(x));
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
