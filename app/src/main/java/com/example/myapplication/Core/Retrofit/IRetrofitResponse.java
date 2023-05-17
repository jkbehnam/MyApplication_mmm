package com.example.myapplication.Core.Retrofit;

public interface IRetrofitResponse<T> {
    void onSuccess(T response);
    void onFail(T response);
   // void onFailure(Throwable throwable);
}