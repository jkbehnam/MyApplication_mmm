package com.example.myapplication.Models;

public class CustomerModel {
    public long Id;
   public String name;
    public String mobile;

    public CustomerModel(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }
}
