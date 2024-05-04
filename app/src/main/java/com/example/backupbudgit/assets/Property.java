package com.example.backupbudgit.assets;

public class Property extends Asset {
    private int age;
    private String address;

    public Property(int id, double value, double interest, String name, int age, String address) {
        super(id, value, interest, name);
        this.age = age;
        this.address = address;
    }

    public Property(int id, int age, String address) {
        super(id);
        this.age = age;
        this.address = address;
    }

    public Property(int id){
        super(id);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
