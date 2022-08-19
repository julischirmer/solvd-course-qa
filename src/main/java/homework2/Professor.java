package homework2;

import homework2.exceptions.InvalidSalary;

public final class Professor extends Person {
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
