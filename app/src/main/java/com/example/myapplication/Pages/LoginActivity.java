package com.example.myapplication.Pages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Core.BaseActivity;
import com.example.myapplication.Pages.Presenters.LoginPresenter;
import com.example.myapplication.databinding.ActivityLoginBinding;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends BaseActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        LoginPresenter loginPresenter = new LoginPresenter(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        binding.lgBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showProgressDialog();
                loginSuccessfull();
                loginPresenter.Login(binding.loginEtUsername.getText().toString(), binding.loginEtPassword.getText().toString());
            }
        });
    }

    public void loginSuccessfull() {
        dimissPD();
        Intent intent = new Intent(LoginActivity.this, NavHostActivity.class);
        startActivity(intent);
    }

    public void loginFail(String massage) {
        dimissPD();
        Toasty.warning(this, massage, Toast.LENGTH_SHORT, true).show();
    }

    public void showPD() {
        showProgressDialog();
    }

    public void dimissPD() {
        DimissProgressDialog();
    }

    public void saveLoginInfo(String username,String password){

        SharedPreferences sharedPref = this.getSharedPreferences(
                PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(username, null);
        editor.putString(password, null);
        editor.apply();

    }
}