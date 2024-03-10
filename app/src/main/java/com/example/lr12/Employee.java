package com.example.lr12;

public class Employee {

    private int id;

    private String full_name;


    private String position;

    public Employee(String full_name, String position) {
        this.full_name = full_name;
        this.position = position;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public  String toString(){
        return "Имя: " + full_name + " Должность: " + position;
    }

}
