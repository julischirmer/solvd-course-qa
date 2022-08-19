package homework2;

public class Department {
    private int idDeparment;
    private String descDepartment; //Systems, Law, Science, etc.


    public int getIdDeparment() {
        return idDeparment;
    }

    public void setIdDeparment(int idDeparment) {
        this.idDeparment = idDeparment;
    }

    public String getDescDepartment() {
        return descDepartment;
    }

    public void setDescDepartment(String descDepartment) {
        this.descDepartment = descDepartment;
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "iddeparment=" + idDeparment +
                ", descdepartment='" + descDepartment + '\'' +
                '}';
    }
}
