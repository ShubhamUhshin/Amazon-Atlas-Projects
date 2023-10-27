package com.amazon.atlas22.railwaycrossingapp.model;

import java.io.Serializable;
import java.util.LinkedHashMap;

public class RailwayCrossing implements Serializable {
    String name;
    String address;
    int status; //1-open 2-closed
    User personInCharge;
    LinkedHashMap<String,String> schedules;

    public RailwayCrossing() {
    }

    public RailwayCrossing(String name, String address, int status, User personInCharge, LinkedHashMap<String, String> schedules) {
        this.name = name;
        this.address = address;
        this.status = status;
        this.personInCharge = personInCharge;
        this.schedules = schedules;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(User personInCharge) {
        this.personInCharge = personInCharge;
    }

    public LinkedHashMap<String, String> getSchedules() {
        return schedules;
    }

    public void setSchedules(LinkedHashMap<String, String> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String toString() {

        String crossingStatus = (status == 1) ? "OPEN" : "CLOSE";
        String railwayCrossingText = "~~~~~~~~~~~~~~~~~~~~~"+name+"~~~~~~~~~~~~~~~~~~~~\n"
                +"Crossing Name: "+name+"\n"
                +"Crossing Address: "+address+"\n"
                +"Crossing Status: "+crossingStatus+"\n"
                +"Crossing Schedule: "+schedules.toString()+"\n"
                +"Crossing Person InCharge: "+personInCharge.getName()+"\n"
                +"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        return railwayCrossingText;
    }
}
