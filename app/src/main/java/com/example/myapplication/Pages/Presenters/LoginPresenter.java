package com.example.myapplication.Pages.Presenters;

import android.widget.Toast;

import com.example.myapplication.Core.Retrofit.IRetrofitResponse;
import com.example.myapplication.Core.Retrofit.RetrofitClient;
import com.example.myapplication.Models.ApiModel.ApiGetToken;
import com.example.myapplication.Pages.LoginActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    LoginActivity loginActivity;

    public LoginPresenter(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }


    public void Login(String loginEtUsername, String loginEtPassword) {
        if (checkValidation(loginEtUsername) && checkValidation(loginEtPassword)) {
                 retrofitLogin(loginEtUsername, loginEtPassword, new IRetrofitResponse() {
                     @Override
                     public void onSuccess(Object response) {
                         Toast.makeText(loginActivity, "login", Toast.LENGTH_SHORT).show();
                     }

                     @Override
                     public void onFail(Object response) {

                     }
                 });
        } else {
            loginActivity.loginFail("فرمت نام کاربری یا پسورد صحیح نیست");
        }
    }

    public boolean checkValidation(String username) {

        // تعیین الگوی نام کاربری: شامل حروف الفبای انگلیسی بزرگ و کوچک، اعداد و آندرلاین (_)، بین ۳ تا ۱۶ کاراکتر
        String usernameRegex = "^[a-zA-Z0-9_]{3,16}$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private void retrofitLogin(String loginEtUsername, String loginEtPassword, IRetrofitResponse iRetrofitResponse) {
        Call<ApiGetToken> call = RetrofitClient.getInstance().getMyApi().GetMenuToken(loginEtUsername,loginEtPassword);
        call.enqueue(new Callback<ApiGetToken>() {
            @Override
            public void onResponse(Call<ApiGetToken> call, Response<ApiGetToken> response) {
              //  List<Results> myheroList = response.body();

                String i=response.body().Data.TokenValue;
               // String j=response.body().Data.UserId;
            }

            @Override
            public void onFailure(Call<ApiGetToken> call, Throwable t) {
                loginActivity.loginFail("فرمت نام کاربری یا پسورد صحیح نیست");
            }

        });
    }
}
