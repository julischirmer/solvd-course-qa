package com.solvd.homework2;

import com.solvd.homework2.enums.Grade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentExam {

    private Logger console = LogManager.getLogger(StudentExam.class.getName());

    private Grade grade;
    private Exam exam;
    private Student student;

    public Logger getConsole() {
        return console;
    }

    public StudentExam(Exam exam, Grade grade, Student student){
        setExam(exam);
        setGrade(grade);
        setStudent(student);
    }

    public void setConsole(Logger console) {
        this.console = console;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

/*    public void setGrade() {

        console.info("1. Distinction \n 2. Merit \n 3. Pass \n 4. Fail");
        switch (data){
            case (1):
                console.info("");

        }
    }*/

}
