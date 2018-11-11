
package com.javatar.domain;

public class Teacher {
    int id;
    String name;
    String department;
    double salary;
    String school;
    String address;

    public Teacher() {
    }

    public Teacher(int id, String name, String department, double salary, String school, String address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.school = school;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
    
}
