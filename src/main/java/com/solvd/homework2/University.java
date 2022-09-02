package com.solvd.homework2;

import com.solvd.homework2.interfaces.IData;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.function.LongFunction;

public class University implements IData {
    private String name;
    private String location;
    private String countryResidence;

    private LinkedList<Student> attendingStudents;

    public University(String name, String location) {
        this.setName(name);
        this.setLocation(location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    @Override
    public void setCountryResidence(String country) {
        this.countryResidence = countryResidence;
    }

    @Override
    public String getCountryResidence() {
        if(this.getCountryResidence().isEmpty()){
            return "The University hasn't a Country Residence";
        } else {
            return "The country of residence of the University is:" + this.getCountryResidence();
        }
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", countryResidence='" + countryResidence + '\'' +
                ", attendingStudents=" + attendingStudents +
                '}';
    }
}
