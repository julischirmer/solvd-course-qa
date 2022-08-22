package com.solvd.homework2;


import java.time.LocalDate;
import java.util.LinkedList;

public class Exam {

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

    @Override
    public String toString() {
        return "Exam{" +
                "examdate=" + examdate +
                ", examnumber=" + examnumber +
                ", professors=" + professors +
                '}';
    }
}
