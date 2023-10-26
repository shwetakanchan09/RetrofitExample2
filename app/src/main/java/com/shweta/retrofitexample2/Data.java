package com.shweta.retrofitexample2;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    int id;

    @SerializedName("employee_name")
    String employeeName;

    @SerializedName("employee_salary")
    int employeeSalary;

    @SerializedName("employee_age")
    int employeeAge;

    @SerializedName("profile_image")
    String profileImage;


    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeSalary(int employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public int getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }
    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public String getProfileImage() {
        return profileImage;
    }

}
