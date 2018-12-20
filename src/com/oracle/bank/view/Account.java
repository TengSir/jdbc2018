package com.oracle.bank.view;

public class Account {
    private String accNo;
    private String accPass;
    private String realname;
    private String sex;
    private int age;
    private float money;

    public Account() {
    }

    public Account(String accNo, String accPass, String realname, String sex, int age, float money) {
        this.accNo = accNo;
        this.accPass = accPass;
        this.realname = realname;
        this.sex = sex;
        this.age = age;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNo='" + accNo + '\'' +
                ", accPass='" + accPass + '\'' +
                ", realname='" + realname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public String getAccPass() {
        return accPass;
    }

    public void setAccPass(String accPass) {
        this.accPass = accPass;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
