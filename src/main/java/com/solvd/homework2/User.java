package com.solvd.homework2;

import com.solvd.homework2.enums.UserAccess;

public class User {

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
    public String getUserAccess(){
        return this.userAccess;
    }
    public void setUserAccess(String userAccess){
        this.userAccess = UserAccess.valueOf(userAccess).getUserAccess();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
