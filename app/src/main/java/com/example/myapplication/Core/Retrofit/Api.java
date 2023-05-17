package com.example.myapplication.Core.Retrofit;

import com.example.myapplication.Models.ApiModel.ApiGetToken;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("/api/Users/GetToken")
    Call <ApiGetToken> GetMenuToken(@Query("userName") String userName, @Query("password") String password);
}
