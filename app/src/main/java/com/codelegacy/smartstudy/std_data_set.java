package com.codelegacy.smartstudy;

public class std_data_set {
    public String sname;
    public String saddress;
    public String sage;
    public String semail;
    public String suser;
    public String spass;

    public std_data_set() {
    }

    public std_data_set(String sname, String saddress, String sage, String semail, String suser, String spass) {
        this.sname = sname;
        this.saddress = saddress;
        this.sage = sage;
        this.semail = semail;
        this.suser = suser;
        this.spass = spass;
    }

    public String getSname() {
        return sname;
    }

    public String getSaddress() {
        return saddress;
    }

    public String getSage() {
        return sage;
    }

    public String getSemail() {
        return semail;
    }

    public String getSuser() {
        return suser;
    }

    public String getSpass() {
        return spass;
    }
}
