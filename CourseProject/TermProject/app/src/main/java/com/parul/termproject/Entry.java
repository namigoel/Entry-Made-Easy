package com.parul.termproject;

public class Entry {
    String name;
    String rollNo;
    String category;
    String deptt;
    boolean status;

    public Entry () {

    }

    public Entry(String name, String rollNo, String category, String deptt, boolean status) {
        this.name = name;
        this.rollNo = rollNo;
        this.category = category;
        this.deptt = deptt;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeptt() {
        return deptt;
    }

    public void setDeptt(String deptt) {
        this.deptt = deptt;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}