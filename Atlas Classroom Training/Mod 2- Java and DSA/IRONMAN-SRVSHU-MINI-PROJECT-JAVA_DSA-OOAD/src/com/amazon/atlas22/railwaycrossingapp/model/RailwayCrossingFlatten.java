package com.amazon.atlas22.railwaycrossingapp.model;

public class RailwayCrossingFlatten {
    String name;
    String Address;
    int status;
    String from;
    String to;
    String InCharge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getInCharge() {
        return InCharge;
    }

    public void setInCharge(String inCharge) {
        InCharge = inCharge;
    }

    public RailwayCrossingFlatten(String name, String address, int status, String from, String to, String inCharge) {
        this.name = name;
        Address = address;
        this.status = status;
        this.from = from;
        this.to = to;
        InCharge = inCharge;
    }

    @Override
    public String toString() {
        String crossingStatus = (status == 1) ? "OPEN" : "CLOSE";
        String returnText = "~~~~~~~~~~~~~~~~~~~~~"+name+"~~~~~~~~~~~~~~~~~~~~"+
                "\nCrossing name:" + name +
                "\nCrossing Address:" + Address +
                "\nCrossing Status:" + crossingStatus +
                "\nScheduled Closing from: " + from +
                "\nScheduled Closing Till: " + to +
                "\nCrossing Person InCharge:" + InCharge +
                "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
        return returnText;
    }
}
