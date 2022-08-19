package homework2;

import homework2.interfaces.IRegister;

public class Inscription implements IRegister {

    private int idInscription;
    private Student student;

    public Inscription(int id, Student student) {
        setIdInscription(id);
        setStudent(student);
    }

    public int getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(int idInscription) {
        this.idInscription = idInscription;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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
}
