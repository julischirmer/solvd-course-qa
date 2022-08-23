package com.solvd.homework2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.function.Consumer;

public class Exam {
    private static Logger console = LogManager.getLogger(Exam.class.getName());
    private LocalDate examdate;
    private int examnumber;
    private LinkedList<Professor> professors;
    private Subject subject;
    private LinkedList<Student> students;

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

    public void setProfessors(LinkedList<Professor> professors) {
        this.professors = professors;
    }

    public void setSubject (Subject subject){
        this.subject = subject;
    }

    public Subject getSubject(){
        return this.subject;
    }


    Consumer<Professor> addProfessor = (Professor) -> {
        console.info(Professor);
        professors.add(Professor);
    };


    @Override
    public String toString() {
        return "Exam{" +
                "examdate=" + examdate +
                ", examnumber=" + examnumber +
                ", professors=" + professors +
                '}';
    }
}
