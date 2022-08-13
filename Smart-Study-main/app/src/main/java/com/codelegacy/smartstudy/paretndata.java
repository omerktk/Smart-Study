package com.codelegacy.smartstudy;

public class paretndata {
    public String name;
    public String user;
    public String pass;

    public paretndata() {
    }

    public paretndata(String name, String user, String pass) {
        this.name = name;
        this.user = user;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
