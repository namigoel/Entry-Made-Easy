package com.parul.termproject;

public class CampusOut {
    private String name;
    private String rollNO;

    public CampusOut () {

    }

    public CampusOut(String name, String rollNO) {
        this.name = name;
        this.rollNO = rollNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNO() {
        return rollNO;
    }

    public void setRollNO(String rollNO) {
        this.rollNO = rollNO;
    }
}
