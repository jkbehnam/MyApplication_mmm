package com.example.myapplication.Models;

public class SubscriptionListModel {
    public long Id;
    public String AppName;
    public String SubName;
    public String StartDate;
    public String EndDate;
    public boolean IsActive;

    public SubscriptionListModel(long id, String appName, String subName, String startDate, String endDate, boolean isActive) {
        Id = id;
        AppName = appName;
        SubName = subName;
        StartDate = startDate;
        EndDate = endDate;
        IsActive = isActive;
    }
}
