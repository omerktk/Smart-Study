package com.codelegacy.smartstudy;

public class Student {

    public String stdid;
    public String enrollno;
    public String stdname;
    public String age;
    public String semail;
    public String spass;

    public Student()
    {

    }


    public Student(String stdid, String enrollno, String stdname, String age, String semail, String spass) {
        this.stdid = stdid;
        this.enrollno = enrollno;
        this.stdname = stdname;
        this.age = age;
        this.semail = semail;
        this.spass = spass;
    }


    public String getStdid() {
        return stdid;
    }

    public String getEnrollno() {
        return enrollno;
    }

    public String getStdname() {
        return stdname;
    }

    public String getAge() {
        return age;
    }

    public String getSemail() {
        return semail;
    }

    public String getSpass() {
        return spass;
    }
}
