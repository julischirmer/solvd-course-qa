package com.solvd.homework2.enums;

public enum Grade {

    DISTINCTION,MERIT,PASS,FAIL;

    public String getGrade() {
        String data = "";
        switch (this) {
            case DISTINCTION:
                data = "Distinction";
                break;
            case MERIT:
                data = "Merit";
                break;
            case PASS:
                data = "Pass";
                break;
            case FAIL:
                data = "Fail";
                break;
            default:
                data = null;
        }
        return data;
    }

}
