package com.example.myapplication.Models;

public class PlanModel {
    public long Id;
   public String Name;
   public String Description;
   public int Days;
   public int MaxUsers;

    public PlanModel(long id, String name, String description, int days, int maxUsers) {
        Id = id;
        Name = name;
        Description = description;
        Days = days;
        MaxUsers = maxUsers;
    }
}
