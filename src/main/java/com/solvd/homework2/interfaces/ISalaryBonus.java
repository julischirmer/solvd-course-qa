package com.solvd.homework2.interfaces;
@FunctionalInterface
public interface ISalaryBonus<T> {
    void increaseSalary(T percent);
}
