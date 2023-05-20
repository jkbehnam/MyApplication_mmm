package com.example.myapplication.Models.ApiModel;





import com.google.gson.annotations.SerializedName;

import saman.zamani.persiandate.PersianDate;
import saman.zamani.persiandate.PersianDateFormat;

public class ApiGetAppListModel {
    public long id;

    @SerializedName("appName")
    public String name;

    public String getReleaseData() {
        PersianDate pDate = new PersianDate(ReleaseData*1000);
        PersianDateFormat pdformater1 = new PersianDateFormat("Y/m/d");
        pdformater1.format(pDate);
        return pdformater1.format(pDate);
    }

    @SerializedName("latestVersionName")
    public String version;
    @SerializedName("latestVersionReleaseDate")
    public long ReleaseData;

    public ApiGetAppListModel(String name, String version, long releaseData) {
        this.name = name;
        this.version = version;
        this.ReleaseData = releaseData;
    }
}
