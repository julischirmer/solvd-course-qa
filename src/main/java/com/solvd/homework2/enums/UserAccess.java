package com.solvd.homework2.enums;

public enum UserAccess {
    ADMIN ("Admin"),
    STUDENT ("Student"),
    PROFESSOR ("Professor");

    private String userAccess;
    UserAccess(String userAccess){
        this.userAccess = userAccess;
    }

    public String getUserAccess(){
        return userAccess;
    }


}
