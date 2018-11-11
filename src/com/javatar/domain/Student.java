
package com.javatar.domain;


public class Student {
     int id;
    String name;
    int rollNo;
    double fee;
    String address;
    String school;
    String username;
    String password;
    String DOB;
    String email;
    String gender;
    
   
    public Student(){
    }

    public Student(int id, String name, int rollNo, double fee, String address, String school, String username, String password, String DOB, String email) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.fee = fee;
        this.address = address;
        this.school = school;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.email = email;
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

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    
    
}
    

