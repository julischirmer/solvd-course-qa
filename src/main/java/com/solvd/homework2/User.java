package com.solvd.homework2;

import com.solvd.homework2.enums.UserAccess;
import com.solvd.homework2.interfaces.IRegister;

public class User implements IRegister {

    private String username;
    private String password;
    private String userAccess;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    @Override
    public void setAccess() {

    }
}
