package com.solvd.homework2;

import com.solvd.homework2.generics.CustomLinkedList;

import java.util.LinkedList;

public class Subject {
    private int idSubject;
    private String name;
    private CustomLinkedList<Professor> professors;

    public Subject(int idSubject) {
        this.setIdSubject(idSubject);
    }

    public Subject(int idSubject, String name, CustomLinkedList<Professor> professors) {
        this.setIdSubject(idSubject);
        this.setName(name);
        this.setProfessors(professors);

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
        this.professors.insert(professor);
    }

    public CustomLinkedList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(CustomLinkedList<Professor> professors) {
        this.professors = professors;
    }

    @Override
    public String toString() {
        return "\nSubject{" +
                "idsubject=" + idSubject +
                ", name='" + name +
                '}';
    }
}
