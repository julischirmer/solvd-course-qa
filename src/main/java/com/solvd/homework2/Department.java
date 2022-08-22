package com.solvd.homework2;

import com.solvd.homework2.enums.Deparment;

public class Department {
    private int idDeparment;
    private String descDepartment; //Science, Math, Art, Technology.


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
        this.descDepartment = Deparment.valueOf(descDepartment).getDeparment();
    }

    @Override
    public String toString() {
        return "\nDepartment{" +
                "iddeparment=" + idDeparment +
                ", descdepartment='" + descDepartment + '\'' +
                '}';
    }
}
