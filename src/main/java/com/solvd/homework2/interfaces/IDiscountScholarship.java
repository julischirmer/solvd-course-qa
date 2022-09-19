package com.solvd.homework2.interfaces;

import com.solvd.homework2.Student;
import java.util.Collection;

public interface ICheckUser<T extends Student, K extends Collection> {
    default T checkUser(int id, K peopleList) {
        return null;
    }
}
