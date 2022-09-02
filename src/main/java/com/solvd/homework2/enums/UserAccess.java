package com.solvd.homework2.enums;

public enum UserAccess {
    ADMIN, STUDENT, PROFESSOR;

    public String getGrade() {
        String data = "";
        switch (this) {
            case ADMIN:
                data = "Admin";
                break;
            case STUDENT:
                data = "Merit";
                break;
            case PROFESSOR:
                data = "Pass";
                break;
            default:
                data = null;
        }
        return data;
    }

}
