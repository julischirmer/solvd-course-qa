package com.solvd.homework2;


import com.solvd.homework2.exceptions.InvalidCourseCostException;
import com.solvd.homework2.exceptions.InvalidMonthNumberException;
import com.solvd.homework2.interfaces.IDiscount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public final class Fee {

    private static Logger console = LogManager.getLogger(Fee.class.getName());

    private int month; // 0 January - 11 December
    private boolean isPay; // True = Pay the month fee & false = don't pay the month fee
    private Student student;
    private double costPerMonth;
    private Course course;

    public Fee(Student student, int month, boolean isPay, Course course) {
        try {
            this.setStudent(student);
            this.setMonthFee(month);
            this.setCourse(course);
        } catch (InvalidMonthNumberException e) {
            console.info(e.getMessage());
        }
        this.setPay(isPay);
    }

    private void setCourse(Course course) {
        this.course = course;
    }

    public static void isUpToday(Student student, Fee fee) {
        int monthNow = LocalDate.now().getMonthValue();
        if (fee.getMonthFee() == monthNow && fee.isPay == true) {
            console.info("The student: " + student.getName() + " is up to date with the fee");
        } else {
            console.info("The student: " + student.getName() + " is not up to date with the fee");
        }
    }

    public static void DiscountScholarship(Student student, Course course){
        if (student.getAverageMark()>9){
            IDiscount disc = () -> {
                console.info("Congrats! You have more than 9 in your average mark");
                console.info("You will have 25% of discount in your course");
                double newCost = course.getCost()*0.75;
                double newFee = newCost/12;
                console.info("Your new monthly fee is: " + newFee);
            };
            disc.goodAverageMarkDiscount();
        } else {
            console.info("You don't have an average mark greater than 9" +
                    "so you can't have an scholarship");
        }
    }

    public static Fee createFee() throws InvalidMonthNumberException, InvalidCourseCostException {
        Scanner scanner = new Scanner(System.in);
        console.info("Insert student dni");
        int dni = scanner.nextInt();
        console.info("Insert number month 0 January - 11 December");
        int month = scanner.nextInt();
        int pay = 2;
        boolean isPay = false;
        while (pay != 0 && pay != 1) {
            console.info("is Pay? 1: true 0: false");
            pay = scanner.nextInt();
            if (pay == 0) {
                isPay = false;
            } else if (pay == 1) {
                isPay = true;
            } else {
                console.info("The answer must be 0 or 1");
            }
        }
        Student student = new Student(dni);

        console.info("Insert id course");
        int idcourse = scanner.nextInt();
        console.info("Insert course cost");
        double price = scanner.nextDouble();
        console.info("Insert course name");
        String name = scanner.next();
        Course course = new Course(idcourse,price,name);
        Fee fee = new Fee(student,month, isPay,course);
        System.out.println(fee);
        return fee;

    }

    public int getMonthFee() {
        return month;
    }

    public void setMonthFee(int month) throws InvalidMonthNumberException {
        if (month >= 0 && month <= 11) {
            this.month = month;
        } else {
            throw new InvalidMonthNumberException("The month must be an integer between 0 January to 11 December");
        }

    }

    public boolean isPay() {
        return isPay;
    }

    public void setPay(boolean pay) {
        isPay = pay;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Fee{month=" + month +
                ", isPay=" + isPay +
                '}';
    }
}
