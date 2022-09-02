package com.solvd.homework2.functionalInterfaces;
@FunctionalInterface
public interface IAvailability<U,R> {
    R availability(U total, U enroll);
}
