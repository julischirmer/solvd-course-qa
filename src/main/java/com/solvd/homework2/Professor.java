package com.solvd.homework2;

import com.solvd.homework2.exceptions.InvalidSalary;
import com.solvd.homework2.interfaces.ISalaryBonus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Professor extends Person {
    private static Logger console = LogManager.getLogger(Fee.class.getName());
    private double salary;

    public Professor(int dni, String name, String lastname, double salary) {
        this.setDni(dni);
        this.setName(name);
        this.setLastname(lastname);
        try {
            this.setSalary(salary);
        } catch (InvalidSalary e) {
            System.out.println(e.getMessage());
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws InvalidSalary {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new InvalidSalary("The salary must be upper than zero");
        }

    }

    public void increaseSalary(){
        console.info("Insert the amount of u$d to increase: ");
        double bonus = 100;
        ISalaryBonus increase = (total) -> {
            this.salary = this.salary + total;
        };
        increase.increaseSalary(bonus);
    }



    @Override
    public String toString() {
        return "\nProfessor{" +
                "dni=" + this.getDni() +
                ", name=" + this.getName() +
                ", last name=" + this.getLastname() +
                ", salary=" + salary +
                '}';
    }

    @Override
    public void getDegree() {
        System.out.println("This is an abstract method of Professor");
    }
}
