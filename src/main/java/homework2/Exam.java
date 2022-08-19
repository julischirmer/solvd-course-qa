package homework2;

import java.time.LocalDate;
import java.util.LinkedList;

public class Exam {

    private LocalDate examdate;
    private int examnumber;
    private LinkedList<Professor> professors;
    private Subject subject;

/*    public Exam(LocalDate examdate, int examnumber, LinkedList<Professor> professors) {

        this.setExamdate(examdate);
        this.setExamnumber(examnumber);
        this.setProfessors(professors);
    }*/

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

    @Override
    public String toString() {
        return "Exam{" +
                "examdate=" + examdate +
                ", examnumber=" + examnumber +
                ", professors=" + professors +
                '}';
    }
}
