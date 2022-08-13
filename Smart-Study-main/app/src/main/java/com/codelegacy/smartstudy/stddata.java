package com.codelegacy.smartstudy;

public class stddata {
    public  String s_name;
    public String s_age;
    public String s_username;
    public String s_password;

    public stddata() {
    }

    public stddata(String s_name, String s_age, String s_username, String s_password) {
        this.s_name = s_name;
        this.s_age = s_age;
        this.s_username = s_username;
        this.s_password = s_password;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_age() {
        return s_age;
    }

    public String getS_username() {
        return s_username;
    }

    public String getS_password() {
        return s_password;
    }
}
