package com.solvd.homework2;

import com.solvd.homework2.generics.CustomLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class Subject {
    private int idSubject;
    private String name;
    private LinkedList<Professor> professors;

    public Subject(int idSubject) {
        this.setIdSubject(idSubject);
    }

    public Subject(int idSubject, String name) {
        this.setIdSubject(idSubject);
        this.setName(name);
    }


    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addProfessor(Professor professor) {
        this.professors.addLast(professor);
    }


    @Override
    public String toString() {
        return "\nSubject{" +
                "idsubject=" + idSubject +
                ", name='" + name +
                '}';
    }
}
