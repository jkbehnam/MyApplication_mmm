package com.example.myapplication.Models;

public class AppDetailModel {
    public long Id;
    public String Name;
    public String Version;
    public String releaseData;

    public AppDetailModel(String name, String version, String releaseData) {
        this.Name = name;
        this.Version = version;
        this.releaseData = releaseData;
    }
}
