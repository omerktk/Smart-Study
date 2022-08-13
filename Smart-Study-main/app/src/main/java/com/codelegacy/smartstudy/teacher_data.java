package com.codelegacy.smartstudy;

public class teacher_data {
    public String t_name;
    public String t_user;
    public String t_pass;

    public teacher_data() {
    }

    public teacher_data(String t_name, String t_user, String t_pass) {
        this.t_name = t_name;
        this.t_user = t_user;
        this.t_pass = t_pass;
    }

    public String getT_name() {
        return t_name;
    }

    public String getT_user() {
        return t_user;
    }

    public String getT_pass() {
        return t_pass;
    }
}
