package com.example.backupbudgit.assets;

public class Car extends Asset{
    private int age;
    private String model;
    private String make;
    private double mpg;
    private Condition condition;

    public Car(int id, double value, double interest, String name, int age, String model, String make, double mpg, Condition condition) {
        super(id, value, interest, name);
        this.age = age;
        this.model = model;
        this.make = make;
        this.mpg = mpg;
        this.condition = condition;
    }

    public Car(int id, int age, String model, String make, double mpg, Condition condition) {
        super(id);
        this.age = age;
        this.model = model;
        this.make = make;
        this.mpg = mpg;
        this.condition = condition;
    }

    public Car(int id){
        super(id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public double getMpg() {
        return mpg;
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}