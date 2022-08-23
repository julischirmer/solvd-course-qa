package com.solvd.homework2;

import com.solvd.homework2.enums.Grade;
import com.solvd.homework2.interfaces.IRegister;

public class Enrollment implements IRegister {

    private int idEnrollment;
    private Student student;
    private String grade = null;

    public Enrollment(int id, Student student) {
        setIdEnrollment(id);
        setStudent(student);
    }

    public int getIdEnrollment() {
        return idEnrollment;
    }

    public void setIdEnrollment(int idInscription) {
        this.idEnrollment = idInscription;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGrade(String grade){
        this.grade = Grade.valueOf(grade).getGrade();
    }

    public String getGrade(){
        return this.grade;
    }


    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void modify() {

    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "idEnrollment=" + idEnrollment +
                ", student=" + student +
                ", grade='" + grade + '\'' +
                '}';
    }
}
