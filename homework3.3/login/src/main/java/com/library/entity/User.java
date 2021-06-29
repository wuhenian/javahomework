package com.library.entity;

public class User {
    /**
     * 用户账号
     */
    private String unum;

    /**
     * 用户姓名
     */
    private String uname;

    /**
     * 登录密码
     */
    private String upass;

    public User() {
    }

    public User(String unum, String uname, String upass) {
        this.unum = unum;
        this.uname = uname;
        this.upass = upass;
    }

    public String getUnum() {
        return unum;
    }

    public void setUnum(String unum) {
        this.unum = unum;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    @Override
    public String toString() {
        return "User{" +
                "unum='" + unum + '\'' +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                '}';
    }
}
