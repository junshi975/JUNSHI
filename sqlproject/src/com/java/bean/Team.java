package com.java.bean;

/**
 * @author JUNSHI 405773808@qq.com
 * @description:
 * @create 2020-04-07 23:19
 */
public class Team {

    private int TID;//团队TID
    private int ID;//员工ID
    private String name;//员工姓名
    private int age;//员工年龄
    private double salary;//员工薪资
    private String position;//员工职位
    private double bonus;//员工奖金
    private double stock;//员工股票

    public Team() {
    }

    public Team(int ID, String name, int age, double salary, String position, double bonus, double stock) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.bonus = bonus;
        this.stock = stock;
    }

    public Team(int TID, int ID, String name, int age, double salary) {
        this.TID = TID;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Team(int TID, int ID, String name, int age, double salary, String position) {
        this.TID = TID;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }

    public Team(int TID, int ID, String name, int age, double salary, String position, double bouns) {
        this.TID = TID;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.bonus = bouns;
    }

    public Team(int TID, int ID, String name, int age, double salary, String position, double bouns, double stock) {
        this.TID = TID;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.bonus = bouns;
        this.stock = stock;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBouns() {
        return bonus;
    }

    public void setBouns(double bouns) {
        this.bonus = bouns;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
//        System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");

        String teamDetails = "" + getTID() + "/" + getID() + "\t" + "\t" + getName() + "\t" + getAge() + "\t\t" + getSalary() + "\t" + getPosition() + "\t" + getBouns() + "\t\t" + getStock();
        return teamDetails;
    }
}
